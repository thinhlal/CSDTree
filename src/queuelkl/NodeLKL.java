package queuelkl;

public class NodeLKL<E> {
    E data;
    NodeLKL<E> next;

    public NodeLKL(E data) {
        this.data = data;
        this.next = null;
    }
}
