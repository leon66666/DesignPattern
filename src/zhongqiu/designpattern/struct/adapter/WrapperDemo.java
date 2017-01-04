package zhongqiu.designpattern.struct.adapter;

/*对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，
可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。*/
public class WrapperDemo implements Targetable {

	private Source source;

	public WrapperDemo(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

	@Override
	public void method1() {
		source.method1();
	}
}
