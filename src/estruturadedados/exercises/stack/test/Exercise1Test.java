package estruturadedados.exercises.stack.test;

import estruturadedados.exercises.stack.domain.Exercise1;

public class Exercise1Test {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1(100);
        exercise1.push(5);
        exercise1.push(3);
        exercise1.push(10);
        exercise1.push(2);
        System.out.println("Elemento removido: " + exercise1.pop());
        exercise1.printWholeStack();

    }


}
