public class LinkedQueue<T> implements QueueInterface<T> {

    public LLNode<T> head;
    public LLNode<T> tail;
    public int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
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
        LLNode<T> newNode = new LLNode<T>(item);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setLink(newNode);
            tail = newNode;
        }
        size++;
        return item;
    }

    @Override
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty!");
        }
        return head.getInfo();
    }

    @Override
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty!");
        }
        size--;

        T item =  head.getInfo();

        if (empty()) {
            head = null;
            tail = null;
            return item;
        }

        head = head.getLink();

        return item;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
