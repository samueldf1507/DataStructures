package estruturadedados.structures.test;

import estruturadedados.structures.domain.StaticStack;

public class StaticStackTest {
    public static void main(String[] args) {
        StaticStack staticStack = new StaticStack(10);
        staticStack.push('a');
        staticStack.push('b');
        staticStack.push('c');
        staticStack.push('d');
        staticStack.pop();
        staticStack.printStaticStack();
        System.out.println("\nTamanho da pilha: " + staticStack.StaticStackSize());

    }
}
