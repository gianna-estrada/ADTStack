package stackReferenceBased;

public class StackReferenceBased {
	private Node top;
	
	public StackReferenceBased() {
		top = null;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}
	
	public Object pop() throws StackException {
		if (!isEmpty()) {
			Node temp = top;
			top = top.getNext();
			return temp.getItem();
		}
		else {
			throw new StackException("StackException on " + "pop: stack empty");
		}
	}
	
	// Remove all items
	public void popAll() {
		top = null;
	}
	
	// Retrieve most recently added item
	public Object peek() throws StackException {
		if (!isEmpty()) {
			return top.getItem();
		}
		else {
			throw new StackException("StackException on " + "peek: stack empty");
		}
	}
	
	// Display all items in stack
	public void displayStack() {
		Node curr = top;
		System.out.println("--- Stack Top ---");
		while (curr != null) {
			System.out.println(curr.getItem());
			curr = curr.getNext();
		}
		System.out.println("--- Stack Bottom ---");
		System.out.println();
	}
}
