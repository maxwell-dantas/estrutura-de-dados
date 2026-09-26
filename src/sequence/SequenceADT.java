package sequence;

public interface SequenceADT {
    // generics methods
    int getSize();
    boolean isEmpty();

    // vector methods
    Object elementAtRank(int rank);
    Object replaceAtRank(int rank, Object object);
    Object removeAtRank(int rank);
    void insertAtRank(int rank, Object object);

    // list methods
    Object first();
    Object last();
    Object before(Position node);
    Object after(Position node);
    Object replaceElement(Position node, Object object);
    Object remove(Position node);
    void swapElement(Position node1, Position node2);
    void insertBefore(Position node, Object object);
    void insertAfter(Position node, Object object);
    void insertFirst(Object object);
    void insertLast(Object object);

    // métodos ponte
    Position atRank(int rank);
    int rankOf(Position node);
}