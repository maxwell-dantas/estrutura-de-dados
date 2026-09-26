package sequence.doubleLinkedList;

import sequence.exceptions.IsNotNodeException;
import sequence.Position;
import sequence.exceptions.NodeNotFound;
import sequence.exceptions.RankOutOfBoundsException;

public class Sequence {
    private Node header;
    private Node trailer;
    private int size;

    public Sequence() {
        header = new Node();
        trailer = new Node();

        header.setNext(trailer);
        trailer.setPrev(header);

        size = 0;
    }

    private void validateRank(int rank) {
        if (rank < 0 || rank >= size) {
            String bounds = (rank < 0) ? "abaixo" : "acima";
            throw new RankOutOfBoundsException("O rank inserido está " + bounds + "do escopo.");
        }
    }

    private Node validateNode(Position position) {
        if (!(position instanceof Node)) {
            throw new IsNotNodeException("O parâmetro passado não é um nó.");
        }

        return (Node) position;
    }

    public Position atRank(int rank) {
        validateRank(rank);

        Node node = header.getNext();
        for (int i = 0; i < rank; i++) {
            node = node.getNext();
        }

        return node;
    }

    public int rankOf(Position position) {
        Node node = validateNode(position);

        Node currentNode = header.getNext();

        for (int i = 0; i < size; i++) {
            if (currentNode == node) {
                return i;
            }
            currentNode = currentNode.getNext();
        }

        throw new NodeNotFound("O nó não foi encontrado!");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object elementAtRank(int rank) {
        return atRank(rank).getElement();
    }

    public Object replaceAtRank(int rank, Object object) {
        Node node = (Node) atRank(rank);
        Object toReplace = node.getElement();
        node.setElement(object);
        return toReplace;
    }
}