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

int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* head = convertArr2LL(arr);
	cout << "Original LinkedList: ";
	print(head);
	head = removesHead(head);
	cout<<"\nAfter Head Removing: ";
	print(head);
}




















