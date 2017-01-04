package zhongqiu.designpattern.behavior.middleclass;

//访问者模式
/*访问者模式是对象的行为模式。访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。
一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。
该模式适用场景：如果我们想为一个现有的类增加新功能，不得不考虑几个事情：
1、新功能会不会与现有功能出现兼容性问题？2、以后会不会再需要添加？3、如果类不允许修改代码怎么办？
面对这些问题，最好的解决方法就是使用访问者模式，访问者模式适用于数据结构相对稳定的系统，把数据结构和算法解耦*/
public class VisitorDemo {
	// 银行柜台服务，以后银行要新增业务，只需要新增一个类实现这个接口就可以了。
	interface Service {

		public void accept(Visitor visitor);
	}

	// 来办业务的人，里面可以加上权限控制等等
	static class Visitor {

		public void process(Service service) {
			// 基本业务
			System.out.println("基本业务");
		}

		public void process(Saving service) {
			// 存款
			System.out.println("存款");
		}

		public void process(Draw service) {
			// 提款
			System.out.println("提款");
		}

		public void process(Fund service) {
			System.out.println("基金");
			// 基金
		}

	}

	static class Saving implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	static class Draw implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	static class Fund implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	public static void main(String[] args) {
		Service saving = new Saving();
		Service fund = new Fund();
		Service draw = new Draw();
		Visitor visitor = new Visitor();
		Visitor guweiwei = new Visitor();
		fund.accept(guweiwei);
		saving.accept(visitor);
		fund.accept(visitor);
		draw.accept(visitor);
	}
}
