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
 * Seminar Database Class
 * 
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 10/1/2023
 */
public class SeminarDB
{
    private BST<Integer, Seminar> idTree;
    private BST<String, Seminar> dateTree;
    private BST<Integer, Seminar> costTree;
    private BST<String, Seminar> keywordTree;
    private Bintree locationTree;
    private int worldSize;

    /**
     * SeminarDB constructor
     * 
     * @param wSize worldSize
     */
    public SeminarDB(int wSize) {
        this.worldSize = wSize;
        idTree = new BST<>();
        dateTree = new BST<>();
        costTree = new BST<>();
        keywordTree = new BST<>();
        locationTree = new Bintree(worldSize);
    }
    // ----------------------------------------------------------

    /**
     * Inserts the Seminar object into the BST.
     *
     * @param record The key(ID) to be inserted
     * @return Return true if the insertion was successful.
     */
    public boolean insertIdTree(KVPair<Integer, Seminar> record) {
        Integer key = record.getKey();
        Seminar found = idTree.find((Integer) key);
        boolean isInserted = false;
        if (found == null) {
            idTree.insert(record);
            System.out.println("Successfully inserted record with ID " + record
                .getKey());
            System.out.println(record.getValue().toString());
            isInserted = true;
        }
        else {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + record
                    .getKey());
            isInserted = false;
        }
        return isInserted;
    }
    // ----------------------------------------------------------

    /**
     * Inserts the key(keywords) into the BST.
     * 
     * @param record The key(keywords) to be inserted
     */
    public void insertKeywordTree(KVPair<String, Seminar> record) {
        keywordTree.insert(record);
    }

    // ----------------------------------------------------------
    /**
     * Inserts the key(cost) into the BST.
     * 
     * @param record The key(cost) to be inserted.
     */
    public void insertCostTree(KVPair<Integer, Seminar> record) {
        costTree.insert(record);
    }

    /**
     * insert into the location tree (bintree)
     * 
     * @param s      the seminar record
     * @param coords the x and y coordinates
     * @return if it was successful or not
     */
    public boolean insertLocationTree(int[] coords, Seminar s) {
        return locationTree.insert(coords, s);
    }
    // ----------------------------------------------------------

    /**
     * Inserts the date(String) into the BST
     * 
     * @param record The key(date) to be inserted
     */
    public void insertDateTree(KVPair<String, Seminar> record) {
        dateTree.insert(record);
    }

    // ----------------------------------------------------------
    /**
     * Searches the seminar database in the BST.
     * 
     * @param id the Id to be searched
     * @return True if the Id is found
     */
    public boolean searchIdTree(Integer id) {
        Seminar found = idTree.find(id);
        boolean isFound = false;
        if (found != null) {
            System.out.println("Found record with ID " + id + ":");
            System.out.println(found.toString());
            isFound = true;
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
        return isFound;
    }
    // ----------------------------------------------------------

    /**
     * Searching the keyword tree using range search
     * 
     * @param s The keyword to be searched
     */
    public void searchKeywordTree(String s) {
        System.out.println("Seminars matching keyword " + s + ":");
        keywordTree.searchRange(s, s);
    }

    // ----------------------------------------------------------
    /**
     * Searches the cost tree with range search
     * 
     * @param min The minimum boundary of the range search
     * @param max The maximum boundary of the range search
     */
    public void searchCostTree(Integer min, Integer max) {
        System.out.println("Seminars with costs in range " + min + " to " + max
            + ":");
        costTree.searchRange(min, max);
        System.out.println(costTree.getVistedNodeCount()
            + " nodes visited in this search");
    }

    // ----------------------------------------------------------
    /**
     * Searches date in the date tree.
     * 
     * @param min The minimum boundary of the range
     * @param max The maximum boundary of the range
     */
    public void searchDateTree(String min, String max) {
        System.out.println("Seminars with dates in range " + min + " to " + max
            + ":");
        dateTree.searchRange(min, max);
        System.out.println(dateTree.getVistedNodeCount()
            + " nodes visited in this search");
    }

    // ----------------------------------------------------------
    /**
     * Getter for IdTree
     * 
     * @return Number of nodes
     */
    public BST<Integer, Seminar> getIdTree() {
        return idTree;
    }

    // ----------------------------------------------------------
    /**
     * Getter for CostTree
     * 
     * @return Number of nodes
     */
    public BST<Integer, Seminar> getCostTree() {
        return costTree;
    }

    // ----------------------------------------------------------
    /**
     * Getter for KeywordTree
     * 
     * @return Number of nodes
     */
    public BST<String, Seminar> getKeywordTree() {
        return keywordTree;
    }

    // ----------------------------------------------------------
    /**
     * Getter for DateTree
     * 
     * @return Number of nodes
     */
    public BST<String, Seminar> getDateTree() {
        return dateTree;
    }

    /**
     * delete item from all trees
     * 
     * @param key they key of the record to delete
     */
    public void delete(int key) {
        Seminar s = idTree.find(key);
        String[] stringKey = s.keywords();
        String date = s.date();
        int cost = s.cost();
        for (String string : stringKey) {
            if (keywordTree.remove(string)) {
                continue;
            }
            else {
                System.out.println("Error deleting keyword: " + string
                    + " from the keyword tree");
                return;
            }
        }
        if (idTree.remove(key) && costTree.remove(cost) && dateTree.remove(
            date)) {
            System.out.println("Record with ID " + key
                + " successfully deleted from the database");
        }
        else {
            System.out.println("Error deleting item");
        }
    }

    /**
     * print location tree
     */
    public void printLocationTree() {
        locationTree.print();
    }

    // ----------------------------------------------------------
    /**
     * print IDTree
     */
    public void printIDTree() {
        idTree.printIDTree();
    }

    // ----------------------------------------------------------
    /**
     * print CostTree
     */
    public void printCostTree() {
        costTree.printCostTree();
    }
    // ----------------------------------------------------------

    /**
     * print DateTree
     */
    public void printDateTree() {
        dateTree.printDateTree();
    }
    // ----------------------------------------------------------

    /**
     * print KeywordTree
     */
    public void printKeywordTree() {
        keywordTree.printKeywordTree();
    }
}