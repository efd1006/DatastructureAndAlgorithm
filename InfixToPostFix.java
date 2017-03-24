import java.io.*;
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      public void push(char x) {
         if (!isFull())
        {
            top++;
            stackArray[top]=x;
        }
        else
            System.out.println("Stack full...");
      }
      public char pop() {
         char retVal=0;
        if (!isEmpty())
        {
            retVal=stackArray[top];
            stackArray[top]=0;
            top--;
        }
        else
            System.out.println("Stack empty...");
        return retVal;
      }
      public char peek() {
         return stackArray[top];
      }
	  public boolean isFull(){
        if (top == maxSize-1)
            return true;
        else
            return false;
		}
	  public boolean isEmpty(){
			if (top== -1)
				return true;
			else
				return false;
		}
   }


public class InfixToPostFix {
   private Stack s;
   private String infixExpression;
   private String postfix = "";
   public InfixToPostFix(String in) {
      infixExpression = in;
      int stackSize = infixExpression.length();
      s = new Stack(stackSize);
   }
   public String checkCharacter() {
      for (int j = 0; j < infixExpression.length(); j++) {
         char ch = infixExpression.charAt(j);
         switch (ch) {
            case '+': 
            case '-':
               Operator(ch, 1); 
               break; 
            case '*': 
            case '/':
               Operator(ch, 2); 
               break; 
            case '(': 
               s.push(ch);
               break;
            case ')': 
               closeParenthesis(ch); 
               break;
            default: 
               postfix = postfix+" "+ch; 
               break;
         }
      }
      while (!s.isEmpty()) {
         postfix = postfix+" "+s.pop();
      }
      return postfix; 
   }
   public void Operator(char c, int prec1) {
      while (!s.isEmpty()) {
         char opTop = s.pop();
         if (opTop == '(') {
            s.push(opTop);
            break;
         } else {
            int prec2;
            if (opTop == '+' || opTop == '-')
            prec2 = 1;
            else
            prec2 = 2;
            if (prec2 < prec1) { 
               s.push(opTop);
               break;
            } 
            else postfix = postfix+" "+opTop;
         }
      }
      s.push(c);
   }
   public void closeParenthesis(char ch) { 
      while (!s.isEmpty()) {
         char chx = s.pop();
         if (chx == '(') 
         break; 
         else postfix = postfix+" "+chx; 
      }
   }
   public static void main(String[] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	  System.out.println("Enter infix expression to process: ");	  
	  String infixExpression = br.readLine();
	  System.out.println("You have entered the infix "+ infixExpression);
      String postfix;
      InfixToPostFix theTrans = new InfixToPostFix(infixExpression);
      postfix = theTrans.checkCharacter(); 
      System.out.println("The postfix form is: \n" + postfix);
   }
}
