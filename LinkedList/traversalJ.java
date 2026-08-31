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
		for(int i=0; i < arr.length; i++){
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}
	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2LL(arr);
		System.out.println(head.data);
	}
}






















