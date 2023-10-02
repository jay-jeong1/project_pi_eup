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
 * @version 10/1/2023
 * @author Jaison Dasika
 * @author Jihoo Jeong
 * @param <T> generic type
 */
class LinkedList<T>
{
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
     * 
     * @param data The data to be added
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Remove a data from the linked list
     * 
     * @param data The data to be removed
     */
    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null && !current.getData().equals(data)) {
            prev = current;
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        prev.setNext(current.getNext());
        size--;
    }

    /**
     * Getter for the size of the linked list
     * 
     * @return The size of the linked list
     */
    public int getSize() {
        return size;
    }
}

/**
 * Node class for linked list node
 * 
 * @version 10/1/2023
 * @author Jaison Dasika
 * @author Jihoo Jeong
 * @param <T>
 */
class Node<T>
{
    /**
     * data field
     */
    private T data;
    /**
     * next node field
     */
    private Node<T> next;

    /**
     * Constructor
     * 
     * @param data The data in the node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Getter for node data
     * 
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for node data
     * 
     * @param data The data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter for next node
     * 
     * @return next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter for next node
     * 
     * @param next The next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}