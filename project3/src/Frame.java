	import java.awt.*;
import java.util.StringTokenizer;
import java.awt.event.ItemListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.Icon;
	import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.*;
	
	public class Frame extends JFrame  { 

		private final JPanel Panel;
		private final JTextField textField1;
		JTextArea textField2;
		private final JButton[] button;
		private expression[] exp = null;
		private String str = "", stackstr = "";
		private static final String[] name = {"0","1","2","3","4","5","6","7","8","9","+","*","="};
		private static Stack<expression> stack = new Stack<expression>();
		
		public Frame() 
		   {
		      super("3번째 과제 입니다.");
		      Panel = new JPanel();
		      Panel.setLayout(new GridLayout(4,3));		
		      
		      textField1 = new JTextField("");
		      textField1.setEditable(false);
		      textField1.setFont(new Font("DIALOG", Font.PLAIN, 20));
		      add(textField1,BorderLayout.NORTH); // add textField to JFrame
		      
		      textField2 = new JTextArea("스택의 결과값이 출력될 창입니다.\n");
		      textField2.setEditable(false);
		      textField2.setFont(new Font("DIALOG", Font.PLAIN, 15));
		      add(textField2,BorderLayout.EAST);
		      
		      button = new JButton[name.length];
		      for( int i = 0; i<name.length; i++){
		    	  button[i] = new JButton(name[i]);
		    	  if(i<12){
		    	  Panel.add(button[i]);}
		    	  else{
		    		  add(button[i], BorderLayout.SOUTH);
		    	  }
		    	  
		    	  
		    	  button[i].addActionListener(new ActionListener(){
		    		  expression[] exp = new expression[100];
		    		  int result = 0;
		    		  String temp, temp2;
		    		  
		    		  @Override
		    		  public void actionPerformed(ActionEvent event){
		    			
		    			String input = event.getActionCommand();
		    			
		    			
		    			if(input.equals("=")){	
		    				int j = 0;		    				
		    				StringTokenizer st = new StringTokenizer(str, " ");
		    				
		    				while (st.hasMoreTokens()) {
		    					String temp = st.nextToken();
		    					
		    					if(temp.equals("+") || temp.equals("*")){
		    						exp[j++] = new binaryexp(temp);
		    					}
		    					else{
		    						exp[j++] = new numberexp(temp);
		    					}
		    				}
		    				
		    				for(int i = 0; i < j; i++){
		    					if(exp[i].Get() != -1){ // +는 건너뜀
		    						if(exp[i].Get() != -2){ // 숫자일 경우
		    							exp[i].setA(exp[i].Get());
		    							Push(exp[i]);
		    						}
		    						else{ // *일 경우
		    							exp[i].setA(Pop().getA());
		    							exp[i].setB(exp[i+1].Get());
		    							exp[i].Cal();
		    							Push(exp[i]);
		    							i++;
		    						}
		    					}
		    				}
		    				
		    				int result = 0;
		    				while(!stack.isEmpty()){
		    					result = result + Pop().getA();
		    				}
		    				
		    				textField1.setText(String.valueOf(result));
		    			}
		    			else if (input.equals("+") || input.equals("*")){ 	  	 				
		  					temp=textField1.getText();  	
		  					str=temp+" "+input+" ";
		  					textField1.setText(str);		
		    			}
		    			else{
		    				temp=textField1.getText();  	
		  					str=temp+input;
		  					textField1.setText(str);		
		    			}
		    		  }
		    		  
		    		  public void Push(expression exp){
		    			  stack.push(exp);
		    			  
		    			  if(exp.getState() == -2){
		    				  temp2=textField2.getText();  	
		    				  stackstr=temp2+"\n"+"*"+"is pushed";
		    			  }
		    			  else{
		    				  temp2=textField2.getText();  	
			    			  stackstr=temp2+"\n"+exp.getA()+"is pushed";
		    			  }
		    			  textField2.setText(stackstr);
		    		  }
		    		  
		    		  public expression Pop(){
		    			  expression T;
		    			  T = stack.pop();
		    			  
		    			  if(T.getState()== -2){
		    				  temp2=textField2.getText();  	
		    				  stackstr=temp2+"\n"+"*"+"is poped";
		    			  }
		    			  else{
		    				  temp2=textField2.getText();  	
			    			  stackstr=temp2+"\n"+T.getA()+"is poped";
		    			  }
		    			  textField2.setText(stackstr);
		    			  return T;
		    		  }
		    	  });
		    	  
		      }
		      
		      add(Panel, BorderLayout.CENTER);
		      
		   } // end TextAreaFrame constructor
	
}