package practice.two;

/**
 * 负整数异常
 * @author shkstart
 * @create 2021-07-25-15:51
 */
public class NegativeIntegerException extends Exception{
    static final long serialVersionUID = -19914552408L;

    public NegativeIntegerException() {
    }

    public NegativeIntegerException(String message) {
        super(message);
    }
}
