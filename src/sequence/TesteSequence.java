package sequence;

import sequence.array.ArraySequence;
import sequence.doubleLinkedList.Sequence;

public class TesteSequence {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        //ArraySequence sequence = new ArraySequence(8, 0);

        System.out.println("--- 1. ESTADO INICIAL ---");
        System.out.println("isEmpty(): " + sequence.isEmpty());
        System.out.println("getSize(): " + sequence.getSize());
        System.out.println();

        System.out.println("--- 2. INSERÇÕES NAS EXTREMIDADES (List DTA) ---");
        sequence.insertFirst("B"); // Header <-> B <-> Trailer
        sequence.insertFirst("A"); // Header <-> A <-> B <-> Trailer
        sequence.insertLast("D");  // Header <-> A <-> B <-> D <-> Trailer
        sequence.insertLast("E");  // Header <-> A <-> B <-> D <-> E <-> Trailer
        sequence.exibir();
        System.out.println();

        System.out.println("--- 3. INSERÇÕES BASEADAS EM POSIÇÃO E RANK ---");
        // Buscando a posição do elemento "B" (que está no rank 1, pois "A" é o 0)
        Position posB = sequence.atRank(1);
        sequence.insertAfter(posB, "C");
        System.out.println("Inserindo 'C' após 'B' (insertAfter):");
        sequence.exibir(); // Header <-> A <-> B <-> C <-> D <-> E <-> Trailer

        System.out.println("\nInserindo 'Start' no rank 0 (insertAtRank):");
        sequence.insertAtRank(0, "Start");
        sequence.exibir(); // Header <-> Start <-> A <-> B <-> C <-> D <-> E <-> Trailer
        System.out.println();

        System.out.println("--- 4. NAVEGAÇÃO E CONSULTA ---");
        System.out.println("first(): " + sequence.first());
        System.out.println("last(): " + sequence.last());

        // Sequência real: [Start, A, B, C, D, E]
        // "C" agora foi empurrado para o rank 3 devido ao "Start" no rank 0
        Position posC = sequence.atRank(3);
        System.out.println("Elemento no rank 3 (elementAtRank): " + sequence.elementAtRank(3));
        System.out.println("before('C'): " + sequence.before(posC));
        System.out.println("after('C'): " + sequence.after(posC));
        System.out.println("rankOf('C'): " + sequence.rankOf(posC));
        System.out.println();

        System.out.println("--- 5. ATUALIZAÇÕES ---");
        // "A" está no rank 1
        Position posA = sequence.atRank(1);
        System.out.println("Substituindo 'A' por 'Alpha' (replaceElement): " + sequence.replaceElement(posA, "Alpha"));
        sequence.exibir();

        // "E" está no rank 5
        Position posE = sequence.atRank(5);
        System.out.println("\nTrocando 'Alpha' e 'E' de lugar (swapElement):");
        sequence.swapElement(posA, posE);
        sequence.exibir();
        System.out.println();

        System.out.println("--- 6. REMOÇÕES ---");
        // "D" está no rank 4
        Position posD = sequence.atRank(4);
        System.out.println("Removendo 'D' via Posição (remove): " + sequence.remove(posD));
        sequence.exibir();

        System.out.println("\nRemovendo rank 0 ('Start') via Rank (removeAtRank): " + sequence.removeAtRank(0));
        sequence.exibir();
        System.out.println();

        System.out.println("--- 7. ESTADO FINAL ---");
        System.out.println("getSize(): " + sequence.getSize());
        System.out.println("isEmpty(): " + sequence.isEmpty());
    }
}