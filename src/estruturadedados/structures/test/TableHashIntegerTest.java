package estruturadedados.structures.test;

import estruturadedados.structures.domain.TableHashInteger;

public class TableHashIntegerTest {
    public static void main(String[] args) {
        TableHashInteger tableHashInteger = new TableHashInteger(37);
        tableHashInteger.addElement(7);
        tableHashInteger.addElement(4);
        tableHashInteger.addElement(9);

        tableHashInteger.printHashTable();

        System.out.println(tableHashInteger.getNumberOfElements());
    }
}
