package zhongqiu.designpattern.struct.adapter;

//接口的适配器模式
public abstract class InterFaceAdapterDemo implements Targetable {
	public void method1() {
	}

	public void method2() {
	}

	public static class SourceSub1 extends InterFaceAdapterDemo {
		public void method1() {
			System.out.println("the sourceable interface's first Sub1!");
		}
	}

	public static class SourceSub2 extends InterFaceAdapterDemo {
		public void method2() {
			System.out.println("the sourceable interface's second Sub2!");
		}
	}

	public static void main(String[] args) {
		InterFaceAdapterDemo source1 = new SourceSub1();
		InterFaceAdapterDemo source2 = new SourceSub2();

		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
	}
}
