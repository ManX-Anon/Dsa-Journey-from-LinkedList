import java.util.Stack;

class Node{
	int data;
	Node next;

	Node(int data1, Node next1){
		data = data1;
		next = next1;
	}

	Node(int data1){
		data = data1;
		next = null;	
	}
};

class LinkedList{
	private static Node convertArr2LL(int[] arr){
		Node head = new Node(arr[0]);
		Node mover = head;
		for(int i=1; i < arr.length; i++){
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}
	
	private static void print(Node head){
		if (head==null) System.exit(1);
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	private static Node reverseLinkedList(Node head){
		if (head==null) return head;
		Node temp = head;
		Stack<Integer> stack = new Stack<>();
		while(temp != null){
			stack.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while(!stack.isEmpty()){
			temp.data = stack.peek();
			stack.pop();
			temp = temp.next;
		}
		return head;
	}
	
	
	
	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2LL(arr);
		System.out.print("Original Linked List: ");
		print(head);
		head = reverseLinkedList(head);
		System.out.print("\nReversed Linked List: ");
		print(head);
	}
}






















