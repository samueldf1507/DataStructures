package estruturadedados.exercises.queues.test;

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

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
