package sequence.exceptions;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(String err) {
        super(err);
    }
}