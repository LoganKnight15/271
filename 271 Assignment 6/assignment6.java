/*************************************************************************
* Project 6 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: MacOS Tahoe Version 26.3.1(a)
* Compiler: javac 21.0.9
* Date: April 24, 2026
*
* Purpose
* This program implements a binary tree in java that takes user entered data
* and alows the user to insert and find items, get the tree height, display the entire tree,
* delete items, get the min and max values, get three tree size, and exit the tree.
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

// Java Program to Implement a Generic Binary Tree

// Importing all input output classes
import java.io.*;
import java.util.Scanner;
import java.lang.Math; // we need this for max and min functions.

// BinaryTree Class: ( Generic BinaryTree class)
//                   T extends Comparable<T> to allow the use of compareTo() to compare element generically !!
class BinaryTree<T extends Comparable<T>> { 

  // Encapsulation: Node is a private nested class to hide implementation details.
  private static class Node<T> {
    T element;     // Data element to sore an item
    Node<T> left;  // a reference to the left subtree
    Node<T> right; // a reference to the right subtree

    // Parameterized constructor to assign a value
    Node(T item) {
      this.element = item; // "this" refers to current object itself
      this.right = null;
      this.left = null;
    }
  }

  // Generic Node instance in the Generic BinaryTree Class
  private Node<T> root;

  BinaryTree(){ // Default constructor
    this.root = null; // a reference to the root node
  } 

  // ********************************** isEmpty() **********************************
  public boolean isEmpty(){ // a method to check if the tree is empty
    return (this.root == null);
  }
  
  /********************************** size() and sizeRecursively(Node<T> root) **********************************
  * Description: The size function and the the private helper sizeRecursively function that follows
  * recursively count through the entire tree to return to the user the size of the tree
  *
  * Parameters: the private helper sizeRecursivelytakes in Node<T> root 
  *
  * Pre: tree must either exist or be null.
  *
  * Post: the function will return the size of the tree to the use
  *
  * Returns: returns the integer size of the tree
  *
  * Called by: private helper is called by size and size is called by main
  * Calls: private helper sizeRecursively
  ************************************************************************/
  // STUDENTS MUST IMPLEMENT THIS METHOD!!!!
  public int size(){ // a method to return the number of elements in the tree
    return sizeRecursively(this.root);
  }

  private int sizeRecursively(Node<T> root){
    int s;
    if(root == null){
      s = 0;
    }
    else{
      s = 1 + sizeRecursively(root.left) + sizeRecursively(root.right);
    }
    return s;
  }
  // ********************************** height() **********************************
  //
  // this is a public method that delegates the height calculation to a private, recursive method
  public int height(){
    return heightRecursively(this.root);
  }
 
  // a private method to recursively calculate the height 
  private int heightRecursively(Node<T> root){
    int h = -1;
    if(root!=null)
      h = Math.max(heightRecursively(root.left),heightRecursively(root.right)) + 1;
    return h;
  }

  // ********************************** insert() **********************************
  //
  // this is a public method that delegates the insertion process to a private, recursive method
  public void insert(T item){ 

    this.root = insertRecursively(this.root, item);
  }

  // a private method to recursively place the item in the tree
  private Node<T> insertRecursively(Node<T> root, T item){

    if(root == null){
      root = new Node<T>(item);
    }else{
      int r = item.compareTo(root.element);
      if(r < 0){
        root.left = insertRecursively(root.left, item);
      }else if(r > 0){
        root.right = insertRecursively(root.right, item);
      }else{
        System.out.print(item+" already exists in the tree, no duplicates allowed!!\n");
      }
    }
    return root;
  }

  // ********************************** displayAll() **********************************

  // this is a public method that delegates the display process to a private, recursive method
  public void displayAll(){ 
    System.out.println("displayAll():");
    if (this.isEmpty()){
      System.out.println("The tree is empty ...! ");
    }else{
      System.out.println("____________Tree of "+this.size()+" items________________");
      showInorder(this.root);
    }
    System.out.println();
  }

  // a private method to recursively display items in the tree inOrder
  private void showInorder(Node<T> root){
    if(root!=null){
      showInorder(root.left);
      System.out.print(root.element+" ");
      showInorder(root.right);
    }  
  }

  /********************************** Find(T item) and findRecurisevly(Node<T> root, T item) **********************************
  * Description: The find function and the the private helper findRecursively function that follows
  * recursively look through the entire tree to return to the user whether or not a certian value exists
  *
  * Parameters: the private helper findRecursively takes in Node<T> root and T item
  *
  * Pre: tree must either exist or be null.
  *
  * Post: the function will return a boolean of either true or false of whether the value was found
  *
  * Returns: returns a boolean to tell whether the item was found or not
  *
  * Called by: private helper is called by find and find is called by main
  * Calls: private helper findRecursively
  ************************************************************************/
  // STUDENTS MUST IMPLEMENT THIS METHOD!!!!

  public boolean find(T item){
    return findRecursively(this.root, item);
  }

  private boolean findRecursively(Node<T> root, T item){
    if (root == null){
      return false;
    }
    boolean found;
    int f = item.compareTo(root.element);
    if (f == 0){
      found = true;
    }
    else if(f < 0){
      found = findRecursively(root.left, item);
    }
    else{
      found = findRecursively(root.right, item);
    }
    return found;
  }

  // ********************************** delete(T item) **********************************

  // this is a public method that delegates the deletion process to a private, recursive method
  public void delete(T item){
    this.root = deleteRecursively(this.root, item);
  }

  // a private method to recursively delete item from the tree
  private Node<T> deleteRecursively(Node<T> root, T item){

    if(root!=null){
      int r = item.compareTo(root.element);

      if(r < 0)
        root.left = deleteRecursively(root.left, item);
      else if(r > 0)
        root.right = deleteRecursively(root.right, item);
      else{

        //case 1: the root node is a leaf node
        if(root.left==null && root.right==null){
          root = null; // delete the current node safely

        // case 2: the root node has one child (on left then on right)
        }else if(root.right==null)
          root = root.left;
        else if(root.left==null)
          root = root.right;
   
        // case 3: the root node has two children
        else {
          T minItem = getMinRecursively(root.right);
          root.element = minItem;
          root.right = deleteRecursively(root.right,minItem);
        }
        System.out.println(item+" was deleted form the tree.");
      }
    }
    return root;
  }
  /********************************** getMin() and getMinRecursively(Node<T> root) **********************************
  * Description: The getMin function and the the private helper getMinRecursively function that follows
  * recursively look through the left side of the tree to return to the user the minimum value.
  *
  * Parameters: the private helper getMinRecursively takes in Node<T> root 
  *
  * Pre: tree must either exist or be null.
  *
  * Post: the function will return the minimum value of the tree to the user
  *
  * Returns: returns the integer min value of the tree
  *
  * Called by: private helper is called by getMin and getMin is called by main
  * Calls: private helper getMinRecursively
  ************************************************************************/
  public T getMin(){
    if (this.root == null){
      System.out.println("The tree is empty");
      return null;
    }
    return getMinRecursively(this.root);
  }

  private T getMinRecursively(Node<T> root){
    T item = null;
    if(root.left==null){
      item = root.element;
    }
    else{
      item = getMinRecursively(root.left);
    }
    return item;
  }

  /********************************** getMax() **********************************
  * Description: The getMax function and the the private helper getMaxRecursively function that follows
  * recursively look through the right side of the tree to return to the user the maximum value.
  *
  * Parameters: the private helper getMaxRecursively takes in Node<T> root 
  *
  * Pre: tree must either exist or be null.
  *
  * Post: the function will return the maximum value of the tree to the user
  *
  * Returns: returns the integer max value of the tree
  *
  * Called by: private helper is called by getMax and getMax is called by main
  * Calls: private helper getMaxRecursively
  ************************************************************************/
  public T getMax(){
    if (this.root == null){
      System.out.println("tree is empty");
      return null;
    }
    return getMaxrecursively(this.root);
  }

  private T getMaxrecursively(Node<T> root){
    T item = null;
    if (root.right == null){
      item = root.element;
    }
    else{
      item = getMaxrecursively(root.right);
    }
    return item;
  }
}

// The class for the Main Program
public class assignment6 {

  public static void main(String[] args) { // The main() method

    BinaryTree<Integer> tree = new BinaryTree<>();
    Integer ch, item, index;
    boolean quit = false;

    Scanner sc = new Scanner(System.in);

    do{
  
      System.out.println( "____________Main Menu_____________________");
      System.out.println( "select option :");
      System.out.println( "1: insert item");
      System.out.println( "2: find item");
      System.out.println( "3: tree height");
      System.out.println( "4: display items");
      System.out.println( "5: delete item");
      System.out.println( "6: get max");
      System.out.println( "7: get min");
      System.out.println( "8: tree size");
      System.out.println( "9: exit");
      ch = sc.nextInt();

      switch (ch) {
        case 1:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          tree.insert(item);
          break;
        case 2:
          System.out.println( "enter item to insert:");
          item = sc.nextInt(); // read in an integer
          if(tree.find(item))
            System.out.println(item+" is found in the tree!");
          else
            System.out.println("Sorry... "+item+" is NOT found in the tree!");
          break;
        case 3:
          System.out.println("The height of the tree is: "+tree.height());
          break;
        case 4:
          tree.displayAll();
          break;
        case 5:
          System.out.println( "enter item to delete:");
          item = sc.nextInt(); 
          tree.delete(item);
          break;
        case 6:
          System.out.println("The max of the tree is: " + tree.getMax());
          break;
        case 7:
          System.out.println("The min of the tree is: " + tree.getMin());
          break;
        case 8:
          System.out.println("The size of the tree is: " + tree.size());
          break;
        case 9:
          quit = true;
          System.out.println( "Goodbye!!");
          break;
        default:
          System.out.println( "invalid selection");
      }
    } while(!quit);
  }
}
