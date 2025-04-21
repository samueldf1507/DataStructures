package estruturadedados.exercises.stack.test;

import estruturadedados.exercises.stack.domain.Exercise3;

import java.util.Scanner;

public class ExerciseTest3 {
    public static void main(String[] args) {
        Exercise3 exercise3 = new Exercise3(100);
        Scanner input = new Scanner(System.in);

        System.out.println("Digite 10 números para serem adicionados na pilha");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d número: ", i + 1);
            int number = input.nextInt();
            if (number % 2 == 0) {
                exercise3.push(number);
            } else {
                if (!exercise3.isEmpty()) {
                    exercise3.pop();
                } else {
                    System.out.println("A pilha está vazia!");
                }
            }
        }

        while (!exercise3.isEmpty()) {
            System.out.println(exercise3.pop());
        }

        exercise3.printStack();
    }
}
