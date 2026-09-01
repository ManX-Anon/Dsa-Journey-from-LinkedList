#include<bits/stdc++.h>

using namespace std;

class Node{
	public:
	int data;
	Node* next;
	Node* back;
	
	public:
	Node(int data1, Node* next1, Node* back1){
		data = data1;
		next = next1;
		back = back1;
	}
	
	public:
	Node(int data1){
		data = data1;
		next = nullptr;	
		back = nullptr;
	}
};

Node* convertArr2Dll(vector<int> &arr){
	Node* head = new Node(arr[0]);
	Node* prev = head;
	for(int i=1; i<arr.size(); i++){
		Node* temp = new Node(arr[i], nullptr, prev);
		prev->next = temp;
		prev = temp;
	}
	return head; 
}

Node* deleteHead(Node* head){
	if (head==NULL || head->next == NULL) return NULL;
	Node* prev = head;
	head = head->next;
	head->back = nullptr;
	prev->next = nullptr;
	delete prev;
	return head;
}

Node* deleteTail(Node* head){
	if (head == NULL) return NULL;
	if(head->next==NULL){
		return deleteHead(head); // As the Head and Tail Are Same, We surely can call deleteHead .
	}
	Node* tail = head;
	
	while(tail->next != NULL){
		tail = tail->next;	
	}
	Node* prev = tail->back;
	prev->next = nullptr; // Removes the reference of tail from previous element
	tail->back = nullptr; // removes the reference of previous  element from tail. 
	delete tail;
	return head;
}

Node* deleteKth(Node* head, int k){
	Node* kNode = head;
	int cnt = 0;
	while(kNode->next != NULL){
		cnt++;
		if(cnt==k){
			break;
		}
		kNode = kNode->next;
	}
	Node* prev = kNode->back;
	Node* front = kNode->next;
	if(prev==NULL || front==NULL) return NULL;
	else if(prev==NULL) return deleteHead(head);
	else if(front==NULL) return deleteTail(head);
	prev->next = front;
	front->back = prev;
	
	kNode->next = nullptr;
	kNode->back = nullptr;
	delete kNode;
	return head;
}

void print(Node* head){
	while(head!=NULL){
		cout<<head->data<<" ";
		head = head->next;
	}
}
int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* head = convertArr2Dll(arr);
	print(head);
	cout<<endl;
	head = deleteKth(head, 3);
	print(head);
	return 0;
}





















