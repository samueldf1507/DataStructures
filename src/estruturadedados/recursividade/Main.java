package estruturadedados.recursividade;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[10];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * vector.length);
        }

        System.out.println("Vetor");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");

        }

        System.out.println("\nSoma: " + sum(0, 0, vector));
    }

    public static int sum(int soma, int position, int[] vector) {
        if (position < vector.length) {
            soma += vector[position];
            return sum(soma ,position + 1,vector);
        } else {
            return soma;
        }

    }
}
