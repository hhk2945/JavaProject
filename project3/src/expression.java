import java.util.Stack;

public abstract class expression {
	private int state = -1;
	private int a,b;
	
	public expression(){
		
	}
	
	public void Cal(){
		int c;
		
		if (state == -1){
			a = a + b;
		}
		else {
			a = a * b;
		}
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public int getA(){
		return a;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int getState(){
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public abstract int Get();

	
}
