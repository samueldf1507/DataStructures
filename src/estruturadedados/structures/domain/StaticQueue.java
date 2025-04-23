package estruturadedados.structures.domain;

public class StaticQueue {
    private int[] items;
    private int capacity;
    private int numberOfElements;
    private int start;
    private int end;

    //Método construtor da fila estática
    public StaticQueue(int cap) {
        this.items = new int[cap];
        this.capacity = cap;
        this.numberOfElements = 0;
        this.start = 0;
        this.end = 0;
    }

    //Método que verifica se a fila está vazia
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    //Método que verifica se a fila está cheia
    public boolean isFull() {
        return numberOfElements == capacity;
    }

    //Método que verifica o primeiro número da fila
    public int peek() {
        return this.items[start];
    }

    //Método que adiciona um número da fila
    public void enqueue(int item) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia!");
        }
        this.items[end] = item;
        this.end = (end + 1) % capacity;
        this.numberOfElements++;

    }

    //Método que remove um número da fila
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia!");
        }
        int removedItem = items[start];
        this.start = (this.start + 1) % capacity;
        this.numberOfElements--;
        return removedItem;
    }

    //Método que imprime a lista estática
    public void printStaticQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia!");
        }
        System.out.print(" [ ");
        for (int i = 0; i < numberOfElements; i++) {
            int index = (this.start + i) % capacity;
            int number = items[index];
            System.out.print(number + ",");
        }
        System.out.print(" ] ");
    }

    //Método que retorna o tamanho da fila
    public int getNumberOfElements() {
        return numberOfElements;
    }



}
