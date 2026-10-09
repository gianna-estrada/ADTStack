package stackReferenceBased;

public class TestStackReferenceBased {

	public static void main(String[] args) {
		
		StackReferenceBased stack = new StackReferenceBased();
		
		stack.push("Ramen");
		stack.push("Pasta");
		stack.push("Biscuits");
		stack.push("Crisps");
		stack.push("Chocolate");
		
		//System.out.println(stack.peek());
		stack.displayStack();

	}

}
