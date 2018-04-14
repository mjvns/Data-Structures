class PQueue{
        int maxSize;
        int array[]; // array is sorted in descending order
        int nelems;
    // constructor for the class object
    PQueue(int size){
            maxSize = size;
            array = new int[maxSize];
            nelems = 0;
    }
    void insert(int x){
            if(nelems == 0){ // if queue is empty insert at the index 0
                array[nelems++] = x;
            }else{ // if queue is not empty
                int j;
               for(j=nelems-1;j>=0;j--){
                   if(x<=array[j]){
                       break;
                   }else{
                       array[j+1] = array[j];
                   }
               }
               array[j+1] = x;
               nelems++;
            }
            for(int i=0;i<5;i++){
                System.out.println(array[i]);
            }
    } // end insert
    int remove(){// removes minimum element
            return array[--nelems];
    }
    int peekmin(){// peek at minimum element
            return array[nelems-1];
    }
    boolean isEmpty(){
            return (nelems == 0);
    }
    boolean isFull(){
            return (nelems == maxSize);
    }
}// end class PQueue

class Driver{
    public static void main(String args[]){
        PQueue pq = new PQueue(5);
        System.out.println("First iteration");
        pq.insert(1);
        System.out.println("Second iteration");
        pq.insert(7);
        System.out.println("Third iteration");
        pq.insert(3);
        System.out.println("Fourth iteration");
        pq.insert(16);
        System.out.println("Fifth iteration:");
        pq.insert(-5);
        while(!pq.isEmpty()){
            System.out.println("The element removed is"+pq.remove());
            if(pq.isEmpty()){
                System.out.println("queue is empty");
            }
            else
            System.out.println("Peek is:"+pq.peekmin());
        }
    }
}
