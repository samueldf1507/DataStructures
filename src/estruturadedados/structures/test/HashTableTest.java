package estruturadedados.structures.test;

import estruturadedados.structures.domain.HashTable;

public class HashTableTest {
    static class Student {
        private String name;
        private int matricula;

        public Student(String name, int matricula) {
            this.name = name;
            this.matricula = matricula;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", matricula=" + matricula +
                    '}';
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + matricula;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Student other = (Student) obj;
            if (matricula != other.matricula)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        HashTable<Student> hashTable = new HashTable<>(5);
        hashTable.addElement(new Student("Samuel", 19));
        hashTable.addElement(new Student("Vinicius", 21));
        hashTable.addElement(new Student("Alexandre", 20));

        hashTable.printHashTable();

    }
}
