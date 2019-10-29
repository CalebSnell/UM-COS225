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
        } else {
            // Get to last node
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            // Set current node next reference to new object
            curNode.setNext(tempNode);
        }

        // Increase size
        cSize++;
    }

    public T get(int index) {
        //LinearNode<T> tempNode = new LinearNode<>();
        LinearNode<T> curNode = cHead;

        // Catch index 0, return first element
        if (index == 0) {
            return cHead.getElement();
        }
        // Loop through until desired index is reached
        else if (index >= 1) {
            for (int ct1 = 0; ct1 < index; ct1++) {
                curNode = curNode.getNext();
            }
            // Return requested element
            return curNode.getElement();
        }
        // Catch invalid index
        else {
            throw new ArithmeticException("Invalid index");
        }
    }

    public void remove(int index) {
        LinearNode<T> tempNode = new LinearNode<>();
        LinearNode<T> curNode = cHead;

        // Catch if trying to remove first element (0)
        if (index == 0) {
            cHead = cHead.getNext();
            cSize--;
        }
        // Continue to loop through linked list if index is valid
        else if (index >= 1) {
            for (int ct2 = 0; ct2 < index - 1; ct2++) {
                // Remove requested node
                curNode = curNode.getNext();
                tempNode = curNode;
                curNode = curNode.getNext();
                tempNode.setNext(curNode.getNext());

                // Decrease size
                cSize--;
            }
        }
        // Catch invalid index
        else {
            throw new ArithmeticException("Invalid index");
        }
    }

    public int size () {
    // POST: return size of linked list
        return cSize;
    }
}


