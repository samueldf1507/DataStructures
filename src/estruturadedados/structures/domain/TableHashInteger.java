package estruturadedados.structures.domain;

public class TableHashInteger {
    private Integer vector[];
    private int numberOfElements;

    public TableHashInteger(int capacity) {
        this.vector = new Integer[capacity];
        this.numberOfElements = 0;
    }

    //Método que retorna o número de elementos na tabela hash
    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void printHashTable() {
        System.out.println("Chave/Valor");
        for (int i = 0; i < vector.length; i++) {
            System.out.println(i + " -->\t["+ vector[i] + "]");
        }
    }

    //Método que executa a função hash através do método da divisão
    public int hashFunctionDiv(Integer element) {
        return element % this.vector.length;

    }

    //Método que realiza a busca de um elemento na tabela hash
    public Integer search(int element) {
        int key = hashFunctionDiv(element);
        return this.vector[key];
    }

    //Método para adicionar um elemento inteiro na tabela hash
    public void addElement(int element) {
        int key = hashFunctionDiv(element);
        this.vector[key] = element;
        this.numberOfElements++;
    }

    //Método para remover um elemento inteiro na tabela hash
    public void removeElement(int element) {
        int key = hashFunctionDiv(element);
        this.vector[key] = null;
        this.numberOfElements--;

    }



    
}
