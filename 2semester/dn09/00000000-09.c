#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void quicksort(int* x, int * y, int * z, int zacetek, int konec);
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
    s.len = read_size;
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

struct string read_stdio() {
    // depends on blocksize
    size_t read_size = 1024;
    struct string s = {NULL, 0};
    s.addr = malloc(read_size);
    if (s.addr == 0) { return s; }
    s.len = read_size;
    char* cursor = s.addr;
    size_t just_read = 0;
    while ((just_read = fread(cursor, sizeof(char), read_size, stdin))) {
        cursor += just_read;
        if (cursor + read_size >= s.addr + s.len) {
            s.addr = realloc(s.addr, s.len * 2);
            if (s.addr == 0) { s.len = 0; return s; }
            s.len *= 2;
        }
    }
    s.len = cursor - s.addr;
    s.addr = realloc(s.addr, s.len);
    return s;
}


struct stack {
    char *s;
    struct stack *next;
};
struct stack * vrh = NULL;

void push(char * s) {
    char *p;
    struct stack *q;

    if ((p=malloc((strlen(s)+1)*sizeof(char))) == NULL) { exit(1); }
    strcpy(p, s); 
    if ((q=malloc(sizeof(struct stack))) == NULL) { exit(1); }
    q -> s = p;
    q -> next = vrh;
    vrh = q;
}
char * pop() {
    char *p;
    struct stack *q;

    if (vrh == NULL) { return NULL; }
    q = vrh;
    vrh = vrh->next;
    p = q->s;
    free(q);
    return p;
}



struct int_array {
    int * addr;
   size_t len; 
};
struct xml {
    struct int_array studId;
    struct int_array assId;
    struct int_array points;
};


int structStringToInt(struct string s) {
    if (s.addr == NULL) { return 0; }
    int i, a = 0;
    for (i = 0; i < s.len; i++)
    {
      if(s.addr[i] >= '0' && s.addr[i] <= '9') { a = (a * 10) + (s.addr[i] - '0'); }
    }
    return a;
}
// pozor stringi ni null terminirani, uporabi fwrite
struct xml parse_xml(struct string s) {

    struct xml ls = {{0,0}, {0,0}, {0,0}};
    int buffer = 16;
    ls.studId.addr = malloc(sizeof(int)*buffer);
    ls.assId.addr = malloc(sizeof(int)*buffer);
    ls.points.addr = malloc(sizeof(int)*buffer);
    if (ls.studId.addr == NULL || ls.assId.addr == NULL || ls.points.addr == NULL) { exit(1); }
    char * p = malloc(sizeof(char)*(20));
    struct string tag = {NULL, 0};
    struct string xml = {NULL, 0};
    int stevec = 0;
    for (size_t i = 0; i < s.len; ++i) {
        if (s.addr[i] == '<')
        {
            tag.addr = &s.addr[i+1];
	    if (memcmp(tag.addr, "/vpisnaStevilka", 15) == 0) {
	        xml.len = &s.addr[i] - xml.addr;
	        stevec++;
		ls.studId.addr[ls.studId.len] = structStringToInt(xml);
		ls.studId.len++;
	    }
	    if (memcmp(tag.addr, "/nalogaId", 9) == 0) {
	        xml.len = &s.addr[i] - xml.addr;
	        stevec++;
		ls.assId.addr[ls.assId.len] = structStringToInt(xml);
		ls.assId.len++;
	    }
	    if (memcmp(tag.addr, "/vrednost", 9) == 0) {
	        xml.len = &s.addr[i] - xml.addr;
	        stevec++;
		ls.points.addr[ls.points.len] = structStringToInt(xml);
		ls.points.len++;
	    }
	    if (ls.studId.len == buffer || ls.assId.len == buffer || ls.points.len == buffer) {
		buffer *= 2;
		ls.studId.addr = realloc(ls.studId.addr, sizeof(int)*buffer);
		ls.assId.addr = realloc(ls.assId.addr, sizeof(int)*buffer);
		ls.points.addr = realloc(ls.points.addr, sizeof(int)*buffer);
    		if (ls.studId.addr == NULL || ls.assId.addr == NULL || ls.points.addr == NULL) { exit(1); }
	    }

	    if (stevec % 3 == 0 && ls.studId.len > 2)
	    {
	        for(size_t j = 0; j < ls.studId.len - 1; j++) {
		    if(ls.studId.addr[j] == ls.studId.addr[ls.studId.len-1] && ls.assId.addr[j] == ls.assId.addr[ls.assId.len-1])
		    {
		        ls.studId.addr[j] = ls.studId.addr[ls.studId.len-1];
		        ls.assId.addr[j] = ls.assId.addr[ls.studId.len-1];
		        ls.points.addr[j] = ls.points.addr[ls.points.len-1];
			ls.studId.len--;
			ls.assId.len--;
			ls.points.len--;
		    }
		}
	    }
        } else if(s.addr[i] == '>') {
            tag.len = &s.addr[i] - tag.addr;
            if (tag.addr[0] != '/')
            {
                memcpy(p, tag.addr, tag.len);
                p[tag.len] = '\0';
                push(p);
                if (memcmp(tag.addr, "vpisnaStevilka", tag.len) == 0) { xml.addr = &s.addr[i+1]; }
                if (memcmp(tag.addr, "nalogaId", tag.len) == 0) { xml.addr = &s.addr[i+1]; }
                if (memcmp(tag.addr, "vrednost", tag.len) == 0) { xml.addr = &s.addr[i+1]; }
		if (xml.addr != NULL && xml.addr[0] == '<') { printf("napaka 2\n"); exit(0); }
            }
            else
            {
                if (memcmp(pop(), &tag.addr[1], tag.len - 1) != 0) {  printf("napaka 3\n"); exit(0); }
            }
        }
    }
    if (ls.studId.len == 0) { printf("\n"); exit(0); }
    quicksort(ls.studId.addr, ls.assId.addr, ls.points.addr, 0, ls.studId.len-1);
    int start = ls.studId.addr[0];
    int numOfAss = 1;
    buffer = ls.points.addr[0];
    for (size_t i = 1; i < ls.studId.len; i++) {
	if(start != ls.studId.addr[i]) {
            printf("%08d %d %d\n", start, numOfAss, buffer);
	    numOfAss = 1;
	    start = ls.studId.addr[i];
	    buffer = ls.points.addr[i];
	}
	else
	{
	    buffer += ls.points.addr[i];
	    numOfAss++;
	}
    }
    printf("%d %d %d\n", start, numOfAss, buffer);
    return ls;
}


int max(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, char *argv[]) {
    struct string s = {NULL, 0};
    if (argc == 2)
    {
        s = read_file(argv[1]);
        if (s.addr == NULL) { printf("napaka 1\n"); exit(0); }
    }
    else
    {
        s = read_stdio();
        /* fread(s.addr, sizeof(char), read_size, "stdin"); */
    }
    parse_xml(s);
    return 0;
}
void quicksort(int* x, int * y, int * z, int zacetek, int konec) {
    int i, j, pivot, temp;
    if (zacetek < konec) {
        pivot = zacetek;
        i = zacetek;
        j = konec;

        while (i < j) {
            while ((x[i] < x[pivot] || (x[i] == x[pivot] && y[i] <= y[pivot])) && i < konec) {
                i++;
            }
            while(x[j] > x[pivot] || (x[j] == x[pivot] && y[j] > y[pivot])) {
                j--;
            }
            if(i<j) {
                temp=x[i];
                x[i]=x[j];
                x[j]=temp;
                temp=y[i];
                y[i]=y[j];
                y[j]=temp;
                temp = z[i];
                z[i] = z[j];
                z[j] = temp;
            } else {
                temp=x[pivot];
                x[pivot]=x[j];
                x[j]=temp;
                temp=y[pivot];
                y[pivot]=y[j];
                y[j]=temp;
                temp = z[pivot];
                z[pivot] = z[j];
                z[j] = temp;
                
            }
        }
        quicksort(x, y, z, zacetek, j-1);
        quicksort(x, y, z, j+1, konec);
    }
}
