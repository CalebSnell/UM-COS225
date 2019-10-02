public class ArrayStack<T> implements Stack<T>{

    private int capacity;
    private T top;
    private T[] array;

    public ArrayStack(){
        capacity = 10;
        array = (T[]) new Object[10];
        top = null;
    }

    public ArrayStack(int s){
        capacity = s;
        array = (T[]) new Object[s];
        top = null;
    }

    @Override
    public void push(T element) {
        for (int i = 0; i < capacity; i++){
            if (array[i] == null){
                array[i] = element;
                top = array[i];
                return;
            }
        }
        //Resize();
    }

    @Override
    public T pop() {
        int in = 0;
        for (int i = 0; i < capacity; i++){
            if (array[i] == top){
                in = i;
            }
        }
        array[in] = null;
        T temp = top;
        if (in == 0){
            top = null;
        }
        else{
            top = array[in-1];
        }
        return temp;
    }

    @Override
    public T peek() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        for (int i = 0; i < capacity; i++){
            if (array[i] == null){
                return i;
            }
        }
        return 0;
    }

}