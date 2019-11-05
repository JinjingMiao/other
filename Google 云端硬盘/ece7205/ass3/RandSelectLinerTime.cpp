#include <iostream>
#include <cstdlib>
using namespace std;

int randomized_partition(int arr[], int m,int n)
{
   int x,j;
   int size = n - m + 1;
   

   srand(time ( NULL));
   x=rand() % (size) + m;
   
   
   swap(arr[x],arr[m]);
 
   int pivot = arr[m];
   int i = m;
 
   for(j = m + 1; j <= n; j++)
   {
       if(arr[j] <= pivot )
       {
 
           i++;
           swap( arr[i], arr[j]);
       }
   }
      swap( arr[i],arr[m]);
   return i;
}

int rand_select(int* arr, int m, int n, int i)
{
   if(m == n)
       return arr[m];
 
   if(i == 0) return -1;
 
   if(m < n)
   {
 
       int r = randomized_partition(arr, m, n);
       int k = r - m + 1;
       if(k == i)
           return arr[r];
       else if(i < k)
           return rand_select(arr, m, r-1, i);
       else
           return rand_select(arr, r+1, n, i-k);
   }
   return 0;
}

int main()
{

   int i,j,r,temp;
   int n=100;
   srand((unsigned)time(NULL));
   int arr[n];
   for(i = 0;i < n;i++)
       arr[i] = i + 1;
   for (j = 0;j < n;j++)
   {
       r = rand() % n;
       temp = arr[r];
       arr[r] = arr[j];
       arr[j] = temp;
   }
 
   cout << "Unsorted Aay is \n";
 
   for(i=0;i<n;i++)
       cout<<arr[i]<<" ";
   cout<<"\n";
 
int k=99;
   int kth = rand_select(arr,0,99,k);
   cout << "the 99th smallest is  " << kth << endl;
   return 0;
}