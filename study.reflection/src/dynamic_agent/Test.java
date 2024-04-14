package dynamic_agent;

/**
 * @author shkstart
 * @create 2021-08-07-13:39
 */
public class Test {
    public static void main(String[] args) {
//        创建被代理类对象
        SuperMan superMan = new SuperMan();
//        instance是代理类对象，根据加载到内存中的被代理类，动态的创建一个代理类及其对象
        Human instance = (Human) ProxyFactory.getProxyInstance(superMan);
//        当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = instance.getBelief();
        System.out.println(belief);
        instance.eat("土豆");
    }
}
