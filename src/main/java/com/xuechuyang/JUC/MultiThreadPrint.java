package com.xuechuyang.JUC;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChuYang
 * @version 1.0
 */
public class MultiThreadPrint {
    static volatile int sum = 1;
    static Lock lock = new ReentrantLock();
    static Condition condition;

    public static void main(String[] args) {
        //Alibaba的java开发规范中表示要手动创建线程池
        ThreadPoolExecutor executorService = new ThreadPoolExecutor
                (2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        condition = lock.newCondition();
        executorService.execute(new Task1());
        executorService.execute(new Task2());
        executorService.shutdown();
    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            while (sum < 100) {
                lock.lock();
                try {
                    while (sum % 2 == 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + sum++);
                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            while (sum < 100) {
                lock.lock();
                try {
                    while (sum % 2 == 1) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + sum++);
                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
