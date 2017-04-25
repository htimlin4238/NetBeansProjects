package grapher;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Grapher {
    public static void main(String[] args) throws Exception {
        boolean run = true;
        while (run) {
            Scanner scan = new Scanner(System.in);
            double result = 0;
            String input = "";
            
            boolean badInput = true;
            while(badInput) {
                System.out.println("Please enter your function in terms of x.");
                System.out.print("y = ");
                input = scan.nextLine();
                badInput = false;
                
                if(evaluate(findFunction(input.replace("x", "1"))) == "bad") {
                    System.out.println("I don't recognize that function.");
                    badInput = true;
                }
            }
            
            System.out.println("Please enter your domain, range, and subdivisions (x x y y s).");
            
            double x0;
            double x1;
            double y0;
            double y1;
            int s;
            
            if (scan.hasNextDouble()) {
                x0 = scan.nextDouble();
                x1 = scan.nextDouble();
                y0 = scan.nextDouble();
                y1 = scan.nextDouble();
                s = scan.nextInt();
            } else {
                x0 = -10;
                x1 = 10;
                y0 = -10;
                y1 = 10;
                s = 100;
            }
            
            double[] Ys = new double[s+1];
            for (int i = 0; i < Ys.length; i++) {
                double x = ((x1-x0)/s * i + x0);
                String expression = findFunction(input.replace("x", "("+String.valueOf(x)+")"));
                Ys[i] = Double.parseDouble(evaluate(expression));
            }
            
            for (int i = s; i >= 0; i--) {
                for (int j = 0; j < s+1; j++) {
                    if (Math.abs(Ys[j] - (i * (y1-y0) / s + y0)) < (y1-y0) / s / 2) {
                        System.out.print("+ ");
                    } else if ((i * (y1-y0) / s + y0 == 0) && (j * (x1-x0) / s + x0 == 0)) {
                        System.out.print("+ ");
                    } else if ((Ys[j] - (i * (y1-y0) / s + y0)) == (y1-y0) / s / 2) {
                        System.out.print("+ ");
                    } else if (i * (y1-y0) / s + y0 == 0) {
                        System.out.print("- ");
                    } else if (j * (x1-x0) / s + x0 == 0) {
                        System.out.print("| ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
            
        }
    }
    public static String findFunction(String input) throws Exception {
        input = input.replace("e", "Math.E");
        input = input.replace("pi", "Math.PI");
        
        input = input.replace("sin(", "Math.sin(");
        input = input.replace("cos(", "Math.cos(");
        input = input.replace("tan(", "Math.tan(");
        input = input.replace("ln(", "Math.log(");
        input = input.replace("abs(", "Math.abs(");
        
        while (input.indexOf("|") != -1) {
            input = input.substring(0, input.indexOf("|")) + "Math.abs(" + 
                    input.substring(input.indexOf("|")+1, input.substring(input.indexOf("|")+1).indexOf("|")+1) 
                    + ")" + input.substring(input.substring(input.indexOf("|")+1).indexOf("|")+2);
        }
        
        while (input.indexOf("^") != -1) {
            int parenth = 0;
            int left = 0;
            int right = 0;
            for (int i = input.substring(0, input.indexOf("^")).length()-1; i >= 0 ; i--) {
                if (input.charAt(i) == ')') {
                    parenth++;
                } else if (input.charAt(i) == '(') {
                    parenth--;
                }
                if (parenth < 1 && (i == 0 || input.charAt(i-1) == ' ' 
                        || input.charAt(i-1) == '*' || input.charAt(i-1) == '/' 
                        || input.charAt(i-1) == '+' || input.charAt(i-1) == '-' 
                        || input.charAt(i-1) == '(')) {
                    left = i;
                    i = -1;
                }
            }
            parenth = 0;
            for (int i = input.substring(0, input.indexOf("^")).length()+1; i < input.length() ; i++) {
                if (input.charAt(i) == '(') {
                    parenth++;
                } else if (input.charAt(i) == ')') {
                    parenth--;
                }
                if (parenth < 1 && (i == input.length()-1 || input.charAt(i+1) == ' ' 
                        || input.charAt(i+1) == '*' || input.charAt(i+1) == '/' 
                        || input.charAt(i+1) == '+' || input.charAt(i+1) == '-' 
                        || input.charAt(i+1) == ')')) {
                    right = i+1;
                    i = input.length();
                }
            }
            input = input.substring(0, left) + 
                    Math.pow(Double.parseDouble(evaluate(input.substring(left, input.indexOf("^")))), 
                            Double.parseDouble(evaluate(input.substring(input.indexOf("^")+1, right)))) 
                                + input.substring(right);
        }
        
        return input;
    }
    public static String evaluate(String expression) throws Exception {
        
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        try {
            engine.eval(expression);
        } catch(javax.script.ScriptException e) {
            return "bad";
        }
        
        return engine.eval(expression).toString();
    }
}