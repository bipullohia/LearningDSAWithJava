package com.bipul.datastructures.linkedlist.questions;

public class SinglyLinkedList {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void sortByMergeSort(SinglyLinkedList sll){
        sll.head = mergeSort(sll.head);
    }

    private Node mergeSort(Node head){
        if(head == null || head.next == null) return head; //base case - 0 or 1 elements - already sorted

        Node mid = getMiddleNodeOfLinkedList(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return mergeTwoSortedLinkedLists(left, right);
    }

    //merges two sorted LL and returns the Node of the new LL- takes head of two LL as args
    private Node mergeTwoSortedLinkedLists(Node head1, Node head2){
        Node mergedHead = new Node(); //head of the new list
        Node temp = mergedHead; //to iterate over the new list
        while(head1 != null && head2 != null){
            if(head1.value <= head2.value){
                //element from list1 gets added
                temp.value = head1.value;
                head1 = head1.next;
            }else{
                //element from list2 gets added
                temp.value = head2.value;
                head2 = head2.next;
            }
            //adding new nodes to temp
            temp.next = new Node();
            temp = temp.next;
        }

        if(head1 != null){
            temp.value = head1.value;
            temp.next = head1.next;
        }

        if(head2 != null){
            temp.value = head2.value;
            temp.next = head2.next;
        }

        return mergedHead;
    }

    //returns the middle node of a LinkedList
    private Node getMiddleNodeOfLinkedList(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node node = slow.next; //returning the one after middle and using the middle node to break the chain
        slow.next = null;
        return node;
    }

    private Node getMid(Node head){
        Node prevMid = null;
        while(head != null && head.next != null){
            prevMid = (prevMid == null) ? head : prevMid.next;
            head = head.next.next;
        }
        Node mid = prevMid.next;
        prevMid.next = null;
        return mid;
    }

    public int getFirst(){
        if(this.head == null){
            System.out.println("Null head - means there is no elements present in the LinkedList!");
            return Integer.MIN_VALUE; //returning a vague value
        }
        else
            return this.head.value;
    }

    public void insertRecursive(int index, int value){
        head = insertNodeRecursive(index, value, head);
    }

    //finds out if a number is happy number - the chain concept is used but it's not really nneded to be solved via LL
    public boolean isHappyNumber(int num){
        int fast = num;
        int slow = num;

        do{
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        }while(fast != slow);

        //the execution reaches here only if both fast and slow have met
        if(slow == 1) //if they are at 1, that means its happy number
            return true;

        return false;
    }

    private int sumOfSquareOfDigits(int num){
        int sqr = 0;
        while(num > 0){
            int digit = num%10;
            sqr += digit*digit;
            num = num/10;
        }
        return sqr;
    }

    //returns the middle value
    public int middleOfLinkedList(SinglyLinkedList sll){
        Node fast = sll.head;
        Node slow = sll.head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //when the execution reaches here, it means that the fast node has reached the end, and hence slow is moving at half the rate, it will be in the middle
        return slow.value;
    }

    private Node insertNodeRecursive(int index, int value, Node currNode){
        if(index == 0){
            //reached at the desired position, create a new node
            Node temp = new Node(value, currNode);
            size++;
            return temp;
        }

        currNode.next = insertNodeRecursive(--index, value, currNode.next);
        return currNode;
    }

    //this is assuming that the linkedlist is sorted
    public void removeDuplicates(){
        if(head == null || head.next == null) {
            //these mean that the list has 0 or 1 item - already sorted
            System.out.println("Already sorted!");
            return;
        }

        Node temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                //delete the temp.next node
                temp.next = temp.next.next;
                size--;
            }else{
                temp = temp.next;
            }
        }
    }

    //finds if the cycle is present in the LinkedList - it will take the head of the object it is called on
    public boolean isCyclePresent(){
        Node head = this.head; //this head variable refers to the local head - the scope is this function
        Node fastPointer = head; //fast pointer has to move 2 steps at a time
        Node slowPointer = head; //slow pointer moves 1 step at a time

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next; //moving by 2 steps
            slowPointer = slowPointer.next; //moving by 1 step

            if(fastPointer == slowPointer){
                return true; //both pointers meet - means there is a cycle present
            }
        }

        //if execution reaches here, it means the list is finished for one of the pointer, no cycle found
        return false;
    }

    //returns cycle length if a cycle is present in the LL, else returns 0
    public int cycleLength(){
        Node head = this.head; //this head variable refers to the local head - the scope is this function
        Node fastPointer = head; //fast pointer has to move 2 steps at a time
        Node slowPointer = head; //slow pointer moves 1 step at a time
        int count = 0;

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next; //moving by 2 steps
            slowPointer = slowPointer.next; //moving by 1 step

            if(fastPointer == slowPointer){ //both pointers meet - means there is a cycle present
                //finding the length of cycle. Keeping fast constant, moving slow to reach fast again
                do{
                    slowPointer = slowPointer.next;
                    count++;
                } while(slowPointer != fastPointer);
                return count;
            }
        }

        //if execution reaches here, it means the list is finished for one of the pointer, no cycle found
        return count;
    }

    //merges two sorted linkedlist
    public SinglyLinkedList mergeTwoSortedLinkedLists(SinglyLinkedList ll1, SinglyLinkedList ll2){
        Node head1 = ll1.head;
        Node head2 = ll2.head;

        if(head1 == null) return ll2;
        if(head2 == null) return ll1;

        //head is the head of the new list we will return
        SinglyLinkedList ans = new SinglyLinkedList();
        Node mergedHead = new Node();
        Node temp = mergedHead; //to iterate over the new list
        while(head1 != null && head2 != null){
            if(head1.value <= head2.value){
                //element from list1 gets added
                temp.value = head1.value;
                head1 = head1.next;
            }else{
                //element from list2 gets added
                temp.value = head2.value;
                head2 = head2.next;
            }
            //adding new nodes to temp
            temp.next = new Node();
            temp = temp.next;
        }

        if(head1 != null){
            temp.value = head1.value;
            temp.next = head1.next;
        }

        if(head2 != null){
            temp.value = head2.value;
            temp.next = head2.next;
        }

        ans.head = mergedHead;
        return ans;
    }


    //creating a new singly linked list with a cycle (for testing)
    public SinglyLinkedList getSLLWithCycle(){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new Node(11);
        sll.head.next = new Node(22);
        sll.head.next.next = new Node(33);
        sll.head.next.next.next = new Node(44);
        sll.head.next.next.next.next = new Node(55);
        sll.head.next.next.next.next.next = new Node(66);
        sll.head.next.next.next.next.next.next = new Node(77);
        sll.head.next.next.next.next.next.next.next = new Node(88);
        sll.head.next.next.next.next.next.next.next.next = sll.head.next.next;
        sll.size = 5;
        return sll;
    }

    //The Node class containing the structure of each node
    private class Node{
        private int value;
        private Node next;

        public Node(){
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = this.head;
        while(temp != null){ //this will throw out of space error for linkedlist with cycle
            sb.append(temp.value);
            temp = temp.next;
            if(temp != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //it will print the first n elements of a linkedList - helpful in LLs with cycle
    public String display(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("[First ").append(n).append(" values: ");
        Node temp = this.head;
        for (int i = 0; i < n; i++) {
            if(temp != null){
                sb.append(temp.value).append(" -> ");
                temp = temp.next;
            }
        }
        sb.append("END");
        sb.append("]");
        return sb.toString();
    }
}
