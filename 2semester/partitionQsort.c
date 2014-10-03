int partition(unsigned int* x, unsigned int* y, int zacetek, int konec);
void quicksort(unsigned int* x, unsigned int* y, int zacetek, int konec)
{
    if(zacetek < konec) {
        int sredina = partition(x, y, zacetek, konec);
        quicksort(x, y, zacetek, sredina-1);
        quicksort(x, y, sredina+1, konec);
    }
}
int main(int argv, int argc[]) {
    /* quicksort(int* x, int* y, 0, len - 1); */
    return 0;
}

int partition(unsigned int* x, unsigned int* y, int zacetek, int konec) {
    srand(time(NULL));    
    int j = zacetek - 1;
    int pivot = zacetek + rand() % (konec - zacetek + 1);
    int temp = x[pivot];
    x[pivot] = x[konec];
    x[konec] = temp;
    temp = y[pivot];
    y[pivot] = y[konec];
    y[konec] = temp;
    pivot = konec;
    for(int i = zacetek; i <= konec - 1; i++) {
        if(x[i] < x[pivot] || (x[i] == x[pivot] && y[i] <= y[pivot])) {
            j++;
            temp = x[i];
            x[i] = x[j];
            x[j] = temp;
            temp = y[i];
            y[i] = y[j];
            y[j] = temp;
        }
    }
    j++;
    temp = x[j];
    x[j] = x[pivot];
    x[pivot] = temp;
    temp = y[j];
    y[j] = y[pivot];
    y[pivot] = temp;
    return j;
}
