package zhongqiu.designpattern.test;

import zhongqiu.designpattern.create.SingletonDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhongqiu on 2017/6/10.
 */
public class Test {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void recover() {
        a = 1;
        b = 2;
    }

    public void print() {
        System.out.println("a=" + a + ";b=" + b);
        if (a == 3 && b == 2) {
            System.out.println("a=" + a + ";b=" + b);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        final Test test = new Test();
        while (true) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    test.recover();
                    test.change();
                    test.print();
                }
            });
        }
    }
}