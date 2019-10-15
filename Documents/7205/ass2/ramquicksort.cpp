
#include<iostream>
#include<cstdlib>
#include<ctime>
 
using namespace std;
//交换 
template<class T>
void Swap(T &a,T &b)
{
    T tmp=a;
    a=b;
    b=tmp;
}
//划分
template<class T>
int Partion(T elem[],int low,int high)
{
    while(low<high)//
    {
        while(low<high&&elem[low]<=elem[high])high--;
        Swap(elem[low],elem[high]);
        while(low<high&&elem[low]<=elem[high])low++;
        Swap(elem[low],elem[high]);
    }
    return low;
}
//recursion
template<class T>
void Help(T elem[],int low,int high)
{
    if(low<high)
    {
        int KeyPoint=Partion(elem,low,high);
        Help(elem,low,KeyPoint-1);
        Help(elem,KeyPoint+1,high);
    }
}
template<class T>
void QuickSort(T elem[],int n)
{
    Help(elem,0,n-1);
}
 
int main()
{
    clock_t start_time=clock();
    srand(unsigned(time(NULL)));
 
    const int min=1;
    const int max= 100;
    int A[200];
    cout<<"The random numbers are:"<<endl;
    for(int i=0;i<100;i++)A[i]=rand()%(max-min+1)+min;
    for(int i=0;i<100;i++)cout<<A[i]<<"\t";
    cout<<endl;
    cout<<"The ordered numbers are:"<<endl;
    QuickSort(A,100);
    for(int i=0;i<100;i++)cout<<A[i]<<"\t";
    cout<<endl;
    cout<<"The elapsed time is "<< double(clock()-start_time) <<'s'<<endl;
 
}
Describe the app
