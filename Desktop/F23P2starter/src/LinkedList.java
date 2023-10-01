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
 * LinkedList class
 * 
 * @author Jaison Dasika
 * @author Jihoo Jeong
 */
class LinkedList<T> {
    
    private Node<T> head;
    private int size;
    /**
     * Constructor of LinkedList
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    /**
     * Add data to the linked list
     * @param data The data to be added
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    /**
     * Remove a data from the linked list
     * @param data The data to be removed
     */
    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
        size--;
    }
    /**
     * Getter for the size of the linked list
     * @return The size of the linked list
     */
    public int getSize() {
        return size;
    }
}
/**
 * Node class for linked list node
 * @author Jaison Dasika
 * @author Jihoo Jeong
 *
 */
class Node<T> {
    T data;
    Node<T> next;
    /**
     * Constructor
     * @param data The data in the node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
