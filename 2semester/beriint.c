#include <stdio.h>

int main() {
    int c;
    c = getchar();
    if (c > 57 || c < 48) {
        printf("%s\n", "Napaka");
        return -1;
    } else {
        int d;
        d = c - 48;
        printf("%d\n", d);
        return 0;
    }
}
