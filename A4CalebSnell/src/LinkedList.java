public class LinkedList<T> {
    // create default head and size
    LinearNode<T> cHead;
    int cSize = 0;

    public LinkedList() {
        // POST: Create default linked list
        cHead = null;
        cSize = 0;
    }

    public void insert(T object) {
        // Create temporary linear node
        LinearNode<T> tempNode = new LinearNode(object);
        LinearNode<T> curNode = cHead;

        // Set head to first new object if linkedList is empty
        if (cHead == null) {
            cHead = new LinearNode<T>(object);
        }

        // Get to last node
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
        }

        // Set current node next reference to new object
        curNode.setNext(tempNode);

            // Increase size
            cSize++;
    }

    public int size () {
    // POST: return size of linked list
        return cSize;
    }
}


