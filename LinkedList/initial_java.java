class Node{
	int data;
	Node next;

	Node(int data1, Node next1){
		this.data = data1;
		this.next = next1;
	}
	
	Node(int data1){
		this.data = data1;
		this.next = null;	
	}
};

class LinkedList{
	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node y = new Node(arr[2]);
		System.out.print(y.data);
	}

}

