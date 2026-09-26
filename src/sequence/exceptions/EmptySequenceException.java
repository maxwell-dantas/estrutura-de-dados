package sequence.exceptions;

public class EmptySequenceException extends RuntimeException{
    public EmptySequenceException(String err) {
        super(err);
    }
}