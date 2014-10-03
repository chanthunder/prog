#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int prepisiFileVTabelo(FILE * ptr, char ** out);
//print First Char In Line
void pFCIL(FILE * ptr, FILE * OUT);

// Jst se na tvojem mestu nebi dotiku te kode ker je too advanced. Tut nebi je v tvoji nalogi uporabu

/* struct string { */
/*     char* addr; */
/*     size_t len; */
/* }; */
/*  */
/* struct string read_file(char* fname) { */
/*     size_t read_size = 1024; */
/*     struct string s = {NULL, 0}; */
/*     FILE * in = fopen(fname, "r"); */
/*     if (in == 0) { return s; } */
/*     s.addr = malloc(read_size); */
/*     if (s.addr == 0) { return s; } */
/*     s.len = 1024; */
/*     char* cursor = s.addr; */
/*     size_t just_read = 0; */
/*     while ((just_read = fread(cursor, sizeof(char), read_size, in))) { */
/*         cursor += just_read; */
/*         if (cursor + read_size >= s.addr + s.len) { */
/*             s.addr = realloc(s.addr, s.len * 2); */
/*             if (s.addr == 0) { s.len = 0; return s; } */
/*             s.len *= 2; */
/*         } */
/*     } */
/*     s.len = cursor - s.addr; */
/*     s.addr = realloc(s.addr, s.len); */
/*     fclose(in); */
/*     return s; */
/* } */
/*  */
/* struct lines { */
/*     struct string* lines; */
/*     size_t len; */
/* }; */
/*  */
/* struct lines split_lines(struct string s) { */
/*     struct lines ls = {NULL, 0}; */
/*     size_t bufsize = 16; */
/*     ls.lines = malloc(sizeof(struct string) * bufsize); */
/*     ls.lines[0].addr = s.addr; */
/*     ls.len = 1; */
/*     for (size_t i = 0; i < s.len; ++i) { */
/*         if (s.addr[i] == '\n') */
/*         {  */
/*             ls.lines[ls.len].addr = &s.addr[i+1]; */
/*             ls.lines[ls.len-1].len = ls.lines[ls.len].addr - ls.lines[ls.len-1].addr; */
/*             ++ls.len; */
/*             if (ls.len == bufsize) { */
/*                 bufsize *= 2; */
/*                 ls.lines = realloc(ls.lines, sizeof(struct string)*bufsize); */
/*             } */
/*         } */
/*     } */
/*     (ls.lines)[ls.len].len = (s.addr + s.len) - (ls.lines)[ls.len].addr; */
/*     ++ls.len; */
/*     ls.lines = realloc(ls.lines, sizeof(struct string)*ls.len); */
/*     return ls; */
/* } */
/* int str_hash(struct string s) { */
/*     int hash = 0; */
/*     for (size_t i = 0; i < s.len; ++i) { */
/*         hash += i * s.addr[i]; */
/*     } */
/*     return hash; */
/* }; */

int max(int a, int b)
{
    return a > b ? a : b;
}
void lcs(char ** a, char ** b, int lena, int lenb, int ** c) {
    int i, j;
    for (i = 1; i < lena; ++i)
    {
        for (j = 1; j < lenb; ++j)
        {
            if (strcmp(a[i-1], b[j-1]) == 0)
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
void traverse(char ** a, char ** b, int ** c, int i, int j, int stevec, char ** diff)
{
    if (i == 0 || j == 0)
    {
        return;
    }
    else if (strcmp(a[i-1], b[j-1]) == 0)
    {
        diff[stevec] = malloc(sizeof(char)*(strlen(a[i-1]) + 1));
        strcpy(diff[stevec], a[i-1]);
        stevec++;
        traverse(a, b, c, i-1, j-1, stevec, diff);
    }
    else
    {
        if (c[i][j-1] > c[i-1][j])
        {
            traverse(a, b, c, i, j-1, stevec, diff);
        }
        else
        {
            traverse(a, b, c, i-1, j, stevec, diff);
        }
    }
}

void diff3(char * input1_name, char * input2_name, char * out_name) {
    FILE * input1 = fopen(input1_name, "r");
    FILE * input2 = fopen(input2_name, "r");
    FILE * out = fopen(out_name, "w");
    // oba fajla sta prazna, torej je sporocilo prazno
    if (input1 == 0 && input2 == 0)
    {
        return;
    }
    else if (input1 == 0 || input2 == 0)
    {
        if (input1 == 0)
        {
            pFCIL(input2, out);
            return;
        }
        else
        {
            pFCIL(input1, out);
            return;
        }
    }
    else 
    {
        char s[100 + 1];
        int i = 1;
        while (fgets(s, 101, input1) != NULL)
        {
            i++;
        }
        char ** kljuc = malloc(sizeof(char*)*(i-1));
        rewind(input1);
        int j = 1;
        while (fgets(s, 101, input2) != NULL)
        {
            j++;
        }
        char ** tajnopis = malloc(sizeof(char*)*(j-1));
        rewind(input2);
        prepisiFileVTabelo(input1, kljuc);
        prepisiFileVTabelo(input2, tajnopis);

        fclose(input1);
        fclose(input2);
        
        int ** matrika;
        matrika = calloc(i, sizeof(int*));
        int k;
        for (k = 0; k < i; ++k)
        {
            matrika[k] = calloc(j, sizeof(int));
        }

        lcs(kljuc, tajnopis, i, j, matrika);
        char ** diff = malloc(sizeof(char*) * matrika[i-1][j-1]);
        traverse(kljuc, tajnopis, matrika, i-1, j-1, 0, diff);

        k = matrika[i-1][j-1] - 1;
        i-=1;
        j-=1;
        int m, pos1 = 0, pos2 = 0;
        while (k >= 0)
        {
            for (m = pos1; m < i; ++m)
            {
                if (strcmp(diff[k], kljuc[m]) == 0)
                {
                    if (k != 0)
                    {
                        pos1 = m+1;
                        break;
                    }
                }
                else
                {
                    fprintf(out, "%c", kljuc[m][0]);
                }
            }
            for (m = pos2; m < j; ++m)
            {
                if (strcmp(diff[k], tajnopis[m]) == 0)
                {
                    if (k != 0)
                    {
                        pos2=m+1;
                        break;
                    }
                }
                else
                {
                    fprintf(out, "%c", tajnopis[m][0]);
                }
            }
            k--;
        }
        fprintf(out, "\n");

        fclose(out);
        for (k = 0; k < i - 1; ++k)
        {
            free(kljuc[k]);
            free(matrika[k]);
        }
        free(matrika[i-1]);
        free(matrika);
        free(kljuc);
        for (k = 0; k < matrika[i-1][j-1]; ++k)
        {
            free(diff[k]);
        }
        free(diff);
        for (k = 0; k < j - 1; ++k)
        {
            free(tajnopis[k]);
        }
        free(tajnopis);
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
//no string may be longer that 100 chars
void pFCIL(FILE * ptr, FILE * out) {
    char s[100 + 1];
    while (fgets(s, 101, ptr) != NULL)
        fprintf(out, "%c", s[0]);
    fprintf(out, "\n");
    fclose(out);
    fclose(ptr);
}
int prepisiFileVTabelo(FILE * ptr, char ** out) {
    char s[100 + 1];
    int i = 0;
    while (fgets(s, 101, ptr) != NULL)
    {
        out[i] = malloc(sizeof(char) * (strlen(s)+1));
        strcpy(out[i], s);
        i++;
    }
    return s != NULL ? 1 : 0;
}
