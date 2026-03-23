/*************************************************************************
* Programming Assignment 4 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: Windows 11 Version 25H2 and macOS Tahoe Version 26.3
* Compiler: g++
* Date: March 23 2026
*
* Purpose
* This program implements the class Lists as linked lists of generic nodes 
* The task is to implement the missing methods. 
* Please see corresponding assignemnt questions
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Logan Robinson
********************************************************************/

#include<iostream>
#include <ctime>

using namespace std;

// Global memory management counts to track allocations/deallocations
int AN = 0;
int DN = 0;

// A Generic Node Class
template <typename T> class Node{
  private:
    T element;
    Node <T>* next;

    // Allow the friend class List to access private members
    template <typename U> friend class List;

  public:
    Node(){
      this->next = NULL;
      AN += 1;  // keep track of allocations
    }

    ~Node(){
      // call destructors for the rest of the list

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
      if(this->next != NULL){ //Check if the next node in the list is NULL
        delete this->next; //If not delete that Node
      }

      // DO NOT REMOVE THE NEXT LINE: keep at end of your destructor method!!
      DN += 1;  // keep track of deallocations
    }
};

template <typename T> class List{
    private:
        Node<T>* head;
    public:
      // create an empty list
      List(){
        this->head = NULL;
      AN += 1;  // keep track of allocations
      }
      
      // destroy the list by destroying the nodes
      ~List(){

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        if(this->head != NULL){ //Check if the head node is NULL
          delete this->head; //If not delete that head
        }

        DN += 1;  // keep track of deallocations
      }

      // check if the list is empty
      //   In this case, an empty list has a size of 0
      bool isEmpty(){
        return (this->size() == 0);
      }

      // addLast(item) adds an element item of type T at the end of the list
      void addLast(T item){

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        Node<T>* pNode = new Node<T>; //Create a new Node pointer called pNode
        pNode->element = item; //Assign pNode's element to the item passed in
        pNode->next = NULL; //Set the Pnode pointer to next equal to NULL

        if(this->head == NULL){ //Check if the head is NULL
          this->head = pNode; //If it is set it equal to pNode
        }
        else{
          Node<T>* temp = this->head; //Create a temp pointer to head
          while(temp->next != NULL){ //Check for while temp's next node is not NULL
            temp = temp->next;       //Set temp equal to the next value. AKA move through the list
          }
          temp->next = pNode; //Set the next node to pNode
        }

        cout<<"new node added at back!"<<endl; // your method MUST use this!
      }

      // addFront(item) creates and adds a new element node 
      // containing item at the front of the list
      void addFront(T item){

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        Node<T>* pNode = new Node<T>; //Create a new Node pointer called pNode
        pNode->element = item; //Assign pNode's element to the item passed in
        pNode->next = this->head; //Set pNode's next node equal to the lists head node
        this->head = pNode; //Set the lists head node equal to the value of pNode

        cout<<"new node added at front !"<<endl; // your method MUST use this!
      }

      // addAt(index, item) creates and adds a new element node containing 
      // the elemnet item at the position speficied by indes in the list
      void addAt(int index, T item){

        // check for a valid index
        if(index > this->size() || index < 0){
          cout<<"index out of bound !"<<endl;
        }
        else{
          // create a new node with item in it
          Node<T>* pNode = new Node<T>;
          pNode->element = item;

          // Link the new node in the position indicated by index
          // start at the head of the list
          int count = 0;
          Node<T>* temp = this->head;

          // find the node before index position 
          while(temp != NULL && count < index-1){
            count++;
            temp = temp->next;
          }
 
          // if insertions is to happen after the first node
          if(index > 0){
            pNode->next = temp->next;
            temp->next = pNode;
          }
          else if(index==0){  // in the first position
              pNode->next = this->head;
              this->head = pNode;
          }
          cout<<"new node added at index "<<index<<" !"<<endl;
        }
      }

      // size() returns the number of elements in the list
      int size(){
        int len = 0;
 
        // start at the head of the list
        Node<T>* temp = this->head;

        // count the nodes all the way to NULL
        while(temp != NULL){
          len++;
          temp = temp->next;
        }
        return len;
      }

      // displayALL() prints the size and content of the list
      void displayAll(){
        cout<<"____________List of "<<this->size()<<" items________________"<<endl;

        if(this->isEmpty()){
          cout<<"The list is empty ...! "<<endl;
        }
        else{ 
          // start at the head
          Node<T>* temp = this->head;

          // print all the nodes one by one
          cout<<"[ ";
          while(temp != NULL){
            cout<<temp->element;
            temp = temp->next;
            if(temp == NULL)
              cout<<"] "<<endl;
            else
              cout<<" , ";
          }
        }
        cout<<endl;
      }
    
      // removeLast() deletes the last element and its node in the list
      void removeLast(){

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        if (this->head == NULL){ //Check if the lists head node is NULL
          cout<<"The list is empty"<<endl; //If so output this line
        }
        else if(this->head->next == NULL){ //Check if the node following head is NULL 
          delete this->head; //If so delete the head
          this->head = NULL; //Set the head to NULL
          cout<<"last item removed"<<endl; //Output this line
        }
        else{
          Node<T>* temp = this->head; //Create a new temp node pointer and assign it to head
          while(temp->next->next != NULL){ //Check for while two nodes fwon from temp is not null
            temp = temp->next; //Set temp equal to the next value. AKA move through the list
          }
          delete temp->next; //Delete the node after temp
          temp->next = NULL; //Set that node to NULL
          cout<<"last item removed"<<endl; // your method MUST use this!
        }
      }

      // removeAt(index) deletes the element and its node found at 
      // position index in the list
      void removeAt(int index){

        // check the empty list
        if(this->isEmpty()){
          cout<<"The list is empty !"<<endl;
        }
        else if(index >= this->size() || index < 0){ // verify index is valid
          cout<<"index out of bound !"<<endl;
        }
        else if(index == 0){ // remove first node
          this->removeFront();
          cout<<"item removed at index "<<index<<endl;
        }
        else{ // remove other than the first node
          int count = 0;
          Node<T>* temp = this->head; // start at the first node

          // search for the node at position index
          while(count < index - 1){ 
            count++;
            temp = temp->next;
          }
          
          Node<T>* pNode = temp->next; // hold on to that node temporarily 
          temp->next = pNode->next;    // relink around the removed node
          pNode->next = NULL;          // disconnect that node form the list
          pNode->~Node();              // destroy the node
          cout<<"item removed at index "<<index<<endl;
        }
      }

      // removeFront() deletes the last element and its node in the list
      void removeFront(){
       
/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        if(this->head == NULL){//Check if the lists head node is NULL
          cout<<"The list is empty!"<<endl;//If so output this line
        }
        else{
          Node<T>* temp = this->head; //Create a new temp node pointer and assign it to head
          this->head = this->head->next; //Set head euqal to the node that follows it
          temp->next = NULL; //Set the temp node's next node to NUll
          delete temp; //delete the temp node's value
          cout<<"front item removed"<<endl; // your method MUST use this!
        }

      }

      // getAt(int index) returns the element found at position index in the list
      T getAt(int index){
        T res = -9999;        // initialize the results to invalid element

/********************************************************************************
        // replace the following line with your code!!!!!
*********************************************************************************/
        if(this->head == NULL){//Check if the lists head node is NULL
          cout<<"linked list is empty!"<<endl;//If so output this line
        }
        else if(index < 0 || index >= size()){//Check if the index is less than 0 or greater than the size of the list
          cout<<"index out of bound!"<<endl;//Output this line if that's the case
        }
        else{
          Node<T>* temp = this->head;//Create a new temp node pointer and assign it to head

          for(int i=0; i < index; i++){//For loop as long as i is less than the index value
            temp=temp->next;//SXet temp euqal to the node afterwards. AKA move to the next item in the list
          }
          res = temp->element;//Set res equal to the element at the node temp is pointing to.
        }

        return res;  // return the results -- YOU MUST USE THIS!!!!
      }
};


// ************* DO NOT MODIFY THE CODE BELOW THIS POINT !!!! *************
int main(){
    List<int> list;
    int ch, item, index;
    bool quit = false;
    do{
        // PLEASE DO NOT REMOVE THE NEXT LINE -- ignore it!
        // if you have to know, this is used for measuring CPU start time
        std::clock_t c_start = std::clock();

        // display the menu to the user
        cout<<"____________Main Menu_____________________"<<endl;
        cout<<"select option :"<<endl;
        cout<<"1: insert back"<<endl;
        cout<<"2: insert front"<<endl;
        cout<<"3: insert at index"<<endl;
        cout<<"4: display items"<<endl;
        cout<<"5: get item at index"<<endl;
        cout<<"6: delete back"<<endl;
        cout<<"7: delete front"<<endl;
        cout<<"8: delete at index"<<endl;
        cout<<"9: exit"<<endl;
        cin>>ch;

        // execute user's choice as a switch statement
        switch (ch)
        {
        case 1:
            cout<<"enter item to insert:"<<endl;
            cin>>item;
            c_start = std::clock(); // start the CPU clock -- Please this!
            list.addLast(item);
            break;
        case 2:
            cout<<"enter item to insert:"<<endl;
            cin>>item;
            list.addFront(item);
            break;
        case 3:
            cout<<"enter item to insert:"<<endl;
            cin>>item;
            cout<<"enter index:"<<endl;
            cin>>index;
            list.addAt(index, item);
            break;
        case 4:
            list.displayAll();
            break;
        case 5:
            cout<<"enter index:"<<endl;
            cin>>index;
            cout<<"item at index "<<index<<"is: "<<list.getAt(index)<<endl;
            break;
        case 6:
            list.removeLast();
            break;
        case 7:
            list.removeFront();
            break;
        case 8:
            cout<<"enter index:"<<endl;
            cin>>index;
            list.removeAt(index);
            break;
        case 9:
            quit = true;
            break;
        default:
            cout<<"invalid selection"<<endl;
            break;
        }
        std::clock_t c_end = std::clock();
        long time_elapsed_ms = 100000.0 * (c_end-c_start) / CLOCKS_PER_SEC;
        std::cout << "CPU time used: " << time_elapsed_ms << " ms"<<endl;
    }while(!quit);

    list.~List(); // Clean up and destroy the list

    cout<<".........................................."<<endl;
    if(AN-DN != 0) cout<<"********** MEMORY ALLOCATION ERROR ********** !!!!!!"<<endl;
    else cout<<"........   CONGRATULATIONS on memory well managed! .... :^) !!!!"<<endl;
    cout<<"Allocation Calls: "<<AN<<endl;
    cout<<"DeAllocation Calls: "<<DN<<endl;
    return 0;
}
