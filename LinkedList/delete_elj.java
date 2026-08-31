import java.util.Scanner;
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
	
	private static int lengthOfLL(Node head){
		int cnt = 0;
		Node temp = head;
		while(temp != null){
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}
	
	private static boolean isExist(Node head, int el){
	Node temp = head;
	while(temp != null){
		if(temp.data == el){
			return true;
		}
		temp = temp.next;
	}
	return false;
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
	
	private static Node deleteTail(Node head){
		if(head==null || head.next==null) return null;
		Node temp = head;
		while(temp.next.next != null){
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	
	private static Node deleteEl(Node head, int el){
		if (head==null) return head;
		if(head.data==el){
			head = head.next;
			return head;
		}
		
		if (!isExist(head, el)) {
			System.out.println(el+" does not exist.");
			System.exit(1);
		}
		Node temp = head;
		Node prev = null;
		while(temp != null ){
			if(temp.data == el){
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int choice;
		int[] arr = {4,5,6,2,6};
		Node head = convertArr2LL(arr);
		System.out.print("Original LinkedList : ");
		print(head);
		System.out.print("\nEnter an number to delete: ");
		choice = sc.nextInt();
		head = deleteEl(head, choice);
		System.out.print("\nAfter Removing "+choice+": ");
		print(head);
	}
}






















