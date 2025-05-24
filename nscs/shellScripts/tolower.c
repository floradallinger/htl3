#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[])
{
    int upper;
    if (argc == 1) upper = 0;
    else if (argc == 2 && strcmp(argv[1], "-u") == 0) upper = 1;
    else {
        fprintf(stderr, "%s : syntax error\n", argv[0]);
        exit(1);
    }
    while (1) {
        int c = getchar();
        if (c == EOF) break;
        if (upper) c = toupper(c);
        else c = tolower(c);
        putchar(c);
    }
    return 0;
}

