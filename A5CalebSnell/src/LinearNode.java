public class LinearNode<T> {
    private T element;                    // element
    private LinearNode<T> next;            // reference to next element

    public LinearNode() {
        // POST: empty node
        element = null;
        next = null;
    }

    public LinearNode(T elem) {
        // POST: node set to element
        element = elem;
        next = null;
    }

    //-----MODIFIERS-----//
    public LinearNode<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    //------ACCESSORS------//
    public void setNext(LinearNode<T> node) {
        next = node;
    }

    public void setElement(T elem) {
        element = elem;
    }
}