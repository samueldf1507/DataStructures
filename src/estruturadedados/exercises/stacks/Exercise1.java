package estruturadedados.exercises.stacks;

import java.util.Scanner;

//Escreva um programa em Java que verifica se uma expressão matemática
//contém parênteses, colchetes e chaves balanceados corretamente. Ou seja, o
//programa deve verificar se cada símbolo de abertura tem seu correspondente de
//fechamento na ordem correta. Obs: Implemente uma solução utilizando o TAD
//Pilha que você criou anteriormente.
//Exemplo:
//Expressão correta: ((a + b) * (c - d))
//Expressão incorreta: ((a + b) * (c - d)
public class Exercise1 {
    static class StaticStack {
        private int top;
        private char[] items;
        private int capacity;


        //Método construtor da pilha estática
        public StaticStack(int capacity) {
            this.top = -1;
            this.items = new char[capacity];
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
        public void push(char element) throws Exception {
            if (isFull()) {
                throw new Exception("A pilha está cheia!");
            }

            this.top++;
            this.items[top] = element;
        }

        //Método que desempilha um número na pilha
        public char pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("A pilha está vazia!");
            }

            char removedItem = items[top];
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

        //Método que verifica se a expressão está correta
        public static boolean verifyExpression(String expression) throws Exception {
            StaticStack staticStack = new StaticStack(expression.length());
            for (int i = 0; i < expression.length(); i++) {
                char character = expression.charAt(i);
                if (character == '(' || character == '{' || character == '[') {
                    staticStack.push(character);
                } else if (character == ')' || character == '}' || character == ']') {
                    if (staticStack.isEmpty()) {
                        return false;
                    }
                    char top = staticStack.pop();
                    if ((character == ')' && top != '(') || (character == '}' && top != '{') ||
                            (character == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return staticStack.isEmpty();
        }

        public static void main(String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            String expression = input.nextLine();
            System.out.println(verifyExpression(expression));
        }
    }
}


