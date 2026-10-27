import java.util.Queue;

public class ArrayQueue<T> implements QueueInterface{

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
        int newArraySize = 4;

        while(newArraySize < size) {
            newArraySize*=2;
        }

        if (newArraySize != this.log.length) {

            T[] temp = (T[])new Object[newArraySize];

            int copyingSize = Math.min(this.log.length, size);

            for (int i = 0; i < copyingSize; i++) {
                temp[i] = this.log[i];
            }
            this.log = temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        System.out.println(size);
        return size == 0;
    }

    @Override
    public Object add(Object item) {
        size++;
        if (this.log.length == size || this.log.length / 2 <= this.size) {
            manageSize();
        }


        if (tailPos != this.log.length-1) {
            this.log[tailPos] = (T) item;
            tailPos++;
            return tailPos;
        } else {
            this.log[headPos] = (T) item;
            headPos++;
            if (this.log[headPos] != null) {
                headPos = 0;
            }
            return headPos;
        }
    }

    @Override
    public Object peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }

        return this.log[headPos];


//        return this.log[this.log.length-1];
    }

    @Override
    public Object remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }



        Object item = this.peek();
        this.log[this.headPos] = null;
        this.headPos--;

        size--;
        if (this.log.length == size || this.log.length / 2 <= this.size) {
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
