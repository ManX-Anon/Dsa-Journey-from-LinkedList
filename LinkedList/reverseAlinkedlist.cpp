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

Node* reverseLinkedList(Node* head){
    if (head == nullptr) return head;
    stack<int> st;
    Node* temp = head;
    while (temp != nullptr) {
        st.push(temp->data);
        temp = temp->next;
    }
    temp = head;
    while (temp != nullptr) {
        temp->data = st.top();
        st.pop();
        temp = temp->next;
    }
    return head;
}

void print(Node* head){
    if (head == nullptr) exit(1);
    Node* temp = head;
    while(temp != nullptr){
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}



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

int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* head = convertArr2LL(arr);
	print(head);
	reverseLinkedList(head);
	print(head);
}




















