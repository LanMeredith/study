package practice.one;

/**
 * 数值过大异常类
 * @author shkstart
 * @create 2021-07-29-14:35
 */
public class ValueIsTooLargeException extends Exception{
    static final long serialVersionUID = -1011784041431L;

    public ValueIsTooLargeException() {
    }

    public ValueIsTooLargeException(String message) {
        super(message);
    }
}
