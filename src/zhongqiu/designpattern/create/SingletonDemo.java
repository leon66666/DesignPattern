package zhongqiu.designpattern.create;

//单例设计模式
public class SingletonDemo {

    /* 私有构造方法，防止被实例化 */
    private SingletonDemo() {
    }

    /*
     * 在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();
     * 语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，
     * 然后直接赋值给instance成员，然后再去初始化这个Singleton实例。
     */
    /*
	 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
	 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
	 * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
	 * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题
	 */
	/* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static SingletonDemo instance = new SingletonDemo();
    }

    /* 获取实例 */
    public static SingletonDemo getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
