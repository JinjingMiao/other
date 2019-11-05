
// C++ implementation of randomized quickSelect 
#include<iostream> 
#include<climits> 
#include<cstdlib> 
using namespace std; 
  
int randomPartition(int arr[], int l, int r); 

  
// This function returns k'th smallest element in arr[l..r] using 
// QuickSort based method. ASSUMPTION: ELEMENTS IN ARR[] ARE DISTINCT 
int kthSmallest(int arr[], int l, int r, int k) 
{ 
    // If k is smaller than number of elements in array 
    if (k > 0 && k <= r - l + 1) 
    { 
        // Partition the array around a random element and 
        // get position of pivot element in sorted array 
        int pos = randomPartition(arr, l, r); 
  
        // If position is same as k 
        if (pos-l == k-1) 
            return arr[pos]; 
        if (pos-l > k-1)  // If position is more, recur for left subarray 
            return kthSmallest(arr, l, pos-1, k); 
  
        // Else recur for right subarray 
        return kthSmallest(arr, pos+1, r, k-pos+l-1); 
    } 
  
    // If k is more than the number of elements in the array 
    return INT_MAX; 
} 
  
void swap(int *a, int *b) 
{ 
    int temp = *a; 
    *a = *b; 
    *b = temp; 
} 
  
// Standard partition process of QuickSort().  It considers the last 
// element as pivot and moves all smaller element to left of it and 
// greater elements to right. This function is used by randomPartition() 
int partition(int arr[], int l, int r) 
{ 
    int x = arr[r], i = l; 
    for (int j = l; j <= r - 1; j++) 
    { 
        if (arr[j] <= x) 
        { 
            swap(&arr[i], &arr[j]); 
            i++; 
        } 
    } 
    swap(&arr[i], &arr[r]); 
    return i; 
} 
  
// Picks a random pivot element between l and r and partitions 
// arr[l..r] around the randomly picked element using partition() 
int randomPartition(int arr[], int l, int r) 
{ 
    int n = r-l+1; 
    int pivot = rand() % n; 
    swap(&arr[l + pivot], &arr[r]); 
    return partition(arr, l, r); 
} 
  
// Driver program to test above methods 
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
   int kth = partition(arr,0,99,k);
   cout << "the 99th smallest is  " << kth << endl;
   return 0;
}