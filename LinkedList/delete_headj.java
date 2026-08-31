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
	}};
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
		while (head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	private static Node removesHead(Node head){
		if (head==null) return head;
		head = head.next;
		return head;
	}
	
	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2LL(arr);
		System.out.print("Original LinkedList : ");
		print(head);
		head = removesHead(head);
		System.out.print("\nAfter Head Removing: ");
		print(head);
	}
}






















