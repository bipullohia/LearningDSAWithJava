package com.bipul.datastructures.trees.questions;

import com.bipul.datastructures.trees.implementation.BinaryTree;

import java.util.*;

public class BFS extends BinaryTree {
    public BFS(){}

    //prints the node values level-wise
    public void bfSearch(){
        Queue<Node> queuedNodes = new LinkedList<>();
        queuedNodes.add(super.root);
        bfSearch(queuedNodes);
    }

    private void bfSearch(Queue<Node> queue){
       if(queue.isEmpty()) return;

       Node current = queue.poll();
       System.out.print(current.value + " "); //print the current node value

        //add the node's children to the queue (if present)
        if(current.left != null)
           queue.add(current.left);
        if(current.right != null)
            queue.add(current.right);

        bfSearch(queue);
    }

    //cousins means both x and y should be at the same level but not belong to different parents
    //assume all elements will be unique in the binary tree
    public boolean areCousins(int x, int y){
        if(this.root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        List<Node> parentLevelNodes = new ArrayList<>();
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Node> currentLevelNodes = new ArrayList<>();
            boolean xFound = false;
            boolean yFound = false;
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevelNodes.add(currentNode);
                if(currentNode.value == x){
                    xFound = true;
                }
                if(currentNode.value == y){
                    yFound = true;
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            //x and y were found at this same level
            if(xFound && yFound) return !areSameParents(x, y, parentLevelNodes); //they should not have same parents - so if same parents -> not cousins

            //this means only 1 element has been found at this level - not cousins
            if(xFound != yFound) return false;
            parentLevelNodes = currentLevelNodes;
        }
        return false;
    }

    public boolean areSameParents(int x, int y, List<Node> parentLevelNodes){
        for(Node n: parentLevelNodes){
            if(n != null && n.left != null && n.right != null){
                if((n.left.value == x && n.right.value == y) || (n.left.value == y && n.right.value == x))
                    return true; //same parents
            }
        }
        return false;
    }

    //returns List<List<Integer>> for the bfs result
    public List<List<Integer>> bfSearchResultList(){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size(); //at each level, the number of elements will be equal to current queue size (since we pop the elements of the parent level)
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevelList.add(currentNode.value);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelList);
        }
        return result;
    }

    public List<Float> avgOfLevels(){
        List<Float> result = new ArrayList<>();
        if(this.root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int sumOfLevel = 0;
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                sumOfLevel = sumOfLevel+currentNode.value;
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            float avg = (float) sumOfLevel /levelSize;
            result.add(avg);
        }
        return result;
    }

    public List<Integer> rightSideView(){
        List<Integer> result = new ArrayList<>();
        if(this.root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                //this means it is the last element at this level
                if(i == levelSize-1){
                    result.add(currentNode.value);
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    //given a number num, find it's level order successor (can go to next level if none in same level)
    public Integer levelOrderSuccessor(int num){
        if(this.root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
            //VERY IMP: We wait for populating the child of current nodes before returning so that if there are children present, we return that instead of null
            if(currentNode.value == num && !queue.isEmpty()){
                return queue.peek().value;
            }
        }
        return null;
    }

    public void zigzagLevelTraversal(){
        if(root == null) return;

        //we take a deque to be able to add elements at the front and back
        Deque<Node> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean reverse = true; //after root, the next level should be printed in the opposite direction

        while(!deque.isEmpty()){
            int levelSize = deque.size();

            //normal order -> remove from front, add at the back of the queue
            if(reverse){
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = deque.pollFirst();
                    System.out.print(currentNode.value + " "); //remove and print the element at the front
                    //add elements to the back of the queue
                    if(currentNode.left != null){
                        deque.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        deque.offerLast(currentNode.right);
                    }
                }
            }else{ //reverse order -> remove from the back, add to the front of the queue
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = deque.pollLast();
                    System.out.print(currentNode.value + " "); //remove and print the element at the back
                    //add elements to the front of the queue
                    if(currentNode.right != null){ //PS: don't forget to print right first here!
                        deque.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        deque.offerFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
        }
    }

    public boolean isSymmetric2(){
        if(root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null)
                continue;

            if(left == null || right == null)
                return false; //this means only 1 of them is null - hence not symmetric

            if(left.value != right.value)
                return false;

            //this sequence of adding child nodes is used to maintain symmetry
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    //checks if left half of the tree is a mirror image of the right half (better solution available)
    public boolean isSymmetric(){
        if(root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size(); //at each level, the number of elements will be equal to current queue size (since we pop the elements of the parent level)
            List<Node> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                System.out.println("Current Level Queue: " + queue); //for understanding
                Node currentNode = queue.poll();
                currentLevelNodes.add(currentNode);

                if(currentNode != null){
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }else{ //we also add the null nodes for comparison later on
                        queue.offer(null);
                    }
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }else{
                        queue.offer(null);
                    }
                }
            }

            //special case of root node
            if(currentLevelNodes.size() == 1 && currentLevelNodes.get(0) == root) continue;
            System.out.println("Current Level List: " + currentLevelNodes); //for understanding
            //check if nodes are symmetric at this level - return false if not!
            if(!symmetricLevel(currentLevelNodes)) return false;
        }
        return true;
    }

    private boolean symmetricLevel(List<Node> currentLevelNodes){
        int size = currentLevelNodes.size();

        //we have taken case of the root node case, and no other combination should be without pairs in symmetry
        if(size % 2 != 0) return false;
        for (int i = 0; i < (size/2); i++) {
            //null condition check
            if((currentLevelNodes.get(i) == null || currentLevelNodes.get(size-1-i) == null) && !(currentLevelNodes.get(i) == currentLevelNodes.get(size-1-i))){
                return false;
            }
            //if two nodes aren't equal from opposite ends, they are not symmetric
            if(!(currentLevelNodes.get(i).value == currentLevelNodes.get(size-1-i).value)){
                return false;
            }
        }
        return true;
    }

    public void createSymmetricTree(){
        this.root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.left.right = new Node(4);
        root.right.right.left = new Node(4);

    }

    public void createSymmetricTree2(){
        this.root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.right = new Node(8);
        root.right.right = new Node(8);
    }
}
