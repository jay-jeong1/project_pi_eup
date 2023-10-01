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
 * EmptyLeaf class
 * 
 * @author Jaison Dasika
 * @author Jihoo Jeong
 * @version 10/1/2023
 */
public class Bintree
{
    private int worldSize;
    private BintreeNode root;

    /**
     * constructor
     * 
     * @param wSize the world size
     */
    public Bintree(int wSize) {
        this.root = new EmptyLeaf();
        worldSize = wSize;
    }

    /**
     * bintree insert
     * 
     * @param coords the coordinates
     * @param record the seminar
     * @return boolean
     */
    public boolean insert(int[] coords, Seminar record) {
        int x = coords[0];
        int y = coords[1];
        // check that the coords are not out of bounds
        if (x < 0 || y < 0 || x > worldSize - 1 || y > worldSize - 1) {
            System.out.println("Insert FAILED - Bad x, y coordinates: " + x
                    + ", " + y);
            return false;
        }
        root = insertHelp(root, record);
        return true;
    }

    /**
     * insert help
     * 
     * @param rt  the bintreeNode
     * @param sem the Seminar object
     * @return BinTreeNode
     */
    public BintreeNode insertHelp(BintreeNode rt, Seminar sem) {
        if (rt instanceof EmptyLeaf) {
            rt = new Leafnode();
            ((Leafnode) rt).addList(sem);
            return rt;
        }
        if (rt instanceof Leafnode && rt.getSem() == sem) {
            ((Leafnode) rt).addList(sem);
        }
        else if (rt instanceof Leafnode && rt.getSem() != sem) {
            rt = new Internalnode(EmptyLeaf.getInstance(), EmptyLeaf
                    .getInstance());
            rt.setRight(rt);
        }
        return rt;
    }

    /**
     * bintree delete
     */
    public void delete() {
        //sfdsdffd
    }

    /**
     * print method
     */
    public void print() {
        System.out.println("E");
    }
}