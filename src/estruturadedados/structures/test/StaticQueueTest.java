package estruturadedados.structures.test;

import estruturadedados.structures.domain.StaticQueue;

public class StaticQueueTest {
    public static void main(String[] args) throws Exception {
        StaticQueue staticQueue = new StaticQueue(100);
        staticQueue.enqueue(5);
        staticQueue.enqueue(10);
        staticQueue.enqueue(15);
        staticQueue.dequeue();

        staticQueue.printStaticQueue();
        System.out.println("Tamanho da fila: " + staticQueue.getNumberOfElements());
        System.out.println("Primeiro elemento da fila: " + staticQueue.peek());
    }
}
