#include <iostream>

using namespace std;

int max(int A[], int n) //max 
{
    int maxData = A[0];
    for (int i = 1; i < n; ++i)
    {
        if (maxData < A[i])
            maxData = A[i];
    }
    int cout = 1;
    int p = 10;
    while (maxData >= p)
    {
        maxData /= 10;
        ++cout;
    }
    return cout;
    }
void radixsort(int A[], int n) //sort
{
    int cout= max(A, n);
    int *tmp = new int[n];
    int *count = new int[10]; //cal
    int i, j, k;
    int radix = 1;
    for(i = 1; i <= j; i++) //
    {
        for(j = 0; j < 10; j++)
            count[j] = 0; //clear
        for(j = 0; j < n; j++)
        {
            k = (A[j] / radix) % 10; //calculate
            count[k]++;
        }
        for(j = 1; j < 10; j++)
            count[j] = count[j - 1] + count[j]; 
        for(j = n - 1; j >= 0; j--) //record
        {
            k = (A[j] / radix) % 10;
            tmp[count[k] - 1] = A[j];
            count[k]--;
        }
        for(j = 0; j < n; j++) //copy in data
            A[j] = tmp[j];
        radix = radix * 10;
    }
    delete []tmp;
    delete []count;
}

int main()
{
    int i;
    int A[8]={12,56,5,98,576,520,125,9};
    max(A,8);
    radixsort(A,8);
    for(i=0;i<8;i++)
    cout<<A[i]<<"  ";
    cout<<endl;
}
