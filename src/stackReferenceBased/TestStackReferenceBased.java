package stackReferenceBased;
import java.util.Scanner;

public class TestStackReferenceBased {
	
	static Scanner in = new Scanner(System.in);
	
	static StackReferenceBased stack = new StackReferenceBased();
	
	// Check if the curly brackets {} are balanced
	// in a user-inputted string
	public static boolean isBalanced(String s) {
		boolean balancedSoFar = true;
		int k = 0;
		
		// loop through string s
		while (balancedSoFar == true && k < s.length()) {
			char ch = s.charAt(k);
			k++;
			
			if (ch == '{') {
				stack.push('{');
			}
			else if (ch == '}') {
				try {
					Object openBrace = stack.pop();
				} // end try
				catch (StackException e) {
					balancedSoFar = false;
				} // end catch
			} // end if
		} // end while
		
		// Checks after going through string s
		// if the brackets are balanced
		if (balancedSoFar == true && stack.isEmpty()) {
			// stack is balanced
			return true;
		}
		else {
			// stack is not balanced
			return false;
		}
	}

	public static void main(String[] args) {
		
		System.out.print("Enter a string: ");
		String userString = in.nextLine();
		
		System.out.println("Are the brackets balanced in " + userString + "?: " + isBalanced(userString));

	}

}
