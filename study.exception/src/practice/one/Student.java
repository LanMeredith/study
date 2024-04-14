package practice.one;

/**
 * @author shkstart
 * @create 2021-07-25-15:36
 */
public class Student {
    public int speak(int i) throws ValueIsTooLargeException {
        int x = 50;
        if (i > x) {
            throw new ValueIsTooLargeException("每班学生不得大于五十人！");
        }
        return i;
    }
}
