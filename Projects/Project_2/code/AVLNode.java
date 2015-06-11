/**
 * AVLNode.java
 *
 *
 * Author: Guthrie Price
 * Date: 6/10/2015 
 * Purpose: Node used in the AVLTree class
 */

public class AVLNode{

    AVLNode left; //The left child
    AVLNode right; //The right child
    int data; //Data in the node
    int height; //Height of the node in the AVLTree

    // Default constructor for the AVLNode
    public AVLNode(){
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    // Constructor for the AVLNode given initial data
    public AVLNode(int n){
        left = null;
        right = null;
        data = n;
        height = 0;
    }     
}
