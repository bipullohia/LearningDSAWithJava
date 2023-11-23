package com.bipul.datastructures.linkedlist.questions;

public class SinglyLinkedList {

    private Node head;
    private int size;
    private Node tail;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void reverse(SinglyLinkedList sll, String reverseType, int left, int right){
        if(reverseType.equalsIgnoreCase("recursiveWithTail")){
            recursiveReversalWithTail(this.head);
        }else if(reverseType.equalsIgnoreCase("recursiveWithoutTail")){
            Node tail = recursiveReversalWithoutTail(this.head);
            System.out.println("Tail value: " + tail.value);
        }else if(reverseType.equalsIgnoreCase("recursiveIteration")){
            reverseIteration(this.head);
        }else if(reverseType.equalsIgnoreCase("reverseItrLimits")){
            reverseIteration(this.head, left, right);
        }
    }

    private void reverseIteration(Node node){
        if(node == null) return; //node here refers to head

        Node prev = null;
        Node current = node;
        Node next = current.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null)
                next = next.next;
        }
        this.head = prev; //since current is null, prev will be the last element
    }

    private void reverseIteration(Node node, int left, int right){
        if(node == null || left == right) return; //node here refers to head

        Node leftMinus1 = null; //just before sublist start. Caution: This can be head too
        Node newEnd = null; //start of the new Sublist from left side (becomes end in new reversed list)
        Node newStart = null; //taken for clarity of understanding
        Node rightPlus1 = null; //taken for clarity of understanding

        Node prev = null;
        Node current = node;
        Node next = current.next;
        int position = 1; //position corresponds to current node

        while(current != null){

            //skipping the first n-1 nodes - WE CAN USE FOR LOOP (and avoid the above while loop by giving that as condition too in for loop)
            if(position < left){
                position++;
                prev = current;
                current = next;
                if(next != null)
                    next = next.next;
                continue;
            }

            if(position == left){
                leftMinus1 = prev; //this denotes the end of untouched LL (from where the inverted list will join once complete)
                newEnd = current;
                prev = null;
            }

            //reverse the sublist (can use for loop here by using current != null and left/right int variables for conditions)
            if(position <= right){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null)
                    next = next.next;
                position++;
                continue;
            }

            //these two needn't be assigned to a new variable. Done here for clarity
            rightPlus1 = current;
            newStart = prev;
            break;
        }

        if(leftMinus1 != null){
            //this means that the linked list reverse left position is given as 1
            leftMinus1.next = newStart;
        }else{
            this.head = newStart;
        }
        newEnd.next = rightPlus1;

        //Things can get a lot simpler if we use for loop instead of while in above implementation
    }

    //assuming we have a tail given in the structure
    private void recursiveReversalWithTail(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        //we want to traverse till the end of the list
        recursiveReversalWithTail(node.next);

        //while returning we want to perform these actions (reversing the links of the node)
        tail.next = node; //this node will be of 1 element before tail
        tail = node; //we move tail by 1 place earlier
        tail.next = null; //this line is important for the new tail in the end (since if we don't write this - the tail will never point to null and it becomes a cyclic LL)
    }

    //assuming we don't have a tail given in the structure
    private Node recursiveReversalWithoutTail(Node node){
        Node prev; //this is to maintain a previous node while coming back (tail node does this job if present)
        if(node.next == null){
            head = node;
            return head;
        }

        //we want to traverse till the end of the list
        prev = recursiveReversalWithoutTail(node.next);

        //while returning we want to perform these actions (reversing the links of the node)
        prev.next = node; //this node will be of 1 element before prev
        prev = node; //we move prev by 1 place earlier
        prev.next = null; //this line is important for the new tail in the end (since if we don't write this - the tail (prev here) will never point to null and it becomes a cyclic LL)
        return prev; //this will act like a tail in a way
    }

    public void sort(SinglyLinkedList sll, String sortType){
        if(sortType.equalsIgnoreCase("merge"))
            sll.head = mergeSort(sll.head);
        else if(sortType.equalsIgnoreCase("bubbleItr"))
            sll.head = bubbleSortIterative(sll.head);
        else if(sortType.equalsIgnoreCase("bubbleRecr")){
            int length = lengthOfLL(head); //very inefficient- better to have a size maintained
            System.out.println("Length of LL: " + length);
            bubbleSortRecursive(length-1, 0);
        }
        else
            System.out.println("Wrong sortType given. Possible options: 'merge', 'bubble'");
    }

    public void bubbleSortRecursive(int row, int col){
        if(row == 0) return; //base condition

        if(row > col){
            Node first = getNode(col);
            Node second = getNode(col+1);

            if(first.value > second.value){
                //swap - 3 conditions

                //if it's start of the list (first 2 elements)
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail){ //if it's end of the list (last 2 elements)
                    Node prev = getNode(col-1);
                    prev.next = first.next;
                    second.next = first;
                    first.next = null;
                    tail = first;
                }
                else{ //if it's midway
                    Node prev = getNode(col-1);
                    prev.next = first.next;
                    first.next = second.next;
                    second.next = first;
                }
            }
            //calling recursively to exxecute other cols of this iteration (row)
            bubbleSortRecursive(row, col+1);
        }else{
            //the iteration for the row is done, moving on to the next iteration
            bubbleSortRecursive(row-1, 0);
        }
    }

    //not to be exposed
    private Node getNode(int index){
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //retry again after few days
    private Node bubbleSortIterative(Node head){
        if(head == null || head.next == null) return head; //0 or 1 elements - already sorted

        int length = lengthOfLL(head); //very inefficient- this step - unless we maintain a size
        System.out.println("Length of LL: " + length);

        for (int i = 0; i < length-1; i++) {
            Node current = head;
            Node prev = null;
            while(current != null && current.next != null){
                if(current.value > current.next.value){
                    //swap the nodes
                    if(prev != null)
                        prev.next = current.next;
                    else
                        head = current.next;

                    prev = current.next;
                    current.next = current.next.next;
                    prev.next = current;
                }else{
                    prev = current;
                    current = current.next;
                }
            }
        }
        display(head);
        return head;
    }

    private int lengthOfLL(Node head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    private void display(Node head){
        while(head != null){
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("END\n");
    }

    private Node mergeSort(Node head){
        if(head == null || head.next == null) return head; //base case - 0 or 1 elements - already sorted

        Node mid = getMid(head);
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

    private Node getMid(Node head){
        Node prevMid = null;
        while(head != null && head.next != null){
            prevMid = (prevMid == null) ? head : prevMid.next; //this will put prevMid as head after first while check/iteration. As slow pointer this would be an element ahead. Hence prevMid (since it's one pointer before) - it will point to 1 element before mid
            head = head.next.next;
        }
        Node mid = prevMid.next; //if there is one element in the list, only then prevMid will remain null - that won't happen since calling func is check in this case
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

    //write a demo LL with a tail
    public SinglyLinkedList getListWithTail(){
        this.head = new Node(12);
        this.head.next = new Node(14);
        this.head.next.next = new Node(16);
        this.head.next.next.next = new Node(18);
        this.head.next.next.next.next = new Node(20);
        this.head.next.next.next.next.next = new Node(22);

        this.tail = this.head.next.next.next.next.next;
        this.size = 6;
        display(this.head);
        return this;
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
