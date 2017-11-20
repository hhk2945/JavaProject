
public class Savepos {
	static int[][] save = new int[100][3];

	static int i = 0;
	int name;
	
	public Savepos(String name, int x, int y){
		if(name.equals("P1")) this.name = 1;
		else if(name.equals("P2")) this.name = 2;
		else if(name.equals("Q1")) this.name = 3;
		else this.name = 4;
		
		save[i][0] = this.name;
		save[i][1] = x;
		save[i++][2] = y;
	}
	
	public int[][] getSave() {
		return save;
	}
	
	public int getSaveLength(){
		return i;
	}
	
	public void delete(){
		i=0;
	}
}
