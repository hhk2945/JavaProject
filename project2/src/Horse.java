
public abstract class Horse {
	Savepos save;
	Board board;
	private int country;
	private int enemy;
	private int state = 1;
	private String name;
	private int[][] nextpos = new int[4][2];
	private int[][] Catch = new int[100][3];

	public Horse(String country, String name, int x, int y){
		if (country.equals("E")){
			board.setBoard(x, y, 1);
			this.enemy = 2;
			this.country = 1;
		}
		else{
			board.setBoard(x, y, 2);
			this.enemy = 1;
			this.country = 2;
		}
		this.name = name;
	}

	public void possiblepos() {
		int i;
		i = nextpos();
		if(state != -1){
			for(int j=0; j<i; j++){
				System.out.printf("(%s,%d,%d)",name,nextpos[j][0],nextpos[j][1]);
				save = new Savepos(name,nextpos[j][0],nextpos[j][1]);
			}
		}
	}
	
	public int Catch(){
		int C=0,j =0,i=0;
		
		for(i=0; i<save.getSaveLength(); i++){
			if(board.getBoard()[save.save[i][1]][save.save[i][2]]==enemy){
				C =1;
				Catch[j][0] = save.save[i][0];
				Catch[j][1] = save.save[i][1];
				Catch[j++][2] = save.save[i][2];
			}
		}
		
		if(C==1){ //적이 존재
			int random = (int) (Math.random()*(j));
			
			for(i=0; i<j; i++){
			if(board.getenemy(country,Catch[i][1],Catch[i][2]) == 1) random = i;
			}
			
			board.deletehorse(Catch[random][1],Catch[random][2]);
			board.setBoard(Catch[random][1], Catch[random][2], 3);
			System.out.printf("\n적을 잡음 ");
			
			return Catch[random][0];
		}
		else{//적이 없음
			int random = (int) (Math.random()*(i));
			board.setBoard(save.save[random][1], save.save[random][2], 3);
			System.out.printf("\n적을 잡지 못함 ");
			return save.save[random][0];
		}
		
	}
	

	public String getName() {
		return name;
	}
	
	public void setstate(int state){
		this.state = state;
	}
	
	public int getstate(){
		return state;
	}
	
	public int[][] getNextpos() {
		return nextpos;
	}

	public void setNextpos(int i, int x, int y) {
		nextpos[i][0] = x;
		nextpos[i][1] = y;
	}
	
	public abstract int nextpos();
	public abstract void currentpos();
	public abstract void move();
	public abstract int getX();
	public abstract int getY();

}
