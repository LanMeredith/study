package practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shkstart
 * @create 2021-09-05-11:57
 */
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        FutureTask TaskA = new FutureTask(bank);
        FutureTask TaskB = new FutureTask(bank);

        Thread threadA = new Thread(TaskA);
        Thread threadB = new Thread(TaskB);

        threadA.setName("储户A");
        threadB.setName("储户B");

        threadA.start();
        threadB.start();

        try {
            System.out.println("余额：money = " + TaskA.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
