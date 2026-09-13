package lista;

import lista.array.ListArray;
import lista.doubleLinkedList.Node;

public class TesteListaArray {
    public static void main(String[] args) {
        ListArray lista = new ListArray(10, 0);

        System.out.println("--- 1. ESTADO INICIAL ---");
        System.out.println("isEmpty(): " + lista.isEmpty());
        System.out.println("size(): " + lista.size());
        System.out.println();

        System.out.println("--- 2. INSERÇÕES NAS EXTREMIDADES ---");
        lista.insertFirst("B"); // Índice 0: [B]
        lista.insertFirst("A"); // Empurra B --> [A, B]
        lista.insertLast("D");  // [A, B, D]
        lista.insertLast("E");  // [A, B, D, E]

        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 3. INSERÇÕES BASEADAS EM POSIÇÃO ---");
        // "B" está no índice 1. É usado o search(1) para capturar o Nó onde B está
        Node nodeB = lista.search(1);
        lista.insertAfter(nodeB, "C"); // Esperado: [A, B, C, D, E]
        System.out.println("Inserindo 'C' após 'B' (insertAfter):");
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 4. NAVEGAÇÃO E CONSULTA ---");
        System.out.println("first(): " + lista.first());
        System.out.println("last(): " + lista.last());

        // "C" foi inserido no índice 2.
        Node nodeC = lista.search(2);
        System.out.println("before('C'): " + lista.before(nodeC));
        System.out.println("after('C'): " + lista.after(nodeC));
        System.out.println();

        System.out.println("--- 5. ATUALIZAÇÕES ---");
        // "A" está no índice 0
        Node nodeA = lista.search(0);
        System.out.println("Substituindo 'A' por 'Alpha' (replaceElement): " + lista.replaceElement(nodeA, "Alpha"));
        lista.exibir();
        System.out.println();

        // "E" está no índice 4
        Node nodeE = lista.search(4);
        System.out.println("Trocando 'Alpha' e 'E' de lugar (swapElement):");
        lista.swapElement(nodeA, nodeE); // Esperado: [E, B, C, D, Alpha]
        lista.exibir();
        System.out.println("\n");

        System.out.println("--- 6. REMOÇÃO ---");
        // "D" está no índice 3 (E, B, C, >D<, Alpha)
        Node nodeD = lista.search(3);
        System.out.println("Removendo 'D' (remove): " + lista.remove(nodeD));
        lista.exibir(); // Esperado: [E, B, C, Alpha]
        System.out.println("\n");

        System.out.println("--- 7. ESTADO FINAL ---");
        System.out.println("size(): " + lista.size());
        System.out.println("isEmpty(): " + lista.isEmpty());
    }
}