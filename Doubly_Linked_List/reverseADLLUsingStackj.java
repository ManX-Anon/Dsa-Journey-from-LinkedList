import java.util.Stack;

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
	
	private static void deleteNode(Node temp){
	
	Node prev = temp.back;
	Node front = temp.next;
	
	if(front==null){
		prev.next = null;
		temp.back = null;
		return;
	}
	prev.next = front;
	front.back = prev;
	
	temp.next = temp.back = null;
	return;
	}
	
	private static Node insertAtHead(Node head, int val){
		Node temp = new Node(val, head, null);
		head.back = temp;
		return temp;
	}
	
	
	private static Node insertBeforeTail(Node head, int val){
		if(head.next==null) return insertAtHead(head, val);
		
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		Node prev = temp.back;
		Node front = temp.next;
		Node newNode = new Node(val,temp, null);
		prev.next = newNode;
		temp.back = newNode;
		return head;
	}
	
	private static Node reverseADLL(Node head){
		if (head==null || head.next==null) return head;
		Node prev = null;
		Node curr = head;
		while(curr != null){
			prev = curr.back;
			curr.back = curr.next;
			curr.next = prev;
		
			curr = curr.back;
		}
	
		return prev.back;	
	}
	
	private static void reverseUsingStack(Node head) {
    		if (head == null) return;
    		Stack<Integer> st = new Stack<>();
    		Node temp = head;
    		while (temp != null) {
       		st.push(temp.data);
        	temp = temp.next;
    		}

    		temp = head;
    		while (temp != null) {
        		temp.data = st.pop();
        		temp = temp.next;
    		}
	}
	
	private static void insertBeforeNode(Node node, int val){
		Node prev = node.back;
		Node newNode  = new Node(val, node, prev);
		prev.next = newNode;
		node.back = newNode;
	}

	public static void main(String[] args){
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2Dll(arr);
		print(head);
		System.out.println();
		reverseUsingStack(head);
		print(head);
	}

}




