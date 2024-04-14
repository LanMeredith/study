package eight;

/**
 * @author shkstart
 * @create 2021-08-28-19:39
 */
public class OverdraftException extends Exception{
    private double deficit;

    public double getDeficit() {
        return deficit;
    }

    public OverdraftException(String message) {
        super(message);
    }

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
}
