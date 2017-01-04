package zhongqiu.designpattern.behavior.betweenclass;

import java.util.Enumeration;
import java.util.Vector;

//观察者模式
/*类和类之间的关系，不涉及到继承
当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系。*/
public class ObserverDemo {
	public interface Observer {
		public void update();
	}

	public static class Observer1 implements Observer {

		@Override
		public void update() {
			System.out.println("observer1 has received!");
		}
	}

	public static class Observer2 implements Observer {

		@Override
		public void update() {
			System.out.println("observer2 has received!");
		}
	}

	public interface Subject {

		/* 增加观察者 */
		public void add(Observer observer);

		/* 删除观察者 */
		public void del(Observer observer);

		/* 通知所有的观察者 */
		public void notifyObservers();

		/* 自身的操作 */
		public void operation();
	}

	public abstract static class AbstractSubject implements Subject {

		private Vector<Observer> vector = new Vector<Observer>();

		@Override
		public void add(Observer observer) {
			vector.add(observer);
		}

		@Override
		public void del(Observer observer) {
			vector.remove(observer);
		}

		@Override
		public void notifyObservers() {
			Enumeration<Observer> enumo = vector.elements();
			while (enumo.hasMoreElements()) {
				enumo.nextElement().update();
			}
		}
	}

	public static class MySubject extends AbstractSubject {

		@Override
		public void operation() {
			System.out.println("update self!");
			notifyObservers();
		}

	}

	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());

		sub.operation();
	}
}
