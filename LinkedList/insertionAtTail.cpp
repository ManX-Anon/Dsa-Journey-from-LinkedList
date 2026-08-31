#include<bits/stdc++.h>

using namespace std;

class Node{
	public:
	int data;
	Node* next;
	
	public:
	Node(int data1, Node* next1){
		data = data1;
		next = next1;
	}
	
	public:
	Node(int data1){
		data = data1;
		next = nullptr;	
	}
};

Node* convertArr2LL(vector<int> &arr){
	Node* head = new Node(arr[0]);
	Node* mover = head;
	for(int i=1; i < arr.size(); i++){
		Node* temp = new Node(arr[i]);
		mover->next = temp;
		mover = temp;
	}
	return head;
}

bool isExist(Node* head, int el){
	Node* temp = head;
	while(temp != nullptr){
		if(temp->data == el){
			return true;
		}
		temp = temp->next;
	}
	return false;
}

void print(Node* head){
	while(head != NULL){
		cout << head->data <<" ";
		head = head->next;
	}
	cout << endl;
}

Node* removesHead(Node* head){
	if (head==NULL) return head;
	Node* temp = head;
	head = head->next;
	delete temp;
	return head;
}

int lengthOfLL(Node* head){
	int cnt = 0;
	Node* temp = head;
	while(temp){
		temp = temp->next;
		cnt++;
	}
	return cnt;
}

Node* deleteEl(Node* head, int el){
	if (head==NULL) return head;
	if(!isExist(head, el)){
		cout<<el<<" does not exist.";
		exit(1);
	}
	if(head->data==el){
		Node* temp = head;
		head = head->next;
		free(temp);
		return head;
	}
	Node* temp = head;
	Node* prev = NULL;
	
	while(temp != NULL){
		if(temp->data == el){
			prev->next = prev->next->next;
			free(temp);
			break;
		}
		prev = temp;
		temp = temp->next;
	}
	return head;
}	

Node* insertNodeAtHead(Node* head, int val){
	Node* temp = new Node(val, head);
	return temp;
}

Node* insertNodeAtTail(Node* head, int val){
	Node* temp = new Node(val, head);
	Node* temp2 = head;
	while( temp2 != NULL){
		if(temp2->next==NULL){
			temp2->next = temp;
			temp->next = NULL;
			break;
		}
		temp2 = temp2->next;
	}
	return head;
}

int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* head = convertArr2LL(arr);
	cout << "Original LinkedList: ";
	print(head);
	int choice;
	cout<<"Enter a number to Insert : ";
	cin>>choice;
	head = insertNodeAtTail(head, choice);
	cout<<"\nAfter Inserting "<<choice <<": ";
	print(head);
}
