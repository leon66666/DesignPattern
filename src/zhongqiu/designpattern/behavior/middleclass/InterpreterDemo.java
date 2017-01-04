package zhongqiu.designpattern.behavior.middleclass;

//解释器模式
//解释器模式用来做各种各样的解释器，如正则表达式等的解释器等等！
public class InterpreterDemo {
	public interface Expression {  
	    public int interpret(Context context);  
	} 
	public static class Plus implements Expression {  
		  
	    @Override  
	    public int interpret(Context context) {  
	        return context.getNum1()+context.getNum2();  
	    }  
	}  
	public static class Minus implements Expression {  
		  
	    @Override  
	    public int interpret(Context context) {  
	        return context.getNum1()-context.getNum2();  
	    }  
	} 
	public static class Context {  
	      
	    private int num1;  
	    private int num2;  
	      
	    public Context(int num1, int num2) {  
	        this.num1 = num1;  
	        this.num2 = num2;  
	    }  
	      
	    public int getNum1() {  
	        return num1;  
	    }  
	    public void setNum1(int num1) {  
	        this.num1 = num1;  
	    }  
	    public int getNum2() {  
	        return num2;  
	    }  
	    public void setNum2(int num2) {  
	        this.num2 = num2;  
	    }  
	      
	      
	} 
	public static void main(String[] args) {  
		  
        // 计算9+2-8的值  
        int result = new Minus().interpret((new Context(new Plus()  
                .interpret(new Context(9, 2)), 8)));  
        System.out.println(result);  
    }  
}
