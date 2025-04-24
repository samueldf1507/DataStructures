package estruturadedados.structures.domain;

public class LinkedList<T> {
    private No<T> start;
    private No<T> end;
    private int numberOfElements;

    //Método construtor da lista encadeada
    public LinkedList() {
        this.start = null;
        this.end = null;
        this.numberOfElements = 0;
    }

    //Método para adicionar um elemento no ínicio da lista
    public void addAtTheStart(T element) {
        No<T> newNo = new No<>(element);
        if (this.start == null) {
            this.start = newNo;
            this.end = newNo;
        } else {
            newNo.setNext(this.start);
            this.start = newNo;
        }
        this.numberOfElements++;
    }

    //Método para adicionar um elemento no final da lista
    public void addAtTheEnd(T element) {
        No<T> newNo = new No<>(element);
        if (this.end == null) {
            this.start = newNo;
            this.end = newNo;
        } else {
            this.end.setNext(newNo);
            this.end = newNo;
        }
        this.numberOfElements++;
    }

    //Método para remover um elemento no ínicio da lista
    public void removeAtTheStart() throws Exception {
        if (this.start == null) {
            throw new Exception("A lista está vazia!");
        } else {
            this.start = this.start.getNext();
            this.numberOfElements--;
            if (numberOfElements == 0) {
                this.end = null;
            }
        }
    }

    //Método para remover um elemento no final da lista
    public void removeAtTheEnd() throws Exception {
        if (this.end == null) {
            throw new Exception("A lista está vazia!");
        } else {
            if (this.start == this.end) {
                this.start = null;
                this.end = null;
            } else {
                No<T> currentlyNo = this.start;
                while (currentlyNo.getNext() != this.end) {
                    currentlyNo = currentlyNo.getNext();
                }
                this.end = currentlyNo;
                currentlyNo.setNext(null);
            }
            this.numberOfElements--;
        }
    }

    //Método para adicionar um elemento em qualquer posição
    public void addAtAnyPosition(T element, int position)  {
        if (position < 0 || position > this.numberOfElements) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (position == 0) {
            addAtTheStart(element);
        } else if (position == numberOfElements) {
            addAtTheEnd(element);
        } else {
            No<T> newNo = new No<>(element);
            No<T> currentlyNo = this.start;
            for (int i = 0; i < position - 1; i++) {
                currentlyNo = currentlyNo.getNext();
            }
            newNo.setNext(currentlyNo.getNext());
            currentlyNo.setNext(newNo);
            this.numberOfElements++;
        }
    }

    //Método para remover um elemento em qualquer posição
    public void removeAtAnyPosition(int position) throws Exception {
        if (position < 0 || position > this.numberOfElements) {
            throw new IndexOutOfBoundsException("A lista está vazia!");
        }

        if (position == 0) {
            removeAtTheStart();
        } else if (position == this.numberOfElements - 1) {
            removeAtTheEnd();
        } else {
            No<T> currentlyNo = this.start;
            for (int i = 0; i < position - 1; i++) {
                currentlyNo = currentlyNo.getNext();
            }
            currentlyNo.setNext(currentlyNo.getNext().getNext());
            this.numberOfElements--;
        }
    }


    //Método para imprimir a lista encadeada
    public void printLinkedList() {
        No<T> currentNo = this.start;
        System.out.println("Lista: ");
        while (currentNo != null) {
            System.out.print(currentNo.getElement() + " ");
            currentNo = currentNo.getNext();
        }
    }

    public No<T> getStart() {
        return start;
    }

    public void setStart(No<T> start) {
        this.start = start;
    }

    public No<T> getEnd() {
        return end;
    }

    public void setEnd(No<T> end) {
        this.end = end;
    }

    //Método que retorna o tamanho da lista encadeada
    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
