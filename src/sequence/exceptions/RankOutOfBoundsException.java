package sequence.exceptions;

public class RankOutOfBoundsException extends RuntimeException {
    public RankOutOfBoundsException(String err) {
        super(err);
    }
}