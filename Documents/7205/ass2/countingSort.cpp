#include<iostream>
using namespace std;
void Countingsort(int A[],int B[],int k,int n){                //k is max length, and n is the length of array
    int C[k+1];
    int i,j;
    for(i=0;i<k+1;i++)
    C[i]=0;
    for(j=0;j<n;j++)
    C[A[j]]=C[A[j]]+1;
    for(i=1;i<k+1;i++)
    C[i]=C[i]+C[i-1];
    for(j=n-1;j>=0;j--)
    {
        B[C[A[j]]-1]=A[j];                               
        C[A[j]]--;
    }
}
int GetMax(int A[],int n){
    int Max=A[0];
    for(int i=0;i<n;i++)
    {
        if(A[i]>Max)
        Max=A[i];
    }
    return Max;
}
int main(){
    int A[11]={20,18,5,7,16,10,9,3,12,14,0};
    int B[11];
    int k=GetMax(A,11);
    Countingsort(A,B,k,11);
    
    for(auto &i:B)
    cout<<i<<endl;
}
