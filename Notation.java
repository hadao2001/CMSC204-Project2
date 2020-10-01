package Notation;
import java.util.HashMap;


/**

CMSC 204 Assignment 2
Class Notation
@author Ha T DAo
Description: The Notation class will have a method infixToPostfix to convert infix notation to postfix notation that will
take in a string and return a string, a method postfixToInfix to convert postfix notation to infix notation that will take
in a string and return a string, and a method to evaluatePostfix to evaluate the postfix expression. It will take in a string
and return a double. A method to evaluateInfix to evaluate the infix expression. It will take in a string and return a double.
*/

public class Notation {

	/**
     * No-arg constructor.
     */
    public Notation() {
        
    } 
    
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix The infix expression in string format
	 * @return The postfix expression in a string format
	 * @throws InvalidNotationFormatException If the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

		
		NotationQueue<Character> postFixSolution = new NotationQueue<>(infix.length());
		NotationStack<Character> oStack = new NotationStack<>(infix.length());
		char[] s = infix.toCharArray();

		try {
			for (char current : s) {
				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					postFixSolution.enqueue(current);
					continue;
				}
				if (current == '(') {
					oStack.push(current);
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (!postFixSolution.isEmpty()) {
						char top = oStack.top();
						if (top == '*' || top == '/' || current == '-' && top == '-' || current == '-' && top == '+'
								|| current == '+' && top == '-' || current == '+' && top == '+') {
							postFixSolution.enqueue(oStack.pop());

						}
					}
					oStack.push(current);
					continue;
				}
				if (current == ')') {
					while (oStack.top() != '(') {
						postFixSolution.enqueue(oStack.pop());
						if (oStack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					oStack.pop();
				}

			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		return postFixSolution.toString();

	}
	/**
	 * Converts the postfix expression to the infix expression
	 * @param postfix The postfix expression in string format
	 * @return The infix expression in string format
	 * @throws InvalidNotationFormatException If the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		NotationStack<String> infixSolution = new NotationStack<>(postfix.length());

		try {
			for (int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);

				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					infixSolution.push(Character.toString(current));
					continue;
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (infixSolution.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String first = infixSolution.pop();
					String second = infixSolution.pop();
					String s = "(" + second + current + first + ")";
					infixSolution.push(s);

				}
			}

		} catch (StackUnderflowException | StackOverflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		if (infixSolution.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return infixSolution.toString();
	}
    
	/**
	 * This method takes a infix expression to find its result.
	 * @param infixExpr infix expression to be evaluated
	 * @return result value of infix expression
	 */
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException{
	    
	    return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
	}
	
	
    /**
     * This method takes a postfix expression to find its result.
     * @param postfixExpr postfix expression to be evaluated
     * @return result value of infix expression
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
    	NotationStack<Double> valueStack = new NotationStack<>(postfixExpr.length());
        valueStack.push(Double.NaN);
        
        HashMap<String, Integer> precedence = new HashMap<>();
        precedence.put("-", 1);
        precedence.put("+", 2);
        precedence.put("/", 3);
        precedence.put("*", 4);
        
        for (char c : postfixExpr.toCharArray()) {
                        
            if (Character.isDigit(c)) {
                valueStack.push(Double.parseDouble(String.valueOf(c)));
            } else if (c == '-' || c == '+' || c == '/' || c == '*') {
                if (valueStack.size() < 3) {
                    throw new InvalidNotationFormatException();
                }
                double first = valueStack.pop(), second = valueStack.pop();
                double result = (c == '-') ? second - first : 
                        (c == '+') ? second + first : 
                        (c == '/') ? second / first :
                        (c == '*') ? second * first : 0;
                valueStack.push(result);
            } 
            
        }
        
        if (valueStack.size() > 2) {
            throw new InvalidNotationFormatException();
        }
        
        return valueStack.peek();
    }
}
