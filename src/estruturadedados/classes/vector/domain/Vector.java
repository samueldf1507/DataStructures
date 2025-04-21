package estruturadedados.classes.vector.domain;

import java.util.Arrays;

public class Vector {
    private String[] elements;
    private int size;


    public Vector(int cap) {
        this.elements = new String[cap];
        this.size = 0;
    }


    public void addAtTheEnd(String element) {
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
        } else {
            throw new IndexOutOfBoundsException("A lista está cheia, não é possível adicionar mais elementos");
        }

    }
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.size; i++) {
            s.append(this.elements[i]);
            s.append(", ");
        }

        if (this.size < 0) {
            s.append(this.elements[this.size - 1]);
        }

        s.append("]");

        return s.toString();
    }

    public String search(int position) {
        if (position >= 0 && position < this.size) {
            return this.elements[position];
        } else {
            throw new IllegalArgumentException("Posição inválida");
        }
    }

    public int verifyIfElementExist(String element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }

        }
        return -1;
    }

    public void addAtAnyPosition(String element, int position) {
        if (!(position >= 0 && position < this.size)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = this.size - 1; i >= position; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[position] = element;
        this.size++;
    }

    private void increaseCapacity() {
        if (this.size == this.elements.length) {
            String[] newElements = new String[this.elements.length * 2];
            for (int i = 0; i < this.size; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }
}
