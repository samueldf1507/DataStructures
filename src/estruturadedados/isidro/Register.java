package estruturadedados.isidro;

public class Register {
    private int key;
    private String value;

    public Register() {
    }

    public Register(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int hashcode() {
        return this.key % 100;
    }
}
