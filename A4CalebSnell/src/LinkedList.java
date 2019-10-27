import java.io.*;

public class LinkedList<T> {

    LinearNode<T> cHead;
    LinearNode<T> cTail;
    int cSize = 0;

    public LinkedList() {
        // POST: Create default linked list
        cHead = null;
        cTail = null;
        cSize = 0;
    }

    public void insert(T element) {
        // Create temporary linear node
        LinearNode<T> tempHeadNode = new LinearNode(element);
        tempHeadNode.setNext(null);

        // Assign tempNode to head if linked list is empty
        if (cHead == null) {
            cHead = tempHeadNode;
        } else {
            LinearNode<T> tempLastNode = cHead;
            while (tempLastNode.getNext() != null) {
                tempLastNode = tempLastNode.getNext();
            }

            // In

        }
    }
}


