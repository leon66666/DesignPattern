package zhongqiu.designpattern.struct.adapter;

public class AdapterTest {
	public static void main(String[] args) {  
        Targetable target = new AdapterDemo();  
        target.method1();  
        target.method2();  
        
        Source source = new Source();  
        Targetable wrapper = new WrapperDemo(source);  
        wrapper.method1();  
        wrapper.method2(); 
    } 
}
