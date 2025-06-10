package estruturadedados.structures.domain;

public class HashTableColision<T> {
    public DoubleLinkedList<T>[] vector;
    public int numberOfElements;

    public HashTableColision(int capacity) {
        this.vector = new DoubleLinkedList[capacity];
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = new DoubleLinkedList<>();
            
        }
        this.numberOfElements = 0;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void print() {
        System.out.println("Chave/Valor");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(i + "-->\t");
            vector[i].printDoubleLinkedList();
            
        }
    }

    private int hashFunction(T element) {
        return Math.abs(element.hashCode()) % this.vector.length;
    }

    public void insert(T element) {
        int address = hashFunction(element);
        this.vector[address].addAtTheEnd(element);
        this.numberOfElements++;
    }

    public boolean remove(T element) {
        int address = hashFunction(element);
        boolean removed = this.vector[address].removeElement(element);
        if (removed) {
            this.numberOfElements--;
        }
        return removed;
    }

    public boolean contains(T element) {
        int address = hashFunction(element);
        return this.vector[address].contains(element);
    }
}
