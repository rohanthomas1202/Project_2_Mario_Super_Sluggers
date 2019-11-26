/*******************************
 ** Name    - Rohan Sam Thomas **
 ** UTDID   - RST170000        **
 ** Class   - CS2336           **
 ** Date    - 10/17/2019       **
 ** JDK     - 11               **
 ** IDE     - IntelliJ Idea    **
 ********************************/
public class Node<E extends Comparable<E>> {

    // node to keep track of the next node
    private Node next;
    // generic player type
    private E payload;

    // constructors accessors and mutators
    public Node() {
        next = null;
        payload = null;
    }

    Node(E o) {
        payload = o;
    }

    E getPayload() {
        return payload;
    }

    void setPayload(E o) {
        payload = o;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node nextValue) {
        next = nextValue;
    }

    // compare to function
    public int compareTo(Object o) {
        int compare = 0;
        return compare;
    }

}