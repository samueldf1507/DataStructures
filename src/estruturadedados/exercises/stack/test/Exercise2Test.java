package estruturadedados.exercises.stack.test;

import estruturadedados.exercises.stack.domain.Exercise2;

import java.util.Scanner;

public class Exercise2Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Exercise2 exercise2 = new Exercise2(100);

        System.out.println("Digite uma expressão: ");
        String expression = input.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (character == '(') {
                exercise2.push(character);
            } else if (character == ')') {
                if (!exercise2.isEmpty()) {
                    exercise2.pop();
                } else {
                    exercise2.push(character);
                    break;
                }

            }

        }

        if (exercise2.isEmpty()) {
            System.out.println("Expressão está correta");
        } else {
            System.out.println("Expressão está incorreta");
        }



    }
}
