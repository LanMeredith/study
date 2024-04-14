package three.service;

/**
 * 自定义异常类
 * @author shkstart
 * @create 2021-08-12-21:51
 */
public class TeamException extends Exception{
    static final Long serialVersionUID = -768890253665650L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
