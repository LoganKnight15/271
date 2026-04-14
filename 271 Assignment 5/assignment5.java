/*************************************************************************
* Project 5 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: Windows 11 Version 25H2 and MacOS 
* Compiler: javac 21.0.10
* Date: April 13, 2026
*
* Purpose
* This program is a Java program to implement a gneric Linked List
*
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

// Java Program to Implement Generic Linked List

// Importing all input output classes
import java.util.Scanner;

// Node Class: (Generic Node class for LinkedList)
class Node<T> {
  private T element; // Data element to sore an item
  private Node<T> next; // a reference to the next Node

  // Parameterized constructor to assign value
  Node(T item) {
    this.element = item; // "this" refers to current object itself
    this.next = null;
  }

  void setNext(Node<T> n){ // set the private memeber
    this.next = n;
  }

  Node<T> getNext(){ //get the private member
    return this.next;
  }

  void setElement(T item){ // set the private memeber
    this.element = item;
  }

  T getElement(){ //get the private member
    return this.element;
  }

  public void displayRecursively(){ // display Node recursively
    System.out.print(this.getElement());
    if (this.next != null){
      System.out.print(" , ");
      this.next.displayRecursively();
    } else {
      System.out.println("] ");
    }
  }
}

// List Class: ( Generic LinkedList class)
class List<T> {

  // Generic Node instance
  private Node<T> head;
  private int size; // store the size of the list

  List(){ // Default constructor
    this.head = null; // a reference ot the head node
    this.size = 0;    // maintain the size of the list
  } 

  // ********************************** isEmpty() **********************************
  boolean isEmpty(){ // a method to check if the List is empty
    return (this.head == null);
  }

  // ********************************** addLast() **********************************
  void addLast(T item) { // add a Node containing item at the end of List
    Node<T> newNode = new Node<>(item); // create a new Node with the given item

    if(this.head == null){ // Check if the head 
      head = newNode;
    } else {
      Node<T> temp = this.head; // create a temporary reference to the first node in the list

      while (temp.getNext() != null) { // move the reference to the last node
        temp = temp.getNext();
      }
      temp.setNext(newNode); // link the last node to the new node referenced by newNode 
    }
    this.size++; // update the size of the list
  }

  // ********************************** addFront() **********************************
  void addFront(T item){ //a method to add an item at the front of the list
    Node<T> newNode = new Node<>(item); // create a new Node with the given item
    newNode.setNext(this.head);
    this.head = newNode;
    this.size++;
    System.out.println("new node added at front !");
  }

  // ********************************** addAt() **********************************
  void addAt (int index, T item) { // add item in a new Node at index position

    // Checking if position is valid
    if (index < 0 || index >= this.size ) {
      System.out.println("index is out of bound !");
    } else {
      Node<T> newNode = new Node<>(item); // create a new Node with the given item

      int count = 0;  // start a counter
      Node<T> temp = head; // create a temporary Node reference
      while(temp != null && count < index-1){ // move to index position
        count++;
        temp = temp.getNext();
      }
      if(index >0){
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
      }else if( index == 0) {
        newNode.setNext(this.head);
        this.head = newNode;
      }
      System.out.println("new node added at index "+ index);
    }
  }

  // ********************************** size() **********************************
  public int size(){ // a method to return the number of elements in the lsit
    return this.size;
  }

  // ********************************** displayAll() **********************************
  public void displayAll(){ // Method to display the LinkedList

    System.out.println("displayAll():");
    System.out.println("____________List of "+this.size+" items________________");

    if (this.isEmpty()){
      System.out.println("The list is empty ...! ");
    } else {
      Node<T> temp = this.head;
      System.out.print("[ ");
      while(temp != null){
        System.out.print(temp.getElement());
        if(temp.getNext() == null)
          System.out.println("] ");
        else
          System.out.print(" , ");
        temp = temp.getNext();
      }
    }  
    System.out.println();
  }

  // ********************************** displayRecursively() **********************************
  public void displayRecursively(){
    System.out.println("displayRecursively():");
    System.out.println("____________List of "+this.size+" items________________");
    if (this.isEmpty()){
      System.out.println("The list is empty ...! ");
    } else {
      System.out.print("[ ");
      this.head.displayRecursively();
    }
    System.out.println();
  }

  // ********************************** removeLast() **********************************
  public void removeLast(){
    if(this.isEmpty()){
      System.out.println("The list is empty !");
    } else if(this.head.getNext() == null){
      this.head = null;
      this.size--;    // update the size
      System.out.println("last item removed");
    } else {
      Node<T> temp = this.head;
      
      while((temp.getNext() != null) && (temp.getNext().getNext() != null)){
        temp = temp.getNext();
      }
      temp.setNext(null);
      temp = null;
      this.size--;        // update teh size
      System.out.println("last item removed");
    }
  }

  // ********************************** removeAt() **********************************
  public void removeAt(int index){
    if(this.isEmpty()){ // check the empty list
      System.out.println("The list is empty !");
    } else if(index >= this.size || index < 0){ // check index is valid
      System.out.println("index is out of bound !");
    } else if (index == 0){ // remove the first Node
      this.head = this.head.getNext();
      this.size--;
      System.out.println("item is removed at index "+index);
    } else{ // remove other than the first node
      int count = 0;
      Node<T> temp = this.head;

      while(count < index-1){ // search for the node at position index
        count++;
        temp = temp.getNext();
      }

      Node<T> pNode = temp.getNext(); // hold on to that node temporarily 
      temp.setNext(pNode.getNext());  // hold on to that node temporarily 
      pNode.setNext(null);            // disconnect that node form the list
      this.size--;                    // update the size
      System.out.println("item is removed at index "+index);
    }
  }

  // ********************************** removeFront() **********************************
  public void removeFront(){
    if(this.isEmpty()){
      System.out.println("The list is empty !");
    }else{
      Node<T> temp = this.head;
      this.head = this.head.getNext();
      temp.setNext(null);
      System.out.println("front item removed");
    }
  }

  // ********************************** getAt() **********************************
  T getAt(int index){
    T res = null;
    if (this.isEmpty()){
      System.out.println("The list is empty !");
    } else if (index >= this.size || index < 0){
      System.out.println("index is out of bound !");
    } else if (index == 0) {
      res = this.head.getElement();
    } else {
      int count = 0;
      Node<T> temp = this.head;

      while(count++ != index){ // search for the node at position index
        temp = temp.getNext();
      }
      res = temp.getElement();
    }
    return res;
  }

  // ********************************** splitAt() **********************************
  public List<T> splitAt(int index){
    List<T> splitList = new List<>();
    if(index < 0 || index >= this.size){
      System.out.println("The provided index is out of bounds!");
    }
    else{
      Node<T> temp = this.head;
      int count = 0;

      while(count != index - 1){ // search for the node at position index
        temp = temp.getNext();
        count++;
      }
      splitList.head = temp.getNext();
      temp.setNext(null);
      splitList.size = this.size - index;
      this.size = index;
    }
    return splitList;
  }
  // ********************************** insertSorted() **********************************
  public void insertSorted(T item){
    Node<T> newNode = new Node<>(item);

    if(this.isEmpty()){
      this.head = newNode;
      this.size++;
    }
     /*Tried multiple other ways but this was the only way I could find that worked. Though I do understand what this is saying
     We are casting the item to a comparable object at runtime. Could also add a T extends Comparable above to avoid the aquiggles but I chose not to do this
     This was also found by a combination of looking at Java reference guide online and VS Code suggestions*/
    else if(((Comparable<T>) item).compareTo(this.head.getElement()) <0){
      newNode.setNext(this.head);
      this.head = newNode;
      this.size++;
    }
    else {
      Node<T> temp = this.head;

      while (temp.getNext() != null && ((Comparable<T>) temp.getNext().getElement()).compareTo(item) < 0) {
        temp = temp.getNext();
      }

      newNode.setNext(temp.getNext());
      temp.setNext(newNode);
      this.size++;
    }
  }
  // ********************************** InsertionSort() **********************************
  public void insertionSort(){
    if(this.size <= 1){
      return;
    }
    int mid = this.size / 2;
    List<T> right = this.splitAt(mid);
    this.insertionSort();
    right.insertionSort();

    Node<T> temp = right.head;

    while (temp != null) {
      this.insertSorted(temp.getElement());
      temp = temp.getNext();
    }
  }
}

// The class for the Main Program
public class assignment5 {

  public static void main(String[] args) { // The main() method

    List<Integer> list = new List<>();
    Integer ch, item, index;
    boolean quit = false;

    Scanner sc = new Scanner(System.in);

    do{
  
      System.out.println( "____________Main Menu_____________________");
      System.out.println( "select option :");
      System.out.println( "1: insert back");
      System.out.println( "2: insert front");
      System.out.println( "3: insert at index");
      System.out.println( "4: display items");
      System.out.println( "5: get item at index");
      System.out.println( "6: delete back");
      System.out.println( "7: delete front");
      System.out.println( "8: delete at index");
      System.out.println( "88: split at at index");
      System.out.println("11: insert sorted");
      System.out.println("99: insertion sort");
      System.out.println( "9: exit");
      ch = sc.nextInt();

      switch (ch) {
        case 1:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          list.addLast(item);
          break;
        case 2:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          list.addFront(item);
          break;
        case 3:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          System.out.println( "enter index:");
          index = sc.nextInt(); // read in an integer
          list.addAt(index, item);
          break;
        case 4:
          list.displayAll();
          list.displayRecursively();
          break;
        case 5:
          System.out.println( "enter index:");
          index = sc.nextInt();
          System.out.println( "item at index:"+index+" is: "+list.getAt(index));
          break;
        case 6:
          list.removeLast();
          break;
        case 7:
          list.removeFront();
          break;
        case 8:
          System.out.println( "enter index:");
          index = sc.nextInt();
          list.removeAt(index);
          break;
        case 9:
          quit = true;
          break;
        case 88:
          System.out.println("enter index:");
          index = sc.nextInt();
          List<Integer> newList = list.splitAt(index);
          System.out.println("Left list:");
          list.displayAll();
          System.out.println("Right list:");
          newList.displayAll();
          break;
        case 11:
          System.out.println("enter item:");
          item = sc.nextInt();
          list.insertSorted(item);
          break;
        case 99:
          if (list.isEmpty()) {
            System.out.println("List is empty, cannot sort!");
          } else {
            list.insertionSort();
            System.out.println("List sorted!");
          }
          break;
        default:
          System.out.println( "invalid selection");
      }
    } while(!quit);
  }
}
