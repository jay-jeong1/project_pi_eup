// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
/**
 * Represents a binary tree of arbitrary structure. This class is different from
 * those in the textbook. It does not use a separate node class.
 *
 * @param <K> The type of data elements contained in the tree.
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 10/1/2023
 * @param <E>
 */
public class BST<K extends Comparable<K>, E>
{
// ~ Instance/static variables .............................................
    private BSTNode<KVPair<K, E>> root;
    private int nodeCount;
    private int visitedNodeCount;
// ~ Constructors ..........................................................
// ----------------------------------------------------------

    /**
     * Creates a single empty BST
     */
    public BST() {
        this.root = null;
        this.nodeCount = 0;
        this.visitedNodeCount = 0;
    }
// ~ Public Methods ........................................................

    /**
     * Insert the node into the BST
     * 
     * @param record The the record to insert
     */
    public void insert(KVPair<K, E> record) {
        root = insertHelp(root, record);
        nodeCount++;
    }

    // ----------------------------------------------------------
    /**
     * Helper method to insert BSTNode into the tree.
     * 
     * @param rt  The tree node to be inserted
     * @param key The key to be searched
     * @return BSTNode
     */
    public BSTNode<KVPair<K, E>> insertHelp(BSTNode<KVPair<K, E>> rt, KVPair<K,
            E> key) {
        if (rt == null) {
            return new BSTNode<KVPair<K, E>>(key);
        }
        if (rt.getValue().compareTo(key) >= 0) {
            rt.setLeft(insertHelp(rt.getLeft(), key));
        }
        else {
            rt.setRight(insertHelp(rt.getRight(), key));
        }
        return rt;
    }

    // ----------------------------------------------------------
    /**
     * Find the KVPair in the BST
     * 
     * @param key the key to be searched
     * @return the record found
     */
    public E find(K key) {
        return findHelp(root, key);
    }

    // ----------------------------------------------------------
    /**
     * Helper method to find the key in the BST
     * 
     * @param rt  The tree node to be searched
     * @param key The key to be searched
     * @return The record
     */
    public E findHelp(BSTNode<KVPair<K, E>> rt, K key) {
        if (rt == null) {
            return null;
        }
        // Traverse left subtree
        E result = findHelp(rt.getLeft(), key);
        if (result != null) {
            return result;
        }
        // Visit current node
        int comparisonResult = rt.getValue().compareTo(key);
        if (comparisonResult == 0) {
            return (rt.getValue()).getValue(); // Key matches, return the record
        }
        // Traverse right subtree
        return findHelp(rt.getRight(), key);
    }

    // ----------------------------------------------------------
    /**
     * Searches the value within a range.
     * 
     * @param min The minimum boundary for the range search
     * @param max The maximum boundary for range search
     */
    public void searchRange(K min, K max) {
        visitedNodeCount = 0;
        rangeQuery(root, min, max);
        // int totalVisited = getVistedNodeCount();
    }

    // ----------------------------------------------------------
    /**
     * Range search for BST
     * 
     * @param rt  The root to be searched
     * @param min The minimum boundary
     * @param max The maximum boundary
     */
    public void rangeQuery(BSTNode<KVPair<K, E>> rt, K min, K max) {
        visitedNodeCount++;
        if (rt == null) {
            return;
        }
        // If the current node is greater than or equal to min, recur left
        if (rt.getValue().getKey().compareTo(min) >= 0) {
            rangeQuery(rt.getLeft(), min, max);
        }
        // If the current node is within the range, add it to the output
        if (rt.getValue().getKey().compareTo(min) >= 0 && rt.getValue().getKey()
                .compareTo(max) <= 0) {
            System.out.println(rt.getValue().getValue()); // Print the value of
                                                          // the node
        }
        // If the current node is less than max, recur right
        if (rt.getValue().getKey().compareTo(max) <= 0) {
            rangeQuery(rt.getRight(), min, max);
        }
    }

    // ----------------------------------------------------------
    /**
     * Deletes the maximum value of node
     * 
     * @param rt BSTNode
     * @return The node
     */
    public BSTNode<KVPair<K, E>> deleteMax(BSTNode<KVPair<K, E>> rt) {
        if (rt.getRight() == null) {
            return rt.getLeft();
        }
        rt.setRight(deleteMax(rt.getRight()));
        return rt;
    }

    // ----------------------------------------------------------
    /**
     * Gets the pointer of the max value of the node
     * 
     * @param rt The BSTNode
     * @return The node
     */
    private BSTNode<KVPair<K, E>> getMax(BSTNode<KVPair<K, E>> rt) {
        if (rt.getRight() == null) {
            return rt;
        }
        return getMax(rt.getRight());
    }
    // ----------------------------------------------------------

    /**
     * Removes a record from the tree
     * 
     * @param key The key to be removed
     * @return KVPair
     */
    public boolean remove(K key) {
        E temp = findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key); // Now remove it
            nodeCount--;
            return true;
        }
        return false;
    }
    // ----------------------------------------------------------

    /**
     * Helper method to remove the node related to the key value passed in
     * parameter
     * 
     * @return BSTNode The node being deleted
     */
    private BSTNode<KVPair<K, E>> removeHelp(BSTNode<KVPair<K, E>> rt, K key) {
        if (rt == null) {
            return null;
        }
        else if (rt.getValue().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.getLeft(), key));
        }
        else if (rt.getValue().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.getRight(), key));
        }
        else {
            if (rt.getLeft() == null) {
                return rt.getRight();
            }
            else if (rt.getRight() == null) {
                return rt.getLeft();
            }
            else {
                BSTNode<KVPair<K, E>> temp = getMax(rt.getLeft());
                rt.setValue(temp.getValue());
                rt.setLeft(deleteMax(rt.getLeft()));
            }
        }
        return rt;
    }

    // ----------------------------------------------------------
    /**
     * Clears the entire BST
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // ----------------------------------------------------------
    /**
     * Getter for node count
     * 
     * @return nodeCount
     */
    public int getNodeCount() {
        return this.nodeCount;
    }

    /**
     * Getter for visited node count during the range search
     * 
     * @return Node visited during the range search
     */
    public int getVistedNodeCount() {
        return visitedNodeCount;
    }
// ----------------------------------------------------------

    /**
     * Printing Id Tree
     */
    public void printIDTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            printIDHelper(root, 0);
            System.out.println("Number of records: " + getNodeCount());
        }
    }

// ----------------------------------------------------------
    /**
     * Printing Id tree helper
     * 
     * @param theRoot The root to be visited
     * @param level   The level of the tree
     */
    public void printIDHelper(BSTNode<KVPair<K, E>> theRoot, int level) {
        if (theRoot != null) {
            printIDHelper(theRoot.getRight(), level + 1);
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            System.out.print(theRoot.getValue().getKey());
            System.out.println("");
            printIDHelper(theRoot.getLeft(), level + 1);
        }
        else {
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
        }
    }

// ----------------------------------------------------------
    /**
     * Printing the Date tree
     */
    public void printDateTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            printDateHelper(root, 0);
            System.out.println("Number of records: " + getNodeCount());
        }
    }

// ----------------------------------------------------------
    /**
     * Helper method to print date tree
     * 
     * @param theRoot The root to be visited
     * @param level   The tree level
     */
    public void printDateHelper(BSTNode<KVPair<K, E>> theRoot, int level) {
        if (theRoot != null) {
            printDateHelper(theRoot.getRight(), level + 1);
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            Seminar temp = (Seminar) theRoot.getValue().getValue();
            System.out.print(temp.date());
            System.out.println("");
            printDateHelper(theRoot.getLeft(), level + 1);
        }
        else {
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
        }
    }

    // ----------------------------------------------------------
    /**
     * Printing cost tree
     */
    public void printCostTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            printCostHelper(root, 0);
            System.out.println("Number of records: " + getNodeCount());
        }
    }

    // ----------------------------------------------------------
    /**
     * Helper method to print cost tree
     * 
     * @param theRoot The root to be visited
     * @param level   The tree level
     */
    public void printCostHelper(BSTNode<KVPair<K, E>> theRoot, int level) {
        if (theRoot != null) {
            printCostHelper(theRoot.getRight(), level + 1);
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            Seminar temp = (Seminar) theRoot.getValue().getValue();
            System.out.print(temp.cost());
            System.out.println("");
            printCostHelper(theRoot.getLeft(), level + 1);
        }
        else {
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
        }
    }

    // ----------------------------------------------------------
    /**
     * Prints the keyword tree
     */
    public void printKeywordTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            printKeywordHelper(root, 0);
            System.out.println("Number of records: " + getNodeCount());
        }
    }

    // ----------------------------------------------------------
    /**
     * Helper method to print keyword tree
     * 
     * @param theRoot The root to be visited
     * @param level   The tree level
     */
    public void printKeywordHelper(BSTNode<KVPair<K, E>> theRoot, int level) {
        if (theRoot != null) {
            printKeywordHelper(theRoot.getRight(), level + 1);
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            String s = (String) theRoot.getValue().getKey();
            System.out.print(s);
            System.out.println("");
            printKeywordHelper(theRoot.getLeft(), level + 1);
        }
        else {
            for (int i = 0; i < level * 2; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
        }
    }
}