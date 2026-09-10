package vector;

public interface VectorADT {
    public Object elementAtRank(Integer r);
    public Object replaceAtRank(Integer r, Object item);
    public void insertAtRank(Integer r, Object item);
    public Object removeAtRank(Integer r);
    public int size();
    public boolean isEmpty();
}
