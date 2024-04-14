/**
 * @author shkstart
 * @creat 2022-09-08-11:13
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circleOne = new Circle();
        Circle circleTwo = new Circle(20.5);
        Circle circleThree = new Circle("black", 2.6, 32.2);
        circleOne.setColor("red");
        circleOne.setWeight(45);
        circleOne.setRadius(20.5);
        circleTwo.setColor("blue");
        circleTwo.setWeight(2.6);

//        比较颜色是否相同，在这里调用的equals方法来自于String类中重写的方法
        System.out.println("比较circleOne与circleTwo的颜色是否相同：" +
                circleOne.getColor().equals(circleTwo.getColor()));
        System.out.println("比较circleOne与circleThree的颜色是否相同：" +
                circleOne.getColor().equals(circleThree.getColor()));
        System.out.println("比较circleTwo与circleThree的颜色是否相同：" +
                circleTwo.getColor().equals(circleThree.getColor()));
        System.out.println();

//        比较半径是否相同，在这里调用equals方法来自于Circle类中重写的方法
        System.out.println("比较circleOne与circleTwo的半径是否相同：" +
                circleOne.equals(circleTwo));
        System.out.println("比较circleOne与circleThree的半径是否相同：" +
                circleOne.equals(circleThree));
        System.out.println("比较circleTwo与circleThree的半径是否相同：" +
                circleTwo.equals(circleThree));
        System.out.println();

//        比较面积是否相同，这里findArea返回的是double类型的值，所以直接采用==比较即可
        System.out.println("比较circleOne与circleTwo的面积是否相同：" +
                (circleOne.findArea() == circleTwo.findArea()));
        System.out.println("比较circleOne与circleThree的面积是否相同：" +
                (circleOne.findArea() == circleThree.findArea()));
        System.out.println("比较circleTwo与circleThree的面积是否相同：" +
                (circleTwo.findArea() == circleThree.findArea()));
        System.out.println();

//        利用toString方法输出半径
        System.out.println("circleOne的半径是：" + circleOne.getRadius());
        System.out.println(circleTwo.toString());
//        当我们输出一个对象的引用时，实际上就是调用当前对象的toString方法
        System.out.println(circleThree);
    }
}
