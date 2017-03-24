import java.util.Stack;
import java.io.*;
import java.util.ArrayList;
public class PostfixExpressionEvaluation {
    public static int evalPostfixExpression(String[] op) {     
        if(op.length == 1) {
            return Integer.parseInt(op[0]);
        }     
        Stack<Integer> s = new Stack<Integer>();
        for(String exp : op) {
             
            Integer value = null;
            String operator = null;
            if((exp.charAt(0) >= '0' && exp.charAt(0) <= '9') ||
               (exp.charAt(0) == '-' && exp.length() > 1)) {
                value = Integer.parseInt(exp);
            } else {
                operator = exp;
            }
             
            if(operator != null) {
                Integer y = s.pop();
                Integer x = s.pop();
                 
                switch(operator) {
                    case "+" : value = x + y; break;
                    case "-" : value = x - y; break;
                    case "*" : value = x * y; break;
                    case "/" : value = x / y; break;
                }
            }
            s.push(value);
        }
        return s.pop();
    }
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter postfix expression: ");
		String postfixExpression = br.readLine();
		String[] values;
        ArrayList<String> variables = new ArrayList<>();
		String str="";
		for(int z=0;z<postfixExpression.length();z++){
			str = postfixExpression.substring(z,z+1);
			if((str.matches("[a-zA-Z]|\\d"))){
				variables.add(str);
			}
		}
		values = new String[variables.size()];
		System.out.println("You have entered the postfix: "+postfixExpression);
		for(int z=0;z<values.length;z++){
			System.out.print("Enter value for "+variables.get(z)+": ");
			values[z] = br.readLine();
		}
		for(int z=0;z<values.length;z++){
			System.out.println(values[z]);
		}
		System.out.println(postfixExpression);
		String new_postfix = new String(postfixExpression);
		for(int z=0;z<new_postfix.length();z++){
			for(int x=0;x<variables.size();x++){
				new_postfix = new_postfix.replace(variables.get(x),values[x]);
			}
			
		}
		String[] op = new String[new_postfix.length()];
		for(int z=0;z<new_postfix.length();z++){
			op[z] = Character.toString(new_postfix.charAt(z));
		}
        System.out.println("The result of "+postfixExpression+" is: "+evalPostfixExpression(op));
    }
}