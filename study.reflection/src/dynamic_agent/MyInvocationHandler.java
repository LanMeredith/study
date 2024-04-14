package dynamic_agent;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler是动态代理要实现的接口
 * 动态代理类
 *
 * @author shkstart
 * @create 2021-08-07-13:20
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 设置被代理类在ProxyFactory类中经关联后成功的用被代理类对象完成赋值
     * obj需要使用被代理类的对象进行赋值
     */
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * 当我们通过代理类的对象，调用方法a时，就会自动的调用如下方法：invoke()
     * 将被代理类要执行的方法a的功能就声明在invoke()中
     *
     * @param proxy  代理类对象  newProxyInstance()的返回对象
     * @param method 代理对象执行的方法，此方法也就作为了被代理类对象要调用的方法
     * @param args   参数
     * @return returnValue即为method.invoke(obj, args)的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        通过函数名，反射调用相应的函数
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
