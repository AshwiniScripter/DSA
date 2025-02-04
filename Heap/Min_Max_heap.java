import java.util.Scanner;

public class Min_Max_heap {

    //min heap
    public void midHeap(int[] heap, int n, int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && heap[left]<heap[smallest]){
            smallest=left;
        }
        if(right<n && heap[right]<heap[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            int temp=heap[i];
            heap[i]=heap[smallest];
            heap[smallest]=temp;
            midHeap(heap, n, smallest);

        }
    }
    //Max heap
    public void maxHeap(int[] heap,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<largest && heap[left]>heap[largest]){
            largest=left;
        }
        if(right<largest && heap[right]>heap[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=heap[i];
            heap[i]=heap[largest];
            heap[largest]=temp;
            maxHeap(heap, n, largest);
        }

    }
    
    public void buildMinHeap(int[] heap){
        int size=heap.length;
        for(int i=size/2-1;i>=0;i--){
            midHeap(heap, size, i);
        }

    }

    public void buildMaxHeap(int[] heap){
        int size=heap.length;
        for(int i=size/2-1;i>=0;i--){
            maxHeap(heap, size, i);
        }
    }

    public void creation(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number which you want to put into heap: ");
        int n=sc.nextInt();
        int[] heap=new int[n];

        
        // buildMinHeap(heap);
        
        System.out.println("\nEnter Heap type: ");
        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");
        System.out.print("\nEnter your choice: ");
        int choice=sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.print("Enter element: "+(i+1)+": ");
            heap[i]=sc.nextInt();
        }

        switch (choice) {
            case 1:
                buildMinHeap(heap);
                break;
            case 2:
                buildMaxHeap(heap);
                break;
            default:
                System.out.println("Try Again...!");
                break;
        }

        System.out.println("Heap Elements: ");

        for(int i=0;i<n;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
        
        sc.close();
    }
    public static void main(String args[]){
        Min_Max_heap obj=new Min_Max_heap();
        obj.creation();
    }
}
