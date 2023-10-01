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
 * InternalNode class
 * 
 * @author Jaison Dasika
 * @author Jihoo Jeong
 */
public class Internalnode extends BintreeNode
{
    private BintreeNode left;
    private BintreeNode right;

/**
 * Constructor for Internal node class.
 * @param left The left of the Internal node
 * @param right The right of the Internal node
 */
public Internalnode(BintreeNode left, BintreeNode right) {
    this.left = left;
    this.right = right;
}
/**
 * Getter for left node
 * @return The left node
 */
public BintreeNode getLeft() {
    return left;
}
/**
 * Getter for right node
 * @return The right node
 */
public BintreeNode getRight() {
    return right;
}

/**
 * Getter for left node
 * @return The left node
 */
public void setLeft(BintreeNode left) {
    this.left = left;
}
/**
 * Getter for right node
 * @return The right node
 */
public void setRight(BintreeNode right) {
    this.right = right;
}

}


