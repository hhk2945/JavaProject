
public class binaryexp extends expression {
	private int state;
	
	public binaryexp(String exp){
		if (exp.equals("+")){
			this.state = -1;
			super.setState(-1);
		}
		else if(exp.equals("*")){
			this.state = -2;
			super.setState(-2);
		}
	}
	
	public int Get(){
		return state;
	}

	

}
