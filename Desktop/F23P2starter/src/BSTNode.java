// On my honor:
// - I have not used source code obtained from another current or
//   former student, or any other unauthorized source, either
//   modified or unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
/**
 * BSTNode class that refers to the node of the tree.
 * 
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 10/1/2023
 * @param <E>
 */
public class BSTNode<E extends Comparable<? super E>> {

    private E value; // Element for this node
    private BSTNode<E> left; 
    private BSTNode<E> right;

// -------------------------------------------------------------------
    /**
     * BSTNode constructor
     */
    BSTNode() {
        left = null;
        right = null; 
    }


    /**
     * Constructor that initialize the value
     * 
     * @param val the value
     */
    BSTNode(E val) {
        left = null;
        right = null;
        value = val;
    }

// -----------------------------------------------------------------------


    /**
     * Getter for value
     * 
     * @return the value
     */
    public E getValue() {
        return this.value;
    }


    // -----------------------------------------------------------------------
    /**
     * Setter for value
     * 
     * @param k
     *            the value to be set
     */
    public void setValue(E k) {
        this.value = k;
    }


    // -----------------------------------------------------------------------
    /**
     * Getter for left
     * 
     * @return The left element
     */
    public BSTNode<E> getLeft() {
        return left;
    }
    // -----------------------------------------------------------------------
    /**
     * Getter for right
     * 
     * @return The right element
     */
    public BSTNode<E> getRight() {
        return right;
    }
    // -----------------------------------------------------------------------


    /**
     * Setter for left
     * @param left BSTNode the left
     */
    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }
    // -----------------------------------------------------------------------


    /**
     * Setter for right
     * 
     * @param right BSTNode the right
     */
    public void setRight(BSTNode<E> right) {
        this.right = right;
    }
    // -----------------------------------------------------------------------


    /**
     * Checks if it is leaf or not
     * 
     * @return 'True' if it is a leaf 'False' if it is not a leaf
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}