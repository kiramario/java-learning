package application;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class threadDemo {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition = reentrantLock.newCondition();

    public static void demo1() {
        // 线程A
        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("线程1获取锁成功");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                // 然后进入等待  后续代码不会被执行
                condition.await();
            } catch (InterruptedException e) {}

            // 此处一旦释放锁，下面的线程B就会立即被唤醒和执行
            reentrantLock.unlock();  //建议在finally中释放
        }).start();

        // 线程B
        new Thread(() ->{
            reentrantLock.lock();
            System.out.println("线程2获取锁成功");

            //执行唤醒A线程，这个操作不会释放锁，A被唤醒后开始获取锁，由于锁还是在B手中，所以A无法执行
            condition.signal();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {}

            reentrantLock.unlock();  //建议在finally中释放
        }).start();
    }

    public static void main(String[] args) {

    }
}
