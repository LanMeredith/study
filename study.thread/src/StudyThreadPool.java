import java.util.concurrent.*;

/**
 * 创建线程的方法四：使用线程池
 * @author shkstart
 * @create 2021-09-05-16:51
 */
public class StudyThreadPool {
    public static void main(String[] args) {
//        提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) service;

//        设置线程池的属性
        tpe.setCorePoolSize(7);

//        适合用于Runnable
        service.execute(new OddNumber());

//        适合用于Callable
        Future submit = service.submit(new OneHundred());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        关闭线程池
        service.shutdown();
    }
}
