package queuelkl;

public class Queue<E> {

    private NodeLKL<E> front;
    private NodeLKL<E> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(E item) {
        NodeLKL<E> newNodeLKL = new NodeLKL<>(item);
        if (isEmpty()) {
            front = newNodeLKL;
            rear = newNodeLKL;
        } else {
            rear.next = newNodeLKL;
            rear = newNodeLKL;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        E item = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return item;
    }

    public E first() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }

    public void printQueue() {
        NodeLKL<E> current = front;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}
