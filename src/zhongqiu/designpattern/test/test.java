package zhongqiu.designpattern.test;

import zhongqiu.designpattern.create.SingletonDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhongqiu on 2017/6/10.
 */
public class Test {
    private Test() {

    }

    private static class factory {
        private static Test instance = new Test();
    }

    public static Test getInstance() {
        return factory.instance;
    }

    public static void main(String[] args) {
        Test.getInstance();
    }
}