package stackReferenceBased;
import java.util.Scanner;

public class TestStackReferenceBased {
	
	static Scanner in = new Scanner(System.in);
	
	static StackReferenceBased stack = new StackReferenceBased();
	
	// Check if the curly brackets {} are balanced
	// in a user-inputted string
	public static boolean isBalanced(String s) {
		StackReferenceBased bracketsStack = new StackReferenceBased();
		boolean balancedSoFar = true;
		int k = 0;
		
		// loop through string s
		while (balancedSoFar == true && k < s.length()) {
			char ch = s.charAt(k);
			k++;
			
			if (ch == '{') {
				bracketsStack.push('{');
			}
			else if (ch == '}') {
				try {
					Object openBrace = bracketsStack.pop();
				} // end try
				catch (StackException e) {
					balancedSoFar = false;
				} // end catch
			} // end if
		} // end while
		
		// Checks after going through string s
		// if the brackets are balanced
		if (balancedSoFar == true && bracketsStack.isEmpty()) {
			// stack is balanced
			return true;
		}
		else {
			// stack is not balanced
			return false;
		}
	} // end isBalanced()
	
	public static void displayMenu() {
		System.out.println("Welcome to StackTest! Please select a number from the list");
		System.out.println("1.  Push a string on to the stack");
		System.out.println("2.  Pop a string from the stack");
		System.out.println("3.  Peek at the top of the stack");
		System.out.println("4.  Empty the stack");
		System.out.println("5.  Check if a string has balanced brackets");
		System.out.println("6.  Quit the program");
		System.out.println();
	} // end displayMenu()

	public static void main(String[] args) {
		
		/*
		System.out.print("Enter a string: ");
		String userString = in.nextLine();
		
		System.out.println("Are the brackets balanced?: " + isBalanced(userString));
		*/
		int userInput = 0;
		while (userInput != 6) {
			displayMenu();
			
			userInput = in.nextInt();
			while (userInput < 1 || userInput > 6) {
				System.out.print("Please input a number between 1 & 6: ");
				userInput = in.nextInt();
			}
			
			// 1. Push a string
			if (userInput == 1) {
				System.out.print("Enter your string: ");
				in.nextLine();
				String userString = in.nextLine();
				stack.push(userString);
				System.out.println();
				stack.displayStack();
			}
			
			// 2. Pop a string
			else if (userInput == 2) {
				System.out.println("Popped string: " + stack.pop());
				System.out.println();
				stack.displayStack();
			}
			
			// 3. Peek at stack
			else if (userInput == 3) {
				System.out.println("Top of the stack: " + stack.peek());
				System.out.println();
				stack.displayStack();
			}
			
			// 4. Empty the stack
			else if (userInput == 4) {
				stack.popAll();
				stack.displayStack();
			}
			
			// 5. Check string for balanced brackets
			else if (userInput == 5) {
				System.out.print("Enter a string: ");
				in.nextLine();
				String userString = in.nextLine();
				
				System.out.println("Are the brackets balanced?: " + isBalanced(userString));
				System.out.println();
				stack.displayStack();
				
			}
		}
		
	}

}
