#include <bits/stdc++.h>
#include <stack>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node* prev;
    Node(int val) : data(val), next(nullptr), prev(nullptr) {}
};

void reverseUsingStack(Node* head) {
    if (head == nullptr) return;

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
}

void printList(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

int main() {
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->prev = head;
    head->next->next = new Node(3);
    head->next->next->prev = head->next;
    head->next->next->next = new Node(4);
    head->next->next->next->prev = head->next->next;

    cout << "Original: ";
    printList(head);

    reverseUsingStack(head);

    cout << "Reversed: ";
    printList(head);

    return 0;
}
