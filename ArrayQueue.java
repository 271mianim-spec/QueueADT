import java.util.Queue;

public class ArrayQueue<T> implements QueueInterface<T>{

    private T[] log;
    private int size;

    private int headPos;
    private int tailPos;

    public ArrayQueue() {
        this.log = (T[]) new Object[4];
        this.size = 0;

        this.headPos = 0;
        this.tailPos = 0;
    }

    public void manageSize() {
        int newArraySize = log.length;

        if (newArraySize == size) {
            newArraySize *= 2;
        } else if (newArraySize/2 >= size) {
            newArraySize = Math.max(4, newArraySize/2);
        }

        if (newArraySize != this.log.length) {

            T[] temp = (T[])new Object[newArraySize];

            int copyingSize = Math.min(this.log.length, size);

            int currentPos = headPos;
            for (int i = 0; i < copyingSize; i++) {
                temp[i] = this.log[currentPos];
                currentPos++;
                if (currentPos == log.length) {
                    currentPos = 0;
                }
            }
            this.log = temp;
            headPos = 0;
            tailPos = size;
            if (tailPos == log.length) {
                tailPos = 0;
            }
        }
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
    public T add(T item) {

        if (this.log.length == size) {
            manageSize();
        }
        size++;

        log[tailPos] = (T) item;
        tailPos++;
        if (tailPos == log.length) {
            tailPos = 0;
        }
        return item;

    }

    @Override
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }

        return this.log[headPos];


//        return this.log[this.log.length-1];
    }

    @Override
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }

        T item = log[headPos];
        this.log[this.headPos] = null;
        this.headPos++;
        if (headPos == log.length) {
            this.headPos = 0;
        }

        size--;
        if (this.log.length / 2 >= this.size) {
            manageSize();
        }

        return item;
    }

    @Override
    public void clear() {
        this.log = (T[]) new Object[4];
        this.size = 0;


        this.headPos = 0;
        this.tailPos = 0;

    }
}
