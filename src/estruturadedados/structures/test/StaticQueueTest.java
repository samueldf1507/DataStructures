package estruturadedados.structures.test;

import estruturadedados.structures.domain.StaticQueue;

public class StaticQueueTest {
    public static void main(String[] args) throws Exception {
        StaticQueue staticQueue = new StaticQueue(10);
        staticQueue.enqueue(1);
        staticQueue.enqueue(2);
        staticQueue.enqueue(3);
        staticQueue.enqueue(4);
        staticQueue.dequeue();


        staticQueue.printStaticQueue();
        System.out.println("Tamanho da fila: " + staticQueue.getNumberOfElements());
        System.out.println("Primeiro número da fila: " + staticQueue.peek());

    }
}
