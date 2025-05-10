package estruturadedados.structures.domain;

public class PriorityQueue {
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    static class Nodo {
        private Product element;
        private Nodo next;

        public Nodo(Product element) {
            this.element = element;
            this.next = null;
        }

        public Product getElement() {
            return element;
        }

        public void setElement(Product element) {
            this.element = element;
        }

        public Nodo getNext() {
            return next;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }
    }

    private Nodo first;
    private Nodo last;

    public PriorityQueue() {
        this.first = null;
        this.last = null;
    }

    //Método verifica se a fila está vazia ou não
    public boolean isEmpty() {
        return this.first == null;
    }

    //Método para inserir um elemento numa fila de prioridade não ordenada
    public void add(Product element) {
        Nodo newNodo = new Nodo(element);
        if (this.first == null) {
            this.first = newNodo;
            this.last = newNodo;
        } else {
            this.last.setNext(newNodo);
            this.last = newNodo;
        }
    }

    //Método para inserir um elemento numa fila de prioridade ordenada
    public void addInOrder(Product element) {
        Nodo newNodo = new Nodo(element);
        if (this.first == null || element.getPrice() > this.first.element.getPrice()) {
            newNodo.setNext(this.first);
            this.first = newNodo;
        } else {
            Nodo currentNodo = this.first;
            while (currentNodo.getNext() != null && element.getPrice() <= this.first.element.getPrice()) {
                currentNodo = currentNodo.getNext();

            }
            newNodo.setNext(currentNodo.getNext());
            currentNodo.setNext(newNodo);

        }
    }

    //Método para remover um elemento em uma fila não ordenada
    public Product remove() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila de prioridade está vazia");
        }
        Nodo currentNodo = this.first;
        Nodo nodoMaxPriority = this.first;
        Nodo lastNodoMaxPriority = null;

        while (currentNodo != null && currentNodo.getNext() != null) {
            if ((currentNodo.next.element.getPrice() - nodoMaxPriority.element.getPrice()) > 0) {
                nodoMaxPriority = currentNodo.getNext();
                lastNodoMaxPriority  = currentNodo;
            }
            currentNodo = currentNodo.getNext();
        }
        //Verifica se o nó de maior prioridade está no ínicio da fila
        if (lastNodoMaxPriority == null) {
            this.first = this.first.getNext();
        } else {
            lastNodoMaxPriority.setNext(lastNodoMaxPriority.getNext());
        }

        if (nodoMaxPriority == this.last) {
            this.last = lastNodoMaxPriority;

        }
        return nodoMaxPriority.element;
    }

    //Método para remover um elemento em uma fila de prioridade ordenada
    public Product removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila de prioridade está vazia!");
        }
        Product removedItem = this.first.getElement();
        this.first = first.getNext();
        return removedItem;
    }

    //Método para imprimir a fila de prioridade
    public void printPriorityQueue() {
        Nodo currentNodo = this.first;
        while (currentNodo != null) {
            System.out.println(currentNodo.element.getName() + " | " + currentNodo.element.getPrice());
            currentNodo = currentNodo.getNext();
        }
    }
    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Garrafa Pacco", 250);
        Product product2 = new Product("A Canção de Achilles - Livro", 70);
        Product product3 = new Product("Teclado Black Wiwdow", 1500);
        Product product4 = new Product("Dell G15 - Notebook", 4500);
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(product1);
        priorityQueue.add(product2);
        priorityQueue.addInOrder(product3);
        priorityQueue.addInOrder(product4);
        
        priorityQueue.printPriorityQueue();
    }
}

