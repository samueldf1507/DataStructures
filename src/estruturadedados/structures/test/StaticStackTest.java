package estruturadedados.structures.test;

import estruturadedados.structures.domain.StaticStack;

public class StaticStackTest {
    public static void main(String[] args) throws Exception  {
        StaticStack staticStack = new StaticStack(100);
        staticStack.push(1);
        staticStack.push(2);
        staticStack.push(3);
        staticStack.push(4);
        staticStack.push(5);
        staticStack.pop();
        staticStack.printStaticStack();

        System.out.println("\nTamanho da pilha: " + staticStack.size());
        System.out.println("Topo da pilha: " + staticStack.top());
    }
}
