package estruturadedados.exercises.queues.domain;

public class Exercise1 {
    private int[] itens;
    private int numberOfElements;
    private int capacity;
    private int start;
    private int end;

    public Exercise1(int capacity) {
        this.itens = new int[capacity];
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
    public void enqueue(int item) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia!");
        }

        itens[end] = item;
        this.end = (this.end + 1) % capacity;
        this.numberOfElements++;
    }

    //Método que remove um elemento no ínicio da fila
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw  new Exception("A fila está vazia!");
        }

        int item = itens[start];
        this.start = (this.start + 1) % capacity;
        this.numberOfElements--;
        return item;
    }

    //Método que mostra o primeiro elemento da fila
    public int peek() throws Exception {
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
            int item = itens[index];
            System.out.println(item + " ");

        }
    }


    //Método que retorna o tamanho da fila
    public int getNumberOfElements() {
        return numberOfElements;
    }
}
