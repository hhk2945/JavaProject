//두진영의 말정보를 가지고있음
import java.util.Scanner;
import java.io.*;

public class Board {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int Catch;
		String exit;
		int N;
		
		while(true){
			System.out.printf("보드의 크기를 정합니다.(N*N)    N의 크기를 입력해주세요. : ");
			N = input.nextInt();
			int[][] board = new int[N][N];
			if(N<4||N>6){System.out.printf("N의 값은 4에서6까지 숫자를 입력해주세요"); return;}
			System.out.printf("enter를 누르면 (%dx%d) 게임을 시작합니다.",N,N);
			input.nextLine();
			input.nextLine();
			
			board[0][0] = 1;
			board[1][0] = 2;
			Horse horse1 = new Horse(0,0,N);
			Horse horse2 = new Horse(1,0,N);
			
		
			while(true){
				System.out.println("\n초나라 공격");
				System.out.printf("현재 위치 정보 : (%d,%d)\n",horse1.getX(),horse1.getY());
				board[horse1.getX()][horse1.getY()] =0;
				System.out.println("현재 움직일 수 있는 위치 정보 : "); Catch = horse1.nextposition(horse2.getX(), horse2.getY());
				board[horse1.getX()][horse1.getY()] =1;
				if (Catch == -1){System.out.printf("\n한나라를 잡았습니다. 잡은위치(%d,%d)\n",horse1.getX(),horse1.getY()); break;}
				else if(Catch == 1){System.out.println("\n잡지 못했음");}
				
				System.out.printf("(%d,%d)으로 이동",horse1.getX(),horse1.getY());
		 	
			    input.nextLine();
				
				System.out.println("\n한나라 공격");
				System.out.printf("현재 위치 정보 : (%d,%d)\n",horse2.getX(),horse2.getY());
				board[horse2.getX()][horse2.getY()] =0;
				System.out.println("현재 움직일 수 있는 위치 정보 : "); Catch = horse2.nextposition(horse1.getX(), horse1.getY());
				board[horse2.getX()][horse2.getY()] =2;
				if (Catch == -1){System.out.printf("\n초나라를 잡았습니다. 잡은위치(%d,%d)\n",horse2.getX(),horse2.getY()); break;}
				else if(Catch == 1){System.out.println("\n잡지 못했음");}
				System.out.printf("(%d,%d)으로 이동",horse2.getX(),horse2.getY());
				
				input.nextLine();
			}
			
			System.out.println("게임이 끝났습니다!!!\n다시 하시겠습니까? (y/n)");
			exit =input.next();
			if(exit.equals("y")){}
			else if(exit.equals("n")){return;}
		}
	}
}
