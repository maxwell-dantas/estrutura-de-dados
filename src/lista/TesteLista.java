package lista;

import lista.doubleLinkedList.ListDoubleLL;
import lista.doubleLinkedList.Node;

public class TesteLista {
    public static void main(String[] args) {
        ListDoubleLL lista = new ListDoubleLL();

        System.out.println("--- 1. ESTADO INICIAL ---");
        System.out.println("isEmpty(): " + lista.isEmpty());
        System.out.println("size(): " + lista.size());
        System.out.println();

        System.out.println("--- 2. INSERÇÕES NAS EXTREMIDADES ---");
        lista.insertFirst("B"); // [B]
        lista.insertFirst("A"); // [A, B]
        lista.insertLast("D");  // [A, B, D]
        lista.insertLast("E");  // [A, B, D, E]
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 3. INSERÇÕES BASEADAS EM POSIÇÃO ---");
        Node nodeB = lista.search("B");
        lista.insertAfter(nodeB, "C");
        System.out.println("Inserindo 'C' após 'B' (insertAfter):");
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 4. NAVEGAÇÃO E CONSULTA ---");
        System.out.println("first(): " + lista.first());
        System.out.println("last(): " + lista.last());
        Node nodeC = lista.search("C");
        System.out.println("before('C'): " + lista.before(nodeC));
        System.out.println("after('C'): " + lista.after(nodeC));
        System.out.println();

        System.out.println("--- 5. ATUALIZAÇÕES ---");
        Node nodeA = lista.search("A");
        System.out.println("Substituindo 'A' por 'Alpha' (replaceElement): " + lista.replaceElement(nodeA, "Alpha"));
        lista.exibir();
        System.out.println();

        Node nodeE = lista.search("E");
        System.out.println("Trocando 'Alpha' e 'E' de lugar (swapElement):");
        lista.swapElement(nodeA, nodeE);
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 6. REMOÇÃO ---");
        Node nodeD = lista.search("D");
        System.out.println("Removendo 'D' (remove): " + lista.remove(nodeD));
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 7. ESTADO FINAL ---");
        System.out.println("size(): " + lista.size());
        System.out.println("isEmpty(): " + lista.isEmpty());
    }
}