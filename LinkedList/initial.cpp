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

int main(){
	vector<int> arr = {4,5,6,2,6};
	Node* y = new Node(arr[2]);
	cout<<y->data;
}
