package estruturadedados.exercises.queues.domain;

import estruturadedados.exercises.queues.test.Exercise1Test;

public class Exercise1 {
    private Exercise1Test.Doc[] itens;
    private int numberOfElements;
    private int capacity;
    private int start;
    private int end;

    public Exercise1(int capacity) {
        this.itens = new Exercise1Test.Doc[capacity];
        this.capacity = capacity;
        this.start = 0;
        this.end = 0;
        this.numberOfElements = 0;
    }

    //Método verifica se a fila está vazia
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    //Método verifica se a fila está cheia
    public boolean isFull() {
        return numberOfElements == capacity;
    }

    //Método adiciona um número no final da fila
    public void enqueue(Exercise1Test.Doc item) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia!");
        }

        itens[end] = item;
        this.end = (this.end + 1) % capacity;
        this.numberOfElements++;
    }

    //Método que remove um elemento no ínicio da fila
    public Exercise1Test.Doc dequeue() throws Exception {
        if (isEmpty()) {
            throw  new Exception("A fila está vazia!");
        }

        Exercise1Test.Doc item = itens[start];
        this.start = (this.start + 1) % capacity;
        this.numberOfElements--;
        return item;
    }

    //Método que mostra o primeiro elemento da fila
    public Exercise1Test.Doc peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia!");
        }
        return itens[start];
    }

    //Método que mostra a fila
    public void printStaticQueue() throws Exception{
        if (isEmpty()) {
            throw new Exception("A fila está vazia!");
        }
        for (int i = 0; i < numberOfElements; i++) {
            int index = (this.start + i) % capacity;
            Exercise1Test.Doc item = itens[index];
            System.out.println(item + " ");

        }
    }


    //Método que retorna o tamanho da fila
    public int getNumberOfElements() {
        return numberOfElements;
    }
}
