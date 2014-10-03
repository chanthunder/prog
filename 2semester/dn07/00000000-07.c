#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>
#include <string.h>
#define MAXSTRING 100

typedef struct _stack stack;
struct _stack {
    char * string;
    stack * previous;
    stack * next;
};

void push(stack ** element, char * string);
char * pop(stack ** element);

int isEmpty(stack ** element) {
    return !*element;
}


int main(int argc, char *argv[]) {
    char * s = malloc(sizeof(char) * (MAXSTRING + 1));

    stack *  zacetek = NULL;
    stack *  konec = NULL;
    stack *  trajanje = NULL;
    stack *  potnikiGor = NULL;
    stack *  potnikiDol = NULL;

    stack *  zacetek1 = NULL;
    stack *  konec1 = NULL;
    stack *  trajanje1 = NULL;
    stack *  potnikiGor1 = NULL;
    stack *  potnikiDol1 = NULL;

    stack *  zacetek2 = NULL;
    stack *  konec2 = NULL;
    stack *  trajanje2 = NULL;
    stack *  potnikiGor2 = NULL;
    stack *  potnikiDol2 = NULL;

    int stevec = 0;
    int stikalo = 0;
    while (scanf("%s", s) != EOF && strcmp(s, "?") != 0)
    {
        char * p = malloc(sizeof(char) * (strlen(s) + 1));  
        strcpy(p, s);
        if (stevec == 0)
        {
            push(&zacetek, p);
        }
        else if (stevec == 1)
        {
            push(&konec, p);
        }
        else if (stevec == 2)
        {
            push(&trajanje, p);
        }
        else if (stevec == 3)
        {
            push(&potnikiGor, p);
        }
        else if (stevec == 4)
        {
            push(&potnikiDol, p);
        }
        stevec = (stevec + 1) % 5;
    }
    stevec = 0;
    char * p = malloc(sizeof(char) * (MAXSTRING + 1));
    strcpy(s, "");
    while (konec != NULL) 
    {
        if (strcmp(s, "") == 0)
        {
            s = pop(&konec);
            push(&konec2, s);
            push(&zacetek2, pop(&zacetek));
            push(&trajanje2, pop(&trajanje));
            push(&potnikiGor2, pop(&potnikiGor));
            push(&potnikiDol2, pop(&potnikiDol));
        } else {
            if (stevec) {
                p = pop(&konec);
                push(&zacetek1, pop(&zacetek));
                push(&konec1, p);
            }
            else {
                p = pop(&zacetek);
                push(&zacetek1, p);
                push(&konec1, pop(&konec));
            }
            push(&trajanje1, pop(&trajanje));
            push(&potnikiGor1, pop(&potnikiGor));
            push(&potnikiDol1, pop(&potnikiDol));
        }
        if (strcmp(s, p) == 0) 
        {
            stikalo = 1;
            if (stevec != 0)
            {
                s = pop(&zacetek1);
                push(&konec2, pop(&konec1));
                push(&zacetek2, s);
                push(&trajanje2, pop(&trajanje1));
                push(&potnikiGor2, pop(&potnikiGor1));
                push(&potnikiDol2, pop(&potnikiDol1));
            }
        }
        if (konec == NULL)
        {
            if (stevec == 0)
            {
                if (stikalo == 1)
                {
                    strcpy(s, "");
                    push(&konec, pop(&konec2));
                    push(&zacetek, pop(&zacetek2));
                    push(&trajanje, pop(&trajanje2));
                    push(&potnikiGor, pop(&potnikiGor2));
                    push(&potnikiDol, pop(&potnikiDol2));
                }
                else
                {
                    stevec++;
                }
            }
            while (konec1 != NULL) {
                push(&konec, pop(&konec1));
                push(&zacetek, pop(&zacetek1));
                push(&trajanje, pop(&trajanje1));
                push(&potnikiGor, pop(&potnikiGor1));
                push(&potnikiDol, pop(&potnikiDol1));
            }
        printf("%s\n", pop(&zacetek));
        printf("%s\n", pop(&konec));
        printf("%s\n", pop(&trajanje));
        printf("%s\n", pop(&potnikiGor));
        printf("%s\n", pop(&potnikiDol));
            stikalo = 0;
        }
    }
    while(konec2 != NULL)
    {
        printf("%s\n", pop(&konec2));
        printf("%s\n", pop(&zacetek2));
        printf("%s\n", pop(&trajanje2));
        printf("%s\n", pop(&potnikiGor2));
        printf("%s\n", pop(&potnikiDol2));
    }
    /* while (scanf("%d", &stevec) != EOF) */
    /* { */
    /* } */
    free(p);
    return 0;
}

void push(stack ** element, char * string) {
    stack * next = malloc(sizeof(stack));
    next -> previous = *element;
    next -> string = string;
    if (!(*element)) {
        *element = next;
    } else {
        (*element) -> next = next;
    }
    *element = next;
}
char * pop(stack ** element) {
    if (isEmpty(element)) {
        printf("ERR\n");
        return '\0';
    } else {
        char * string = (*element) -> string;
        stack * next = *element;
        *element = (*element) -> previous;
        if (*element)
            (*element) -> next = NULL;
        free(next);
        return string;
    }
}
