package estruturadedados.isidro;

public class HashMap {
    private Register[] values;

    public HashMap() {
        values = new Register[100];
    }

    public void put(Register register) {
        int position = register.hashcode();
        if (values[position] == null) {
            values[position] = register;
        }

    }

    public Register get(int key) {
        Register r = new Register();
        r.setKey(key);
        int position = r.hashcode();
        return values[position];
    }
}
