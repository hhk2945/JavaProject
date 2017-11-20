
public class Q extends Horse{
	private int x,y;
	private String name;
	private int country;
	
	
	public Q(String country, String name, int x, int y){
		super(country, name, x, y);
		if (country.equals("E")){
			this.country = 1;
		}
		else{
			this.country = 2;
		}
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public void currentpos() {
		if(super.getstate() != -1) System.out.printf("(%s,%d,%d)",name,x,y);
	}
	
	public int nextpos(){
		int i=0;
		if(x+1>=0 && x+1<4 && y+1>=0 && y+1<4 && super.board.getBoard()[x+1][y+1] != country) {super.setNextpos(i++,x+1,y+1);}
		if(x+1>=0 && x+1<4 && y-1>=0 && y-1<4 && super.board.getBoard()[x+1][y-1] != country) {super.setNextpos(i++,x+1,y-1);}
		if(x-1>=0 && x-1<4 && y+1>=0 && y+1<4 && super.board.getBoard()[x-1][y+1] != country) {super.setNextpos(i++,x-1,y+1);}
		if(x-1>=0 && x-1<4 && y-1>=0 && y-1<4 && super.board.getBoard()[x-1][y-1] != country) {super.setNextpos(i++,x-1,y-1);}
		
		return i;
	}
	
	public void move(){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(super.board.getBoard()[i][j]==3){
					super.board.setBoard(x, y, 0);
					x = i;
					y = j;
					super.board.setBoard(x, y, country);
				}
			}
		}
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
