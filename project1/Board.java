//�������� �������� ����������
import java.util.Scanner;
import java.io.*;

public class Board {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int Catch;
		String exit;
		int N;
		
		while(true){
			System.out.printf("������ ũ�⸦ ���մϴ�.(N*N)    N�� ũ�⸦ �Է����ּ���. : ");
			N = input.nextInt();
			int[][] board = new int[N][N];
			if(N<4||N>6){System.out.printf("N�� ���� 4����6���� ���ڸ� �Է����ּ���"); return;}
			System.out.printf("enter�� ������ (%dx%d) ������ �����մϴ�.",N,N);
			input.nextLine();
			input.nextLine();
			
			board[0][0] = 1;
			board[1][0] = 2;
			Horse horse1 = new Horse(0,0,N);
			Horse horse2 = new Horse(1,0,N);
			
		
			while(true){
				System.out.println("\n�ʳ��� ����");
				System.out.printf("���� ��ġ ���� : (%d,%d)\n",horse1.getX(),horse1.getY());
				board[horse1.getX()][horse1.getY()] =0;
				System.out.println("���� ������ �� �ִ� ��ġ ���� : "); Catch = horse1.nextposition(horse2.getX(), horse2.getY());
				board[horse1.getX()][horse1.getY()] =1;
				if (Catch == -1){System.out.printf("\n�ѳ��� ��ҽ��ϴ�. ������ġ(%d,%d)\n",horse1.getX(),horse1.getY()); break;}
				else if(Catch == 1){System.out.println("\n���� ������");}
				
				System.out.printf("(%d,%d)���� �̵�",horse1.getX(),horse1.getY());
		 	
			    input.nextLine();
				
				System.out.println("\n�ѳ��� ����");
				System.out.printf("���� ��ġ ���� : (%d,%d)\n",horse2.getX(),horse2.getY());
				board[horse2.getX()][horse2.getY()] =0;
				System.out.println("���� ������ �� �ִ� ��ġ ���� : "); Catch = horse2.nextposition(horse1.getX(), horse1.getY());
				board[horse2.getX()][horse2.getY()] =2;
				if (Catch == -1){System.out.printf("\n�ʳ��� ��ҽ��ϴ�. ������ġ(%d,%d)\n",horse2.getX(),horse2.getY()); break;}
				else if(Catch == 1){System.out.println("\n���� ������");}
				System.out.printf("(%d,%d)���� �̵�",horse2.getX(),horse2.getY());
				
				input.nextLine();
			}
			
			System.out.println("������ �������ϴ�!!!\n�ٽ� �Ͻðڽ��ϱ�? (y/n)");
			exit =input.next();
			if(exit.equals("y")){}
			else if(exit.equals("n")){return;}
		}
	}
}
