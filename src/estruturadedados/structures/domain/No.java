package estruturadedados.structures.domain;

public class No<T> {
    private T element;
    private No<T> next;


    //Método construtor do No
    public No(T element) {
        this.element = element;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public No<T> getNext() {
        return next;
    }

    public void setNext(No<T> next) {
        this.next = next;
    }
}
