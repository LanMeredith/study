package self_study;

/**
 * @author shkstart
 * @create 2021-07-22-23:42
 */
public interface Study {
    default void study(){
        System.out.println("我正在学习");
    }
}
