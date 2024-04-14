package singleton;

/**
 * 单例模式的懒汉式实现
 * 所谓的类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 * 用同步机制将其改成线程安全的
 */
public class Lazy {
    public static void main(String[] args) {
        Order order1 = Order.getinstance();
        Order order2 = Order.getinstance();

        System.out.println(order1 == order2);
    }
}

class Order {
	/**
	 * 私有化的构造器
	 */
    private Order() {
    }

	/**
	 * 声明当前类的对象，不要初始化。此对象也必须声明为static的
	 */
    private static Order instance = null;

	/**
	 * 创建公共的静态的方法，返回类的对象
	 */
	public static Order getinstance() {
    	/*
    	方式一，效率低
//    	在这里需要先同步，再判断，如果先判断的话，两个线程的instance都为null时就会进入到当中，先后new出两个Order
//		静态方法的同步锁可以是当前类本身，而不能用this
        synchronized (Order.class) {
            if (instance == null) {
                instance = new Order();
            }
        }
        return instance;
    	 */

		/*
		方式二，效率提高
		 */
		if(instance == null){
			synchronized (Order.class){
				if(instance == null){
					instance = new Order();
				}
			}
		}
		return instance;
	}
}