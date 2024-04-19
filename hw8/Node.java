/**
 * Represents Node in a Singly Linked List.
 * @author Eddie Kwak
 * @version 1
 * @param <T> Generic type.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Two-argument constructor for creating new nodes.
     * @param d Node's data.
     * @param n Node's next pointer.
     */
    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    /**
     * One-argument constructor for creating new nodes.
     * @param d Node's data.
     */
    public Node(T d) {
        data = d;
        next = null;
    }

    /**
     * Getter for node's data.
     * @return Return's node's data.
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for node's data.
     * @param d Node's data.
     */
    public void setData(T d) {
        data = d;
    }

    /**
     * Getter for node's next pointer.
     * @return Return's a node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter for node's next pointer.
     * @param n Node's new next.
     */
    public void setNext(Node<T> n) {
        next = n;
    }
}