package zhongqiu.designpattern.behavior.classstatus;

//状态模式
/*核心思想就是：当对象的状态改变时，同时改变其行为
根据这个特性，状态模式在日常开发中用的挺多的，
尤其是做网站的时候，我们有时希望根据对象的某一属性，区别开他们的一些功能，比如说简单的权限控制等。*/
public class StateDemo {
	public static class State {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void method1() {
			System.out.println("execute the first opt!");
		}

		public void method2() {
			System.out.println("execute the second opt!");
		}
	}

	/**
	 * 状态模式的切换类
	 */
	public static class Context {

		private State state;

		public Context(State state) {
			this.state = state;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public void method() {
			if (state.getValue().equals("state1")) {
				state.method1();
			} else if (state.getValue().equals("state2")) {
				state.method2();
			}
		}
	}

	public static void main(String[] args) {

		State state = new State();
		Context context = new Context(state);

		// 设置第一种状态
		state.setValue("state1");
		context.method();

		// 设置第二种状态
		state.setValue("state2");
		context.method();
	}
}
