package zhongqiu.designpattern.create;

import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

import java.util.ArrayList;
import java.util.List;

//建造者模式
/*建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的
建造者模式将很多功能集成到一个类里，这个类可以创造出比较复杂的东西。
所以与工程模式的区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。
因此，是选择工厂模式还是建造者模式，依实际情况而定。*/
public class BuilderDemo {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public void sender() {
        for (Sender sender : list) {
            sender.Send();
        }
    }

    public static void main(String[] args) {
        BuilderDemo builder = new BuilderDemo();
        builder.produceMailSender(10);
        System.out.println(builder.list.size());
        builder.sender();
    }
}
