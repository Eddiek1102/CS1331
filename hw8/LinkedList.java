import java.util.NoSuchElementException;
/**
 * Class Representing a Singly Linked List.
 * @author Eddie Kwak
 * @version 1.0
 * @param <T> Generic type.
 */
public class LinkedList<T> implements List<T>, Queue<T>, Stack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * No-argument constructor for linked list.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    /**
     * Checks if linked list is empty.
     * @return Boolean true if empty.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    /**
     * Getter for linked list's size.
     * @return Integer size of linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Gets node at certain index.
     * @param index Node to be returned.
     * @return Node at index.
     */
    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    /**
     * Adds new node at specified index.
     * @param index Index to add node to.
     * @param data Data used to create new node.
     */
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (data == null) {
            throw new IllegalArgumentException("Can only add non-null data");
        }
        if (index == 0) {
            head = new Node<>(data, head);
            if (tail == null) {
                tail = head;
            }
        } else if (index == size) {
            Node<T> newNode = new Node<>(data);
            tail.setNext(newNode);
            tail = tail.getNext();
        } else {
            Node<T> current = getNode(index - 1);
            Node<T> newNode = new Node<>(data, current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    /**
     * Adds new node to end of linked list.
     * @param data Data to create new node.
     */
    public void add(T data) {
        add(size, data);
    }

    @Override
    /**
     * Removes data at specified index and returns the removed data.
     * @param index Index to remove.
     * @return The data being removed.
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        T removedData;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> current = getNode(index - 1);
            removedData = current.getNext().getData();
            Node<T> nextNext = current.getNext().getNext();
            current.setNext(nextNext);
            if (current.getNext() == null) {
                tail = current;
            }
        }
        size--;
        return removedData;
    }

    @Override
    /**
     * Removes first occurance of data if it exists.
     * @param data Data to be removed.
     * @return The data being removed.
     */
    public T remove(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException("Not possible to remove entry from an empty list.");
        }
        if (head.getData().equals(data)) {
            T removedData = head.getData();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            return removedData;
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(data)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new NoSuchElementException("Element not found in the list.");
        }
        T removedData = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
            tail = current;
        }
        size--;
        return removedData;
    }

    @Override
    /**
     * Retrieves data from specified index and returns it.
     * @param index Index to get data from.
     * @return Data being retrieved.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        return getNode(index).getData();
    }

    @Override
    /**
     * Modifies data in the linked list at specified index.
     * @param index The index at which data will be added.
     * @return the data originally at specified index.
     */
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (data == null) {
            throw new IllegalArgumentException("Can only set non-null values!");
        }
        Node<T> node = getNode(index);
        T oldData = node.getData();
        node.setData(data);
        return oldData;
    }

    @Override
    /**
     * Checks to see if list contains particular data.
     * @param data Data to look for.
     * @return True if the list contains the data, false otherwise.
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be in list");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    /**
     * Removes all elements form the linked list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    /**
     * Reverses the linked list.
     */
    public void reverse() {
        head = reverseRecursion(head, null);
    }

    /**
     * Helper method for reversing the linked list.
     * @param current Current node.
     * @param prev Previous node.
     * @return Popped node.
     */
    private Node<T> reverseRecursion(Node<T> current, Node<T> prev) {
        if (current == null) {
            return prev;
        }
        Node<T> next = current.getNext();
        current.setNext(prev);
        return reverseRecursion(next, current);
    }

    @Override
    public void enqueue(T data) {
        add(data);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from empty queue.");
        }
        return remove(0);
    }

    @Override
    public void push(T data) {
        add(0, data);
    }

    @Override public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop from empty stack.");
        }
        return remove(0);
    }

    /**
     * LinkedList's toString method.
     * @return LinkedList's toString.
     */
    public String toString() {
        Node<T> current = head;
        String toReturn = "";
        while (current != null) {
            toReturn += "[" + current.getData() + "]";
            if (current.getNext() != null) {
                toReturn += " --> ";
            }
            current = current.getNext();
        }
        return toReturn;
    }
}