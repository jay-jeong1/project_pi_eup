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
 * Bintree Node class
 * 
 * @version 10/1/2023
 * @author Jaison Dasika
 * @author Jihoo Jeong
 */
public class BintreeNode
{
    private BintreeNode left;
    private BintreeNode right;
    private Seminar sem;
    
    private static final EmptyLeaf EMPTY_LEAF = EmptyLeaf.getInstance();

    
    
    /**
     * constructor
     * @param s seminar
     */
    public BintreeNode(Seminar s) {
        this.sem = s;
        this.left = EMPTY_LEAF;
        this.right = EMPTY_LEAF ;
    }
    
    /**
     * constructor
     */
    public BintreeNode() {
        left = EmptyLeaf.getInstance();
        right = EmptyLeaf.getInstance();
    }

    
    /**
     * Getter for value
     * 
     * @return the value
     */
    public Seminar getSem() {
        return this.sem;
    }


    // -----------------------------------------------------------------------
    /**
     * Setter for value
     * 
     * @param k  the value to be set
     */
    public void setValue(Seminar k) {
        this.sem = k;
    }


    // -----------------------------------------------------------------------
    /**
     * Getter for left
     * 
     * @return The left element
     */
    public BintreeNode getLeft() {
        return left;
    }
    // -----------------------------------------------------------------------


    /**
     * Getter for right
     * 
     * @return The right element
     */
    public BintreeNode getRight() {
        return right;
    }
    // -----------------------------------------------------------------------


    /**
     * Setter for left
     * @param left the left node
     */
    public void setLeft(BintreeNode left) {
        this.left = left;
    }
    // -----------------------------------------------------------------------


    /**
     * Setter for right
     * 
     * @param right the right element
     */
    public void setRight(BintreeNode right) {
        
        this.right = right;
    }
    // -----------------------------------------------------------------------

    
}