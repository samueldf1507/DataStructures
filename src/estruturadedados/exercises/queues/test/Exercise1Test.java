package estruturadedados.exercises.queues.test;

import estruturadedados.exercises.queues.domain.Exercise1;

public class Exercise1Test {
    public static class Doc{
        private String name;
        private int numberOfPapers;
        private Doc(String name, int numberOfPapers) {
            this.name = name;
            this.numberOfPapers = numberOfPapers;
        }


        public String getName() {
            return name;
        }

        public int getNumberOfPapers() {
            return numberOfPapers;
        }
    }

    public static void main(String[] args) throws Exception {
        Exercise1 exercise1 = new Exercise1(10);
        exercise1.enqueue(new Doc("Documento 1", 50));
        exercise1.enqueue(new Doc("Documento 2", 27));
        exercise1.enqueue(new Doc("Documento 1", 81));

        while (!exercise1.isEmpty()) {
            Doc document = exercise1.dequeue();
            System.out.println(document.getName() + " | " + document.getNumberOfPapers());

        }

    }
}
