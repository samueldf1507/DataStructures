package estruturadedados.structures.domain;

public class NodeDouble<T> {
    private T element;
    private NodeDouble<T> next;
    private NodeDouble<T> last;

    public NodeDouble(T element) {
        this.element = element;
        this.next = null;
        this.last = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    public NodeDouble<T> getLast() {
        return last;
    }

    public void setLast(NodeDouble<T> last) {
        this.last = last;
    }
}
