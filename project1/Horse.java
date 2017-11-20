//Board객체가 게임을 진행하면서 다음 차례를 지정하면 상대측 말을 잡거나 아니면 갈 수 있는 곳 중 임의의 위치로 이동한다.
public class Horse {
	private int N;
	private int x;
	private int y;
	private int[] nextX = new int[100];
	private int[] nextY = new int[100];
	
	public Horse(int x,int y, int N) {
			this.x = x; 
			this.y = y;
			this.N = N;
	}
	
	public int nextposition(int enemyX, int enemyY){
		int i =0, j = 0, k;
		if((x+2)>=0 && (x+2) <N && (y+1)>=0 && (y+1)<N) {nextX[i] = x+2; nextY[i] = y+1; i++; }
		if((x+2)>=0 && (x+2) <N && (y-1)>=0 && (y-1)<N) {nextX[i] = x+2; nextY[i] = y-1; i++; }
		if((x-2)>=0 && (x-2) <N && (y+1)>=0 && (y+1)<N) {nextX[i] = x-2; nextY[i] = y+1; i++; }
		if((x-2)>=0 && (x-2) <N && (y-1)>=0 && (y-1)<N) {nextX[i] = x-2; nextY[i] = y-1; i++; }
		if((x+1)>=0 && (x+1) <N && (y+2)>=0 && (y+2)<N) {nextX[i] = x+1; nextY[i] = y+2; i++; }
		if((x+1)>=0 && (x+1) <N && (y-2)>=0 && (y-2)<N) {nextX[i] = x+1; nextY[i] = y-2; i++; }
		if((x-1)>=0 && (x-1) <N && (y+2)>=0 && (y+2)<N) {nextX[i] = x-1; nextY[i] = y+2; i++; }
		if((x-1)>=0 && (x-1) <N && (y-2)>=0 && (y-2)<N) {nextX[i] = x-1; nextY[i] = y-2; i++; }
		
		for (j=0; j<i; j++){
			System.out.printf("(%d,%d) ",nextX[j],nextY[j]);
		}
		
		for (j=0; j<i; j++){
			if(enemyX == nextX[j] && enemyY == nextY[j]){ 
				x = enemyX; y = enemyY; 
				return -1;
				}
			else{k =(int) (Math.random() * i); x = nextX[k]; y = nextY[k];}
		}
		return 1;
	}

	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}
