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

int lengthOfLL(Node* head){
	int cnt = 0;
	Node* temp = head;
	while(temp){
		temp = temp->next;
		cnt++;
	}
	return cnt;
}

Node* deleteKth(Node* head, int k){
	if (head==NULL) return head;
	int length = lengthOfLL(head);
	if (length < k) {
		cout << "Enter a valid index, There are only "<< length <<" elements in the LinkedList.";
		exit(1);
	}
	if(k==1){
		Node* temp = head;
		head = head->next;
		free(temp);
		return head;
	}
	int cnt = 0;
	Node* temp = head;
	Node* prev = NULL;
	
	while(temp != NULL){
		cnt = cnt + 1;
		if(cnt == k){
			prev->next = prev->next->next;
			free(temp);
			break;
		}
		prev = temp;
		temp = temp->next;
	}
	return head;
}	

int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* head = convertArr2LL(arr);
	cout << "Original LinkedList: ";
	print(head);
	int choice;
	cout<<"Enter an index to delete : ";
	cin>>choice;
	head = deleteKth(head, choice);
	cout<<"\nAfter Removing "<<choice<<"th"<<" element: ";
	print(head);
}




















