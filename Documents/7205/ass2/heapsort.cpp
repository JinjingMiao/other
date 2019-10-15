#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
 
//Swap
void Swap(int &a,int &b){
    int tmp=a;
    a=b;
    b=tmp;
}
//Adjust the big node
void AdjustHelp(int A[],int low,int high){//  adjust the heap 
    for(int p=low,i=low*2+1;i<=high;i=i*2+1){
        if(i<high&&A[i]<A[i+1])i++;
        if(A[p]>A[i])break;
        Swap(A[p],A[i]);
        p=i;
    }
}
//HeapSort Algorithm
void HeapSort(int A[],int n){
    for(int i=(n-2)/2;i>=0;i--){// in heap
        AdjustHelp(A,i,n-1);
    }
    for(int i=n-1;i>0;i--){//sort
        Swap(A[i],A[0]);
        AdjustHelp(A,0,i-1);
    }
}
int main()
{
    clock_t start_time = clock();
    int A[100];
    const int min=1;
    const int max=100;
    srand(unsigned(time(NULL)));
    cout << "The previous numbers are:" << endl;
    for(int i=0;i<=100;i++)A[i]=rand()%(max-min+1)+min;
    for(int i=0;i<=100;i++)cout<<A[i]<<"\t";
    cout << endl;
    cout << "The current numbers are:"<<endl;
    HeapSort(A,100);
    for(int i=0;i<=100;i++)cout<<A[i]<<"\t";
    cout << endl;
    cout << "The elapsed time is: " << double(clock()-start_time)<<"s"<<endl;
    return 0;}
