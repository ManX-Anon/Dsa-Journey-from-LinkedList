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
	
	private static Node insertionAtTail(Node head, int val){
		Node temp = new Node(val, head);
		Node temp2 = head;
		while(temp2!=null){
			if (temp2.next == null){
				temp2.next=temp;
				temp.next = null;
				break;
			}
			temp2 = temp2.next;
		}
		return head;	
	}
	
	
	private static Node deleteKth(Node head, int k){
		if (head==null) return head;
		if(k==1){
			head = head.next;
			return head;
		}
		if (k > lengthOfLL(head)) {
			System.out.println("Enter Valid Number, There are only "+lengthOfLL(head)+" elements in the LinkedList.");
			System.exit(1);
		}
		int cnt = 0;
		Node temp = head;
		Node prev = null;
		while(temp != null ){
			cnt = cnt + 1;
			if(cnt == k){
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
		System.out.print("\nEnter an Number to insert: ");
		choice = sc.nextInt();
		head = insertionAtTail(head, choice);
		System.out.print("\nAfter Inserting "+choice+" : ");
		print(head);
	}
}






















