
public class numberexp extends expression {
	private String exp;
	
	public numberexp(String exp){
		this.exp = exp;
	}
	
	public int Get(){
		return Integer.parseInt(exp);
	}
}
