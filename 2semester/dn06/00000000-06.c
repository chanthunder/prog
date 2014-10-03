#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>
#include <string.h>

typedef struct _stack stack;
struct _stack {
    double number;
    stack * previous;
    stack * next;
};

void push(stack ** element, double number);
double pop(stack ** element);
double peek(stack ** element);

int isEmpty(stack ** element) {
    return !*element;
}


int main(int argc, char *argv[]) {
    char * s = malloc(sizeof(char) * 100);
    stack * prebrani = NULL;
    double a, b;
    while (scanf("%s", s) != EOF) {
        /* preverimo ce je prebrano stevilo nato preverimo vse operacije, ki ne
         zahtevajo spremenljivke. Nato gremo na operacije z eno in kasneje se
         na operacije z dvema spremenljivkama. Ce noben pogoj ni izpolnjen je
         nas stack ali prazen ali pa operacija ne obstaja. V tem primeru javimo
         napako. Vrstni red else ifov je naceloma pomemben. Zadnji pred elsom
         mora biti stavek, ki preverja ce imamo kaksen element v stacku. Za
         ostale vrstni red ni pomemben. Pri operacijah je vrstni red pomemben
         ce niso komutativne*/
        if (isdigit(s[0]) != 0 || (strlen(s) > 1 && (s[0] == '+' || s[0] == '-'))) {
            push(&prebrani, atof(s));
        } else if (strcmp(s, "e") == 0) {
            push(&prebrani, M_E);
        } else if (strcmp(s, "pi") == 0) {
            push(&prebrani, M_PI);
        } else if (!isEmpty(&prebrani)) {
        /* vzamemo prvo stevilo s stacka (ze vemo da obstaja). Ce kaksna
         * operacija po definiciji ne odstrani elementa a, ga moramo vrniti
         * nazaj na stack. Stavek, ki preverja ce imamo kaksen element v stacku
         * mora biti spet zadnji pred elsom. Ostale lahko poljubno premesamo*/
            a = pop(&prebrani);
            if (strcmp(s, "print") == 0) {
                printf("%lf\n", a);
                push(&prebrani, a);
            } else if (strcmp(s, "drop") == 0) {
                // already pop'ed
            } else if (strcmp(s, "inv") == 0) {
                    push(&prebrani, 1.0 / a);
            } else if (strcmp(s, "sin") == 0) {
                    push(&prebrani, sin(a));
            } else if (strcmp(s, "cos") == 0) {
                    push(&prebrani, cos(a));
            } else if (strcmp(s, "tan") == 0) {
                    push(&prebrani, tan(a));
            } else if (strcmp(s, "log") == 0) {
                    push(&prebrani, log10(a));
            } else if (strcmp(s, "ln") == 0) {
                    push(&prebrani, log(a));
            } else if (strcmp(s, "sqrt") == 0) {
                    push(&prebrani, sqrt(a));
            } else if (strcmp(s, "dup") == 0) {
                    push(&prebrani, a);
                    push(&prebrani, a);
            } else if (!isEmpty(&prebrani)) {
                b = pop(&prebrani);
                // tu vrstni red stavkov ni pomemben
                if (strcmp(s, "+") == 0) {
                    push(&prebrani, b + a);
                } else if (strcmp(s, "-") == 0) {
                    push(&prebrani, b - a);
                } else if (strcmp(s, "*") == 0) {
                    push(&prebrani, b * a);
                } else if (strcmp(s, "/") == 0) {
                    push(&prebrani, b / a);
                } else if (strcmp(s, "^") == 0) {
                    push(&prebrani, pow(b, a));
                } else if (strcmp(s, "mod") == 0) {
                    push(&prebrani, fmod(b, a));
                } else if (strcmp(s, "xchg") == 0) {
                    push(&prebrani, a);
                    push(&prebrani, b);
                }
            } else {
                printf("ERR\n");
            }
        } else {
            printf("ERR\n");
        }
    }
    return 0;
}

void push(stack ** element, double number) {
    stack * next = malloc(sizeof(stack));
    next -> previous = *element;
    next -> number = number;
    if (!(*element)) {
        *element = next;
    } else {
        (*element) -> next = next;
    }
    *element = next;
}

double pop(stack ** element) {
    if (isEmpty(element)) {
        printf("ERR\n");
        return 0;
    } else {
        double number = (*element) -> number;
        stack * next = *element;
        *element = (*element) -> previous;
        free(next);
        return number;
    }
}

double peek(stack ** element) {
    if (isEmpty(element)) {
        printf("ERR\n");
        return 0;
    } else {
        return (*element) -> number;
    }
}
