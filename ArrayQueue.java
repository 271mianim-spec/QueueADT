public class ArrayQueue<T> implements QueueInterface{

    private T[] log;
    private int size;
    private int length;

    public ArrayQueue() {
        this.log = (T[]) new Object[4];
        this.size = 0;
        this.length = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object add(Object item) {
        return null;
    }

    @Override
    public Object peek() throws QueueUnderflowException {
        return null;
    }

    @Override
    public Object remove() throws QueueUnderflowException {
        return null;
    }

    @Override
    public void clear() {
        this.log = (T[]) new Object[4];
        this.size = 0;
        this.length = 0;
    }
}
