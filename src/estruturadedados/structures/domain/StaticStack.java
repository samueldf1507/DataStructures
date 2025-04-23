package estruturadedados.structures.domain;

public class StaticStack  {
    private int top;
    private int[] items;
    private int capacity;


    //Método construtor da pilha estática
    public StaticStack(int capacity) {
        this.top = -1;
        this.items = new int[capacity];
        this.capacity = capacity;
    }

    //Método que verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == -1;
    }

    //Método que verifica se a pilha está cheia
    public boolean isFull() {
        return top == capacity - 1;
    }

    //Método que retorna o tamanho da pilha
    public int size() {
        return top + 1;
    }

    //Método que empilha um número na pilha
    public void push(int element) throws Exception {
        if (isFull()) {
            throw new Exception("A pilha está cheia!");
        }

        this.top++;
        this.items[top] = element;
    }

    //Método que desempilha um número na pilha
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia!");
        }

        int removedItem = items[top];
        this.top--;
        return removedItem;
    }

    //Método que mostra a pilha
    public void printStaticStack() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia!");
        }

        System.out.print(" [ ");
        for (int i = 0; i < top + 1; i++) {
            System.out.print(items[i] + ",  ");

        }
        System.out.print(" ] ");
    }

    //Método que retorna o número que está no topo da pilhja
    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia!");
        }
        return items[top];
    }




}
