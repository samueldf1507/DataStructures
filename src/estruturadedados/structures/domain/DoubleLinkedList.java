package estruturadedados.structures.domain;

import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {
    private NodeDouble<T> start;
    private NodeDouble<T> end;
    private int numberOfElements;

    public DoubleLinkedList() {
        this.start = null;
        this.end = null;
        this.numberOfElements = 0;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addAtTheStart(T element) {
        NodeDouble<T> nodeDouble = new NodeDouble<>(element);
        if (this.start == null) {
            this.start = nodeDouble;
            this.end = nodeDouble;
        } else {
            nodeDouble.setNext(this.start);
            this.start.setLast(nodeDouble);
            this.start = nodeDouble;
        }
        this.numberOfElements++;
    }

    public void removeAtTheStart() {
        if (this.start == null) {
            throw new NoSuchElementException("A lista está vazia");
        }
        this.start = this.start.getNext();
        if (this.start != null) {
            this.start.setLast(null);
        }
        this.numberOfElements--;
        if (numberOfElements == 0) {
            this.end = null;
        }

    }

    public void addAtTheEnd(T element) {
        NodeDouble<T> nodeDouble = new NodeDouble<>(element);
        if (this.end == null) {
            this.end = nodeDouble;
            this.start = nodeDouble;
        } else {
            this.end.setNext(nodeDouble);
            nodeDouble.setLast(this.end);
            this.end = nodeDouble;
        }
    }

    public void removeAtTheEnd() {
        if (this.end == null) {
            throw new NoSuchElementException("A lista está vazia!");
        }
        if (this.start == this.end) {
            this.start = null;
            this.end = null;
        } else {
            this.end = this.end.getLast();
            if (this.end != null) {
                this.end.setNext(null);
            }
        }
        this.numberOfElements--;
    }

    public void addAtAnyPosition(T element, int position) {
        if (position < 0 || position > this.numberOfElements) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (position == 0) {
            addAtTheStart(element);
        } else if (position == numberOfElements) {
            addAtTheEnd(element);
        } else {
            NodeDouble<T> nodeDouble = new NodeDouble<>(element);
            NodeDouble<T> currentNodo = this.start;
            for (int i = 0; i < position - 1; i++) {
                currentNodo = currentNodo.getNext();
            }
            nodeDouble.setNext(currentNodo.getNext());
            currentNodo.setLast(nodeDouble);
            currentNodo.setNext(nodeDouble);
            this.numberOfElements++;
        }
    }

    public void removeAtAnyPosition(int position) {
        if (position < 0 || position > this.numberOfElements) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        
        if (position == 0) {
            removeAtTheStart();
        } else if (position == this.numberOfElements - 1) {
            removeAtTheEnd();
        } else {
            NodeDouble<T> currentNodo = this.start;
            for (int i = 0; i < position; i++) {
                currentNodo = currentNodo.getNext();
            }
            currentNodo.getLast().setNext(currentNodo.getNext());
            currentNodo.getNext().setLast(currentNodo.getLast());

            this.numberOfElements--;
        }

    }

    public boolean removeElement(T element) {
        NodeDouble<T> cursor = this.start;
        int i;
        for (i = 0; i < this.numberOfElements; i++) {
            if (cursor.getElement() == element) {
                break;
            }
            cursor = cursor.getNext();
        }
        if (i == this.numberOfElements) {
            return false;
        }
        this.removeAtAnyPosition(i);
        return true;
    }


    public void printDoubleLinkedList() {
        if (this.start == null) {
            System.out.println("A lista está vazia!");
            return;
        }

        NodeDouble<T> currentNodo = this.start;
        System.out.println("Lista: ");
        while (currentNodo != null) {
            System.out.print(currentNodo.getElement() + " ");
            currentNodo = currentNodo.getNext();
        }
    }

    public boolean contains(T element) {
        NodeDouble<T> cursor = this.start;
        for (int i = 0; i < this.numberOfElements; i++) {
            if (cursor.getElement().equals(element)) {
                return true;
            }
            cursor = cursor.getNext();
        }
        return false;
    }
}

