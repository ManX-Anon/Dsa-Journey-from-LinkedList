class Node{
	int data;
	Node next;
	Node back;

	Node(int data1, Node next1, Node back1){
		this.data = data1;
		this.next = next1;
		this.back = back1;
	}
	
	Node(int data1){
		this.data = data1;
		this.next = null;
		this.back = null;	
	}
};

class LinkedList{
	private static Node convertArr2Dll(int[] arr){
		Node head = new Node(arr[0]);
		Node prev = head;
		for(int i=1; i<arr.length; i++){
			Node temp = new Node(arr[i], null, prev);
			prev.next = temp;
			prev = temp;
		}
		return head;
	}
	
	private static void print(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	private static Node deleteHead(Node head){
		if (head == null || head.next == null){
			return null;
		}
		Node prev = head;
		head = head.next;
		
		head.back = null;
		prev.next = null;
		
		return head;
			
	}
	
	private static Node deleteTail(Node head){
		if (head == null) return null;
		if (head.next == null){
			deleteHead(head); 
			return null;
		}
		Node tail = head;
		Node prev = tail;
		while(tail.next != null){
			tail = tail.next;
		}
		prev = tail.back;
		prev.next = null;
		tail.back = null;
		return head;
	}
	
	private static Node deleteKth(Node head, int k){
	Node kNode = head;
	int cnt = 0;
	while(kNode.next != null){
		cnt++;
		if(cnt==k){
			break;
		}
		kNode = kNode.next;
	}
	Node prev = kNode.back;
	Node front = kNode.next;
	if(prev==null || front==null) return null;
	else if(prev==null) return deleteHead(head);
	else if(front==null) return deleteTail(head);
	prev.next = front;
	front.back = prev;
	
	kNode.next = null;
	kNode.back = null;
	return head;
	}

	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2Dll(arr);
		print(head);
		System.out.println();
		head = deleteTail(head);
		print(head);
	}

}























