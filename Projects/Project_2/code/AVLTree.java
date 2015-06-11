/**
 * AVLTree.java
 *
 *
 * Author: Guthrie Price
 * Date: 6/10/2015 
 * Purpose: Implementation of an AVLTree
 */

//TODO: Fix bug in deletion
//
import java.lang.Math;

public class AVLTree{

    private AVLNode root; //The root node of the tree
    
    //Consctructor for the AVLTree
    public AVLTree(){
        root = null;
    }
    //Returns the root of the tree
    public AVLNode getRoot(){
        return root;
    }
    //Tests if the tree is empty
    public boolean isEmpty(){
        return root == null;
    }
    //Set the tree to be empty
    public void makeEmpty(){
        root = null;
    }
    //Public insert function entry point
    public void insert(int data){
        root = insert(data, root);
    }
    //Public remove function entry point
    public void remove(int data){
        root = remove(data, root);
    }
    //Returns the height of a node, or if the node is empty
    //returns -1
    private int height(AVLNode node){
        if(node == null)
            return -1;
        return node.height;
    }
    //Utility function for testing if a number is bigger than another
    //TODO: Put this function in the Utility class
    private int max(int left, int right){
        if(left>right)
            return left;
        return right;
    }
    //Main insert function
    private AVLNode insert(int elem, AVLNode node){
        //If the node is null, then insert the element here
        if(node == null)
            node = new AVLNode(elem);
        //Else begin checking where the node should be inserted

        //If the node to be inserted (IN) is bigger than the left child of the
        //current node (LN) then change the (LN) by inserting the (IN) into
        //the (LN). Finally balance the tree.
        else if(elem < node.data){
            node.left = insert(elem, node.left);
            //Balance the tree if its unbalanced
            if(height(node.left)-height(node.right) == 2)
                if(elem < node.left.data)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        }
        //If the node to be inserted (IN) is bigger than the right child (RN)
        //of the current node then change the (RN) by inserting the (IN) into
        //the (RN). Finally balance the tree.
        else if(elem > node.data){
            node.right = insert(elem, node.right);
            if(height(node.right)-height(node.left) == 2)
                if(elem > node.right.data)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }
        //Adjust the height of the current node
        node.height = max(height(node.left), height(node.right))+1;
        return node;
    }

    //Main remove function
    //TODO: Fix bug
    private AVLNode remove(int elem, AVLNode node){
        if(node == null){
            return null;
        }
        if(elem < node.data){
            node.left = remove(elem,node.left);
            int h1;
            if(node.left != null)
                h1 = node.left.height;
            else
                h1 = 0;
            if((node.right != null) && (node.right.height - h1 >= 2)){
                int rightHeight;
                if(node.right.right != null)
                    rightHeight = node.right.right.height;
                else
                    rightHeight = 0;
                int leftHeight;
                if(node.right.left != null)
                    leftHeight = node.right.left.height;
                else
                    leftHeight = 0;
                if(rightHeight >= leftHeight)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithRightChild(node);
            }
        }
        else if(elem > node.data){
            node.right = remove(elem, node.right);
            int h2;
            if(node.right != null)
                h2 = node.right.height;
            else
                h2 = 0;
            if((node.left != null) && (node.left.height - h2 >= 2)){
                int leftHeight;
                if(node.left.left != null)
                    leftHeight = node.left.left.height;
                else
                    leftHeight = 0;
                int rightHeight;
                if(node.left.right != null)
                    rightHeight = node.left.right.height;
                else
                    rightHeight = 0;
                if(leftHeight >= rightHeight)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithLeftChild(node);
            }
        }
        else if(node.left != null){
            node.data = findMax(node.left).data;
            remove(node.data, node.left);
            if((node.right != null) && (node.right.height - node.left.height >= 2)){
                int rightHeight;
                if(node.right.right != null)
                    rightHeight = node.right.right.height;
                else
                    rightHeight = 0;
                int leftHeight;
                if(node.right.left != null)
                    leftHeight = node.right.left.height;
                else
                    leftHeight = 0;
                if(rightHeight >= leftHeight)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithRightChild(node);
            }
        }
        else{
            if(node.left != null)
                node = node.left;
            else
                node = node.right;
        }
        if(node != null){
            int leftHeight;
            if(node.left != null)
                leftHeight = node.left.height;
            else
                leftHeight = 0;
            int rightHeight;
            if(node.right != null)
                rightHeight = node.right.height;
            else
                rightHeight = 0;
            node.height = Math.max(leftHeight,rightHeight)+1;
        }
        return node;
    }
    //Rotate nodes left
    private AVLNode rotateWithLeftChild(AVLNode node1){
        AVLNode node2 = node1.left;
        node1.left = node2.right;
        node2.right = node1;
        node1.height = max(height(node1.left),height(node1.right))+1;
        node2.height = max(height(node2.left),node1.height)+1;
        return node2;
    }
    //Rotate nodes right
    private AVLNode rotateWithRightChild(AVLNode node1){
        AVLNode node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        node1.height = max(height(node1.left),height(node1.right))+1;
        node2.height = max(height(node2.right),node1.height)+1;
        return node2;
    }
    //Double rotate functions
    private AVLNode doubleWithLeftChild(AVLNode node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }
    private AVLNode doubleWithRightChild(AVLNode node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }
    //Count the number of nodes in the tree
    public int countNodes(){
        return countNodes(root);
    }
    private int countNodes(AVLNode node){
        if(node == null)
            return 0;
        else{
            int numOfNodes = 1;
            numOfNodes += countNodes(node.left);
            numOfNodes += countNodes(node.right);
            return numOfNodes;
        }
    }
    //Search for a particular node in the tree
    public boolean search(int elem){
        return search(root, elem);
    }
    private boolean search(AVLNode node, int elem){
        boolean found = false;
        while((node != null) && !found){
            int nodeData = node.data;
            if(elem<nodeData)
                node = node.left;
            else if(elem > nodeData)
                node = node.right;
            else{
                found = true;
                break;
            }
            found = search(node, elem);
        }
        return found;
    }
    //Find the maximum node in a tree
    public AVLNode findMax(AVLNode node){
        if(node == null)
            return node;
        while(node.right != null)
            node = node.right;
        return node;
    }
    //In-order traversal function
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(AVLNode node){
        if(node!=null){
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }
    //Pre-order traversal function
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(AVLNode node){
        if(node != null){
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    //Post-order traversal function
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(AVLNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }
    //Visit function used in traversals.
    //Print out the data and height.
    private void visit(AVLNode node){
        System.out.println("Data: "+node.data+"   Height: "+node.height);
    }
}

