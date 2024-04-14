import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式
 * 实现Callable接口
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口，创建多线程方式强大
 * 1.call()可以有返回值
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable是支持泛型的
 * @author shkstart
 * @create 2020-12-30-19:53
 */
public class StudyThreadThree {
    public static void main(String[] args) {
//        三：创建Callable接口实现类的对象
        OneHundred oneHundred = new OneHundred();
//        四：将此Callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(oneHundred);
//        五：将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象
        Thread thread = new Thread(futureTask);
//        六：调用start()
        thread.start();

//        七（感兴趣的话）：获取Callable中call()的返回值
        try {
//            get()返回值，即为FutureTask构造器参数Callable实现类重写的call()的返回值
            System.out.println("一百以内不包括一百的总和：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 一：创建一个实现Callable的实现类
 */
class OneHundred implements Callable {
    private int sum = 0;

    /**
     * 二：实现call()方法，将此线程要做的操作声明在call()中
     */
    @Override
    public Object call() throws Exception {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}