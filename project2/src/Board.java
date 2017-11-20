import java.util.Scanner;

public class Board {
	static int[][] board = new int[4][4];
	static Horse [] E = new Horse[4];
	static Horse [] F = new Horse[4];
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		while(true){
			System.out.printf("enter를 누르면  게임을 시작합니다.");
			input.nextLine();
			String win;
			
			E[0] = new P("E","P1",0,0); 
			E[1] = new P("E","P2",0,1);
			E[2] = new Q("E","Q1",0,2);
			E[3] = new Q("E","Q2",0,3);
			
			F[0] = new P("F","P1",3,2);
			F[1] = new P("F","P2",3,3);
			F[2] = new Q("F","Q1",3,0);
			F[3] = new Q("F","Q2",3,1);
			
			while(true){
				System.out.println("E나라 공격");
				System.out.printf("남은 말의 위치정보 : ");
				for (Horse Ecurrent : E){
					Ecurrent.currentpos();
				}
				System.out.println("\n이동 가능한 위치 : ");
				for (Horse Ecurrent : E){
					Ecurrent.possiblepos();
				}
				
				switch(E[0].Catch()){
				case 1 : {E[0].move(); E[0].currentpos(); System.out.printf("로 이동\n");break;}
				case 2 : {E[1].move(); E[1].currentpos(); System.out.printf("로 이동\n");break;}
				case 3 : {E[2].move(); E[2].currentpos(); System.out.printf("로 이동\n");break;}
				case 4 : {E[3].move(); E[3].currentpos(); System.out.printf("로 이동\n");}
				}
				
				E[0].save.delete();
				if(F[0].getstate()==-1 && F[1].getstate()==-1 && F[2].getstate()==-1 && F[3].getstate()==-1) {win = "E";break;}
			    input.nextLine();
				
	     		System.out.println("P나라 공격");
				System.out.printf("남은 말의 위치 정보 : ");
				for (Horse Ecurrent : F){
					Ecurrent.currentpos();
				}
				System.out.println("\n이동 가능한 위치 : ");
				for (Horse Ecurrent : F){
					Ecurrent.possiblepos();
				}
				
				switch(F[0].Catch()){
				case 1 : {F[0].move(); F[0].currentpos(); System.out.printf("로 이동\n");break;}
				case 2 : {F[1].move(); F[1].currentpos(); System.out.printf("로 이동\n");break;}
				case 3 : {F[2].move(); F[2].currentpos(); System.out.printf("로 이동\n");break;}
				case 4 : {F[3].move(); F[3].currentpos(); System.out.printf("로 이동\n");}
				}
				
				F[0].save.delete();
				if(E[0].getstate()==-1 && E[1].getstate()==-1 && E[2].getstate()==-1 && E[3].getstate()==-1) {win = "F";break;}
				input.nextLine();
			}
				
			
			System.out.printf("%s나라가 승리하였습니다.\n다시시작하시겠습니까(y/n)? ",win);
			if(input.nextLine().equals("n")) return;
			}
	}


	public static void deletehorse(int x, int y) {
		switch(board[x][y]){
		case 1 : {
			for(int i=0; i<4; i++){
				if(E[i].getX() == x && E[i].getY() == y) E[i].setstate(-1);
			}
		}
		case 2 :
			for(int i=0; i<4; i++){
				if(F[i].getX() == x && F[i].getY() == y) F[i].setstate(-1);
			}
		}
	}


	public static int getenemy(int country, int x, int y) {
		switch(country){
		case 1 : {
			for(int i=0; i<4; i++){
				if(F[i].getX() == x && F[i].getY() == y){
					if(F[i].getName().equals("P1") || F[i].getName().equals("P2")) return 1;
					else return 2;
				}
			}
		} break;
		case 2 :
			for(int i=0; i<4; i++){
				if(E[i].getX() == x && E[i].getY() == y){
					if(E[i].getName().equals("P1") || E[i].getName().equals("P2")) return 1;
					else return 2;
				}
			}
		}
		return 0;
	}
	
	public static int[][] getBoard() {
		return board;
	}


	public static void setBoard(int x, int y , int i) {
		board[x][y] = i;
	}

}
