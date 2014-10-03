#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// za string shranjujemo naslov in dolzino
struct string {
    char* addr;
    size_t len;
};

struct string read_file(char* fname) {
    // depends on blocksize
    size_t read_size = 1024;
    struct string s = {NULL, 0};
    FILE * in = fopen(fname, "r");
    if (in == 0) { return s; }
    s.addr = malloc(read_size);
    if (s.addr == 0) { return s; }
    s.len = 1024;
    char* cursor = s.addr;
    size_t just_read = 0;
    while ((just_read = fread(cursor, sizeof(char), read_size, in))) {
        cursor += just_read;
        if (cursor + read_size >= s.addr + s.len) {
            s.addr = realloc(s.addr, s.len * 2);
            if (s.addr == 0) { s.len = 0; return s; }
            s.len *= 2;
        }
    }
    s.len = cursor - s.addr;
    s.addr = realloc(s.addr, s.len);
    fclose(in);
    return s;
}

struct lines {
    struct string* lines;
    size_t len;
};

// pozor stringi ni null terminirani, uporabi fwrite
struct lines split_lines(struct string s) {
    struct lines ls = {NULL, 0};
    size_t bufsize = 16;
    ls.lines = malloc(sizeof(struct string) * bufsize);
    ls.lines[0].addr = s.addr;
    ls.len = 1;
    for (size_t i = 0; i < s.len; ++i) {
        if (s.addr[i] == '\n')
        { 
            ls.lines[ls.len].addr = &s.addr[i+1];
            ls.lines[ls.len-1].len = ls.lines[ls.len].addr - ls.lines[ls.len-1].addr;
            ++ls.len;
            if (ls.len == bufsize) {
                bufsize *= 2;
                ls.lines = realloc(ls.lines, sizeof(struct string)*bufsize);
            }
        }
    }
    ls.lines[ls.len].len = (s.addr + s.len) - ls.lines[ls.len].addr;
    ls.lines = realloc(ls.lines, sizeof(struct string)*ls.len);
    --ls.len;
    return ls;
}
int str_hash(struct string s) {
    int hash = 0;
    for (size_t i = 1; i <= s.len; ++i) {
        hash += i * s.addr[i-1];
    }
    return hash;
}

struct int_array {
    int * addr; 
    size_t buf_len; 
    size_t len; 
};

int max(int a, int b)
{
    return a > b ? a : b;
}
void lcs(struct int_array a, struct int_array b, int ** c) {
    int i, j;
    for (i = 1; i < a.len + 1; ++i)
    {
        for (j = 1; j < b.len + 1; ++j)
        {
            if (a.addr[i - 1] == b.addr[j - 1])
            {
                c[i][j] = c[i-1][j-1] + 1;
            }
            else
            {
                c[i][j] = max(c[i][j-1], c[i-1][j]);
            }
        }
    }
}
void traverse(struct int_array a, struct int_array b, struct int_array diff, int ** c, int i, int j)
{
    if (i == 0 || j == 0)
    {
        return;
    }
    else if (a.addr[i - 1] == b.addr[j - 1])
    {
        diff.addr[diff.len] = a.addr[i - 1];
        diff.len++;
        traverse(a, b, diff, c, i - 1, j - 1);
    }
    else
    {
        if (c[i][j-1] > c[i-1][j])
        {
            traverse(a, b, diff, c, i, j - 1);
        }
        else
        {
            traverse(a, b, diff, c, i - 1, j);
        }
    }
}

void diff3(char * input1_name, char * input2_name, char * out_name) {


    /* fwrite(test1.lines[i].addr, test1.lines[i].len, 1, stdout); */
    struct lines input1 = split_lines(read_file(input1_name));
    struct lines input2 = split_lines(read_file(input2_name));

    int i;

    FILE * out = fopen(out_name, "w");

    if (input1.lines[0].addr == NULL && input2.lines[0].addr == NULL)
    {
    }
    else if (input1.lines[0].addr == NULL)
    {
        for (i = 0; i < input2.len; ++i)
        {
            fwrite(input2.lines[i].addr, 1, 1, out);
        }
        fwrite("\n", 1, 1, out);
    }
    else if (input2.lines[0].addr == NULL)
    {
        for (i = 0; i < input1.len; ++i)
        {
            fwrite(input1.lines[i].addr, 1, 1, out);
        }
        fwrite("\n", 1, 1, out);
    }
    else
    {
        struct int_array input1_hash = {malloc(sizeof(int)*input1.len), input1.len, 0};
        struct int_array input2_hash = {malloc(sizeof(int)*input2.len), input2.len, 0};

        int ** matrika = calloc(input1.len + 1, sizeof(int*));


        for (i = 0; i < input1.len; ++i)
        {
            input1_hash.addr[i] = str_hash(input1.lines[i]);
            input1_hash.len++;
            matrika[i] = calloc(input2.len + 1, sizeof(int));
        }
        matrika[input1.len] = calloc(input2.len + 1, sizeof(int));
        for (i = 0; i < input2.len; ++i)
        {
            input2_hash.addr[i] = str_hash(input2.lines[i]);
            input2_hash.len++;
        }

        lcs(input1_hash, input2_hash, matrika);
        int diffsize = matrika[input1_hash.len][input2_hash.len];
        struct int_array diff = {malloc(sizeof(int)*diffsize), diffsize, 0};
        traverse(input1_hash, input2_hash, diff, matrika, input1_hash.len, input2_hash.len);
        diffsize--;
        int pos1 = 0, pos2 = 0;
        while (diffsize >= 0)
        {
            for (i = pos1; i < input1_hash.len; ++i)
            {
                if (diff.addr[diffsize] == input1_hash.addr[i])
                {
                    if (diffsize != 0)
                    {
                        pos1 = i+1;
                        break;
                    }
                }
                else
                {
                    fprintf(out, "%c", input1.lines[i].addr[0]);
                }
            }
            for (i = pos2; i < input2_hash.len; ++i)
            {
                if (diff.addr[diffsize] == input2_hash.addr[i])
                {
                    if (diffsize != 0)
                    {
                        pos2 = i+1;
                        break;
                    }
                }
                else
                {
                    fprintf(out, "%c", input2.lines[i].addr[0]);
                }
            }
            diffsize--;
        }
        fprintf(out, "\n");

        fclose(out);
    }
}
int main(int argc, char *argv[]) {
    if (argc != 4)
    {
        printf("usage: %s filename-1 filename-2 ... filename-n\n", argv[0]);
    }
    else
    {
        diff3(argv[1], argv[2], argv[3]);
    }
    return 0;
}
