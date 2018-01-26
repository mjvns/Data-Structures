#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
//defines the node structure
struct node{
    int data;
    struct node *next;
};

struct node *head = NULL;

/*inserts node at the beginning of the list*/
void insertFirst(int data){
    //create a newnode
    struct node *newnode = malloc(sizeof(struct node));
    newnode->data = data;
    newnode->next = head;
    head = newnode;
}

// displays the list
void display(){
    struct node *ptr = head;
    while(ptr!=NULL){
        printf("%d ",ptr->data);
        ptr = ptr->next;
    }
}

//deletes the first node
struct node* deleteFirst(){
    struct node *deletednode = NULL;
    if(head != NULL){
        deletednode = head;
        head = head->next;
    }else{
        printf("List is already empty!\n");
    }

    return deletednode;
}

// returns if the list is Empty
bool isEmpty(){
    return head == NULL;
}

//returns the length of the list
int size(){
  int len = 0;
    struct node *temp = head;
    while(temp!=NULL){
        len++;
        temp = temp->next;
    }
    return len;
}
//search for a particular value in the list
struct node* search(int val){
    struct node *temp = head;
    int count = 0;
    while(temp!=NULL){
        if(temp->data == val){
            printf("Element found at index %d from head",count);
            return temp;
        }
        temp = temp->next;
        count++;
    }
    printf("Element not found!!\n");
    return NULL;
}
// deletes the particular value from the list
struct node* delete(int value){
   if(!isEmpty()){
      struct node *temp = head;
      struct node *deletednode = NULL;

       if(head->data == value){
           deletednode = head;
           head = head->next;
           deletednode->next = NULL;
           return deletednode;
       }
       while(temp!=NULL){
           if(temp->next!=NULL){
               if(temp->next->data == value){
                   deletednode = temp->next;
                   temp->next = temp->next->next;
                   deletednode->next = NULL;
                   return deletednode;
               }
           }
           temp = temp->next;
       }

       printf("Value not found!!\n");
   }else {
       printf("List is already empty!!");
       return NULL;
   }
}

int main(){
    insertFirst(2);
    insertFirst(1);
    insertFirst(6);
    insertFirst(7);
    delete(6);

    display();
    printf("%d",size());
    search(2);
    return 0;
}