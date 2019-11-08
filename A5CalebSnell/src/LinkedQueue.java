// Written by Chris Dufour for COS 225, adjusted for A5 by Caleb SNell

public class LinkedQueue<T> implements Queue<T>{

    LinearNode<T> head;			//Front of the line = index 0 / who is about to be DQ'ed
    LinearNode<T> tail;
    int size = 0;

    //-----CONSTRUCTORS-----//
    public LinkedQueue(){
        head = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        // POST: Add item to end of queue, increment queue size
        LinearNode<T> tempNode = tail;
        tail = new LinearNode();
        tail.setElement(element);
        tail.setNext(null);

        // If queue is empty, assign tail to head (i.e set given data to head)
        if (isEmpty()) {
            head = tail;
        }
        // Else set next tail to given data
        else {
            tempNode.setNext(tail);
        }

        // increment queue size
        size++;
    }

    //-----MODIFIERS-----//
    @Override
    public T dequeue() {
        // POST: Remove first node from queue, return element
        if (head != null){
            LinearNode<T> temp;
            temp = head;
            head = head.getNext();
            size--;
            return temp.getElement();
        } else{
            return null;
        }
    }

    //------ACCESSORS------//
    @Override
    public T peek() {
        // POST: Return first element
        if (head != null){
            return head.getElement();
        } else{
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        // POST: Return status of queue (empty, true/false)
        return head == null;
    }

    @Override
    public int size() {
        // POST: Return size of queue, >=0
        return size;
    }


}