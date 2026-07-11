#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 36000

int arr[MAX];

void generateRandom(int n)
{
    int i;

    for(i=0;i<n;i++)
        arr[i]=rand()%100000;
}

void generateAscending(int n)
{
    int i;

    for(i=0;i<n;i++)
        arr[i]=i;
}

void generateDescending(int n)
{
    int i;

    for(i=0;i<n;i++)
        arr[i]=n-i;
}

void bubbleSort(int a[],int n)
{
    int i,j,temp;

    for(i=0;i<n-1;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
}

void insertionSort(int a[],int n)
{
    int i,j,key;

    for(i=1;i<n;i++)
    {
        key=a[i];
        j=i-1;

        while(j>=0 && a[j]>key)
        {
            a[j+1]=a[j];
            j--;
        }

        a[j+1]=key;
    }
}

void selectionSort(int a[],int n)
{
    int i,j,min,temp;

    for(i=0;i<n-1;i++)
    {
        min=i;

        for(j=i+1;j<n;j++)
        {
            if(a[j]<a[min])
                min=j;
        }

        temp=a[min];
        a[min]=a[i];
        a[i]=temp;
    }
}

int partition(int a[],int low,int high)
{
    int pivot=a[high];
    int i=low-1;
    int j,temp;

    for(j=low;j<high;j++)
    {
        if(a[j]<pivot)
        {
            i++;

            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }

    temp=a[i+1];
    a[i+1]=a[high];
    a[high]=temp;

    return i+1;
}

void quickSort(int a[],int low,int high)
{
    if(low<high)
    {
        int p=partition(a,low,high);

        quickSort(a,low,p-1);
        quickSort(a,p+1,high);
    }
}


void merge(int a[],int low,int mid,int high)
{
    int temp[MAX];

    int i=low;
    int j=mid+1;
    int k=low;

    while(i<=mid && j<=high)
    {
        if(a[i]<a[j])
            temp[k++]=a[i++];
        else
            temp[k++]=a[j++];
    }

    while(i<=mid)
        temp[k++]=a[i++];

    while(j<=high)
        temp[k++]=a[j++];

    for(i=low;i<=high;i++)
        a[i]=temp[i];
}

void mergeSort(int a[],int low,int high)
{
    if(low<high)
    {
        int mid=(low+high)/2;

        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);

        merge(a,low,mid,high);
    }
}


void heapify(int a[],int n,int i)
{
    int largest=i;
    int left=2*i+1;
    int right=2*i+2;
    int temp;

    if(left<n && a[left]>a[largest])
        largest=left;

    if(right<n && a[right]>a[largest])
        largest=right;

    if(largest!=i)
    {
        temp=a[i];
        a[i]=a[largest];
        a[largest]=temp;

        heapify(a,n,largest);
    }
}

void heapSort(int a[],int n)
{
    int i,temp;

    for(i=n/2-1;i>=0;i--)
        heapify(a,n,i);

    for(i=n-1;i>0;i--)
    {
        temp=a[0];
        a[0]=a[i];
        a[i]=temp;

        heapify(a,i,0);
    }
}

int main()
{
    int choice;
    int inputType;
    int sizes[]={8000,12000,16000,20000,24000,28000,32000,36000};

    srand(time(NULL));

    printf("===== Sorting Algorithms =====\n");
    printf("1. Bubble Sort\n");
    printf("2. Insertion Sort\n");
    printf("3. Selection Sort\n");
    printf("4. Quick Sort\n");
    printf("5. Merge Sort\n");
    printf("6. Heap Sort\n");
    printf("7. Exit\n");

    printf("\nEnter your choice: ");
    scanf("%d",&choice);

    if(choice==7)
        return 0;

    printf("\nInput Type\n");
    printf("1. Random\n");
    printf("2. Ascending\n");
    printf("3. Descending\n");

    printf("Enter input type: ");
    scanf("%d",&inputType);

    int i;

    for(i=0;i<8;i++)
    {
        int n=sizes[i];

        if(inputType==1)
            generateRandom(n);
        else if(inputType==2)
            generateAscending(n);
        else
            generateDescending(n);

        clock_t start=clock();

        switch(choice)
        {
            case 1:
                bubbleSort(arr,n);
                break;

            case 2:
                insertionSort(arr,n);
                break;

            case 3:
                selectionSort(arr,n);
                break;

            case 4:
                quickSort(arr,0,n-1);
                break;

            case 5:
                mergeSort(arr,0,n-1);
                break;

            case 6:
                heapSort(arr,n);
                break;

            default:
                printf("Invalid Choice");
                return 0;
        }

        clock_t end=clock();

        double time=((double)(end-start))*1000/CLOCKS_PER_SEC;

        printf("Size = %d\tTime = %.3f ms\n",n,time);
    }

    return 0;
}
