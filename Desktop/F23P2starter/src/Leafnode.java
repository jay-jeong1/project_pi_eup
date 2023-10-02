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
public class Leafnode extends BintreeNode
{
    private LinkedList<Seminar> leafList;

    /**
     * Constructor
     */
    public Leafnode() {
        this.leafList = new LinkedList<>();
    }

    /**
     * Getter for leafList
     * 
     * @return The linkedList of leaf node
     */
    public LinkedList<Seminar> getSeminarList() {
        return leafList;
    }

    /**
     * Add a seminar to the linkedList
     * 
     * @param seminar The seminar to be added
     */
    public void addList(Seminar seminar) {
        leafList.add(seminar);
    }

    /**
     * Remove a seminar in the linked list
     * 
     * @param seminar The seminar to be removed.
     */
    public void removeList(Seminar seminar) {
        leafList.remove(seminar);
    }
}