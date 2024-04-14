package practice.three;

/**3
 * 无效数值异常
 * @author shkstart
 * @create 2021-07-29-13:31
 */
public class InvalidValuesException extends Exception{
    static final long serialVersionUID = -840620000725L;

    public InvalidValuesException() {
    }

    public InvalidValuesException(String message) {
        super(message);
    }
}
