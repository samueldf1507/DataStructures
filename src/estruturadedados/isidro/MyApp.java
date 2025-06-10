package estruturadedados.isidro;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap hashMap = new HashMap();
        int key;
        Register r1, r2, r3, r4;

        hashMap.put(new Register(1989, "Samuel"));
        hashMap.put(new Register(10456, "Leo"));
        hashMap.put(new Register(89, "Alexandre"));
        hashMap.put(new Register(666, "Pepe"));

        do {
            System.out.println("Digite um código de registro: ");
            key = input.nextInt();
            if (key != -1) {
                Register r = hashMap.get(key);
                if (r != null) {
                    System.out.println("Registro recuperado: " + r.getKey() + " - " + r.getValue());
                } else {
                    System.out.println("Registro não existente");
                }
            }
        } while (key != -1);



    }
}
