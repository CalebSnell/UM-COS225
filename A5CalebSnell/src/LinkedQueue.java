public class LinkedQueue<T> implements Queue<T>{

    LinearNode<T> head;			//Front of the line = index 0 / who is about to be DQ'ed
    LinearNode<T> tail;
    int size = 0;

    public LinkedQueue(){
        head = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {	//O(n)
//		LinearNode<T> temp = head;
//		while (temp.getNext() != null){
//			temp = temp.getNext();
//		}
//		LinearNode<T> newNode = new LinearNode<T>(element);
//		temp.setNext(newNode);

        tail.setNext(new LinearNode<T>(element));	//O(1)
        tail = tail.getNext();
        size++;
    }

    @Override
    public T dequeue() {			//O(1)
        if (head != null){
            LinearNode<T> temp;
            temp = head;
            head = head.getNext();
            size--;
            return temp.getElement();
        }
        else{
            return null;
        }
    }

    @Override
    public T peek() {				//O(1)
        if (head != null){
            return head.getElement();
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isEmpty() {			//O(1)
        return head == null;
    }

    @Override
    public int size() {			//O(n);   //O(1)
        return size;
    }



}