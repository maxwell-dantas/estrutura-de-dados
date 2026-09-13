package vector;

import vector.array.VectorArray;
import vector.doubleLinkedList.VectorDoubleLL;

public class TesteVector {
    public static void main(String[] args) {
        VectorArray v = new VectorArray(8, 0);
        // VectorDoubleLL v = new VectorDoubleLL();

        System.out.println("ESTADO INICIAL");
        System.out.println("isEmpty(): " + v.isEmpty());
        System.out.println("size(): " + v.size());
        System.out.println();

        System.out.println("ADIÇÃO DE ITENS");
        v.insertAtRank(0, "A");
        v.insertAtRank(1, "B");
        v.insertAtRank(2, "C");
        v.exibir();
        System.out.println();

        System.out.println("\nBUSCA E REPLACE");
        System.out.println("Item no índice 1: " + v.elementAtRank(1));
        System.out.println("Substituindo: " + v.replaceAtRank(1, "X") + " por X");
        v.exibir();
        System.out.println();

        System.out.println("\nREMOÇÃO");
        System.out.println("Item removido (índice 2): " + v.removeAtRank(2));
        v.exibir();
        System.out.println();
        System.out.println("Item removido (índice 0): " + v.removeAtRank(0));
        v.exibir();
        System.out.println();

        System.out.println("\nESTADO FINAL");
        System.out.println("size(): " + v.size());
        System.out.println("isEmpty(): " + v.isEmpty());
    }
}