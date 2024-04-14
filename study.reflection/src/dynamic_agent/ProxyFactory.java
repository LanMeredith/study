package dynamic_agent;

import java.lang.reflect.Proxy;

/**
 * 要实现动态代理，需要解决的问题：
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 * @author shkstart
 * @create 2021-08-07-13:17
 */
public class ProxyFactory {
    /**
     * 调用此方法，返回一个代理类的对象，解决问题一
     * @param obj 被代理类的对象
     * @return
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setObj(obj);
        /*
        * 实质上是通过反射将被代理类的加载器和接口与代理对象关联起来
        * obj.getClass().getClassLoader()被代理对象的类加载器
        * obj.getClass().getInterfaces()被代理对象的接口
        * handler即为代理类对象，实现InvocationHandler接口
        * 动态代理方法在执行时，会调用handler里面的invoke方法进行执行
        * */
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
