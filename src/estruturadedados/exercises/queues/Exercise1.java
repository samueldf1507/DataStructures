package estruturadedados.exercises.queues;

public class Exercise1 {
//Utilizando uma estrutura de dados do tipo Fila, crie uma fila de documentos que precisam ser impressos.
//Cada documento é composto de um nome e quantidade de folhas a serem impressas. O programa deve:
//● Enfileirar os documentos;
//● E seguindo a ordem, o programa deve “imprimir” cada documento, desenfileirando da fila. Se desejar pode usar
//Threads para esperar a impressão de acordo com o número de folhas a serem impressas.

    static class Doc{
        private String name;
        private int numberOfPapers;

        public Doc(int numberOfPapers, String name) {
            this.numberOfPapers = numberOfPapers;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfPapers() {
            return numberOfPapers;
        }
    }

    static class StaticQueue{
        private Doc[] items;
        private int capacity;
        private int numberOfElements;
        private int start;
        private int end;

        //Método construtor da fila estática
        public StaticQueue(int cap) {
            this.items = new Doc[cap];
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
        public Doc peek() {
            return this.items[start];
        }

        //Método que adiciona um número da fila
        public void enqueue(Doc item) throws Exception {
            if (isFull()) {
                throw new Exception("A fila está cheia!");
            }
            this.items[end] = item;
            this.end = (end + 1) % capacity;
            this.numberOfElements++;

        }

        //Método que remove um número da fila
        public Doc dequeue() throws Exception {
            if (isEmpty()) {
                throw new Exception("A fila está vazia!");
            }
            Doc removedItem = items[start];
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
                Doc document = items[index];
                System.out.print(document.getName() + " | " + document.getNumberOfPapers());
            }
            System.out.print(" ] ");
        }

        //Método que retorna o tamanho da fila
        public int getNumberOfElements() {
            return numberOfElements;
        }
    }

    public static void main(String[] args) throws Exception {
        StaticQueue staticQueue = new StaticQueue(100);
        staticQueue.enqueue(new Doc(50, "Documento 1"));
        staticQueue.enqueue(new Doc(27, "Documento 2"));
        staticQueue.enqueue(new Doc(81, "Documento 3"));

        while (!staticQueue.isEmpty()) {
            Doc document = staticQueue.dequeue();
            System.out.println(document.getName() + " | " + document.getNumberOfPapers());
        }

    }

}
