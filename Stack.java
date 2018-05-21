import java.util.Scanner;
class Stack {
    private int maxSize;
    private int top;
    private int StackArray[];

    Stack(int size){
        maxSize = size;
        StackArray = new int[size];
        top = -1;
    }

    public void push(int data){
        if(!isFull()) {
            StackArray[++top] = data;
        }else{
            System.out.println("Stack is out of space.\nRemove some items.");
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is already empty!!");
            return -1;
        }
            return StackArray[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == StackArray.length-1;
    }

    public void display(){
        while(!isEmpty()){
            System.out.println(pop());
        }
        System.out.println("Stack is Empty!");
    }

    public static void main(String args[]){
        int choice,val;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of your Stack:");
        int size = scan.nextInt();
        while(size<1){
            System.out.println("Size cannot be 0 or negative!!\nEnter valid size:");
            size = scan.nextInt();
        }

        Stack stk = new Stack(size);

        System.out.println("Press 1 for Push");
        System.out.println("Press 2 for Pop");
        choice = scan.nextInt();

        while(true){
        switch(choice){
            case 1:
                    System.out.println("Enter the value to be pushed:");
                    val = scan.nextInt();
                    stk.push(val);
                    break;
            case 2:
                    int temp = stk.pop();
                    System.out.println("Popped out value is: " +temp);
                    break;
            case 3:
                    stk.display();
                    break;
            default:
                    System.out.println("Program terminated successfully!");
                    return;
        }
            System.out.println("What to do next:\nPress 1 to push\nPress 2 to pop\nPress 3 to display\nPress any other key to terminate");
            choice = scan.nextInt();
        }
    }
}
