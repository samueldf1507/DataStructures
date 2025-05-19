package estruturadedados.structures.domain;

public class HashTable<T> {
    private T[] vector;
    private int numberOfElements;

    public HashTable(int capacity) {
        this.vector = (T[]) new Object[capacity];
        this.numberOfElements = 0;
    }

    //Método que retorna o número de elementos na tabela hash
    public int getNumberOfElements() {
        return numberOfElements;
    }

    //Método que imprime a tabela hash
    public void printHashTable() {
        System.out.println("Chave/Valor");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(i + " -->\t[" + vector[i] + "]");
        }
    }

    //Método que executa a função hash utilizando o método de divisão
    public int hashFunctionDiv(T element) {
        int hashCode = element.hashCode();
        int key = hashCode % this.vector.length;
        return key;
    }

    //Método para inserir um novo elemento na tabela hash
    public void addElement(T element) {
        int key = hashFunctionDiv(element);
        this.vector[key] = element;
        this.numberOfElements++;
    }


    //Método para remover um elemento na tabela hash
    public T removeElement(T element) {
        int key = hashFunctionDiv(element);
        T removedElement = this.vector[key];
        this.vector[key] = null;
        this.numberOfElements--;
        return removedElement;
    }

    //Método que faz a busca de um elemento na tabela hash
    public T search(T element) {
        int key = hashFunctionDiv(element);
        return this.vector[key];
    }

    //Método que verifica se um elemento está dentro da tabela hashy
    public boolean isIn(T element) {
        int key = hashFunctionDiv(element);
        return this.vector[key] != null;
    }
}
