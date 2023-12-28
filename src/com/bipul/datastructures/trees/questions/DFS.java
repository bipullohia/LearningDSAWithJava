package com.bipul.datastructures.trees.questions;

import com.bipul.datastructures.trees.implementation.BinaryTree;

import java.util.*;

public class DFS extends BinaryTree {

    public DFS(){}

    private int diameter = 0;

    //also known as max depth of tree
    public int getTreeHeight(){
        return getTreeHeight(super.root);
    }

    //longest distance between any 2 nodes in a tree
    public int getTreeDiameter(){
        getTreeDiameter(super.root);
        return diameter-1; //diameter refers to edges between the nodes here
    }

    private int getTreeDiameter(Node node){
        if(node == null) return 0;

        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);

        int currentDiameter = leftHeight+rightHeight+1;
        diameter = Math.max(diameter, currentDiameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int getTreeHeight(Node node){
        if(node == null) return 0;

        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void invertBinaryTree(){
        invertBinaryTreeBottomUp(super.root);
    }

    //this we have done top to bottom inversion, we can do the same from bottom up (below)
    //Time Complexity - O(n) since we visit every node once. Space - O(H) -> O(logn) since recursion stack height will be height of the tree (logn)
    private void invertBinaryTreeTopToBottom(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertBinaryTreeTopToBottom(node.left);
        invertBinaryTreeTopToBottom(node.right);
    }

    //this we have bottom-up inversion
    private void invertBinaryTreeBottomUp(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) return;

        invertBinaryTreeBottomUp(node.left);
        invertBinaryTreeBottomUp(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    //flatten binary tree into a linked list (with same root node) - using preorder traversal
    //Easy way with O(n) time and space - store in queue as you preorder, and form the tree from this queue
    //better approach - space O(1) - constant space and log(n) time
    public void flatten(){
        flatten(super.root);
    }

    //put the right-hand side subtree in the first 'right-most' null area of left subtree
    private void flatten(Node root){
        Node current = root;
        while(current != null){
            if(current.left != null){
                Node temp = current.left; //node with right node as null - this is where we will put current.right eventually
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    //check if the given binary tree is a Binary Search Tree - check for absolute confirmation!
    public boolean validateBST(){
        return validateBST(super.root, null, null);
    }

    //we maintain a low and high. While going left, low can be anything and high will be node.val,
    // and while going right low will be node.value and high whatever has been set before!
    //preorder traversal - try others next time..
    private boolean validateBST(Node node, Integer low, Integer high){
        if(node == null) return true;

        //checking for low - right should not be less than high
        if(low != null && node.value <= low){
            return false;
        }
        //checking for high - left should not be greater than high
        if(high != null && node.value >= high){
            return false;
        }

        return validateBST(node.left, low, node.value) && validateBST(node.right, node.value, high);
    }

    public Integer lowestCommonAncestor(int p, int q){
        Node pNode = findNode(super.root, p);
        Node qNode = findNode(super.root, q);

        System.out.println("P Node: value: " + pNode.value + ", left: " + pNode.left + ", right: " + pNode.right);
        System.out.println("Q Node: value: " + qNode.value + ", left: " + qNode.left + ", right: " + qNode.right);

        Node lowestCA = lowestCommonAncestor(super.root, pNode, qNode);
        return lowestCA.value;
    }

    private Node findNode(Node root, Integer n){
        if(root == null || n == null) return null;

        if(root.value == n) return root;
        Node node = findNode(root.left, n); //trying to find in the left subtree
        if(node == null){
            node = findNode(root.right, n);
        }
        return node;
    }

    //we try to answer closer to the root -> preorder
    //visiting every node so Time - O(n), Space - Stack itself will be O(logn) because of height of the tree
    private Node lowestCommonAncestor(Node node, Node p, Node q){
        if(node == null) return null;

        //if we find either node, we can ignore the rest of subtree and move on. This is because if the other node is in the
        //same subtree, we already have our ans, if it's in the other side - the node itself would be the ans
        if(node == p || node == q) return node;

        //otherwise, go down
        //finding lowest for left and right
        Node left = lowestCommonAncestor(node.left, p, q);
        Node right = lowestCommonAncestor(node.right, p, q);

        if(left != null && right != null){
            //both the sides have one of the nodes, so this node itself should be common ancestor
            return node;
        }

        //otherwise one of the subtree has both the nodes
        return (left == null) ? right: left;
    }

    public Integer kthSmallest(int k){
        return kthSmallest2(super.root, k).value;
    }

    int count = 0; //global counter
    private Integer kthSmallest(Node node, int k){
        Integer smallest;
        if(node == null) return null;

        //left traversal
        smallest = kthSmallest(node.left, k);
        count++;

        //current node
        if(count == k)
            return node.value;

        //right traversal (only if answer already hasn't been found)
        if(smallest == null)
            smallest = kthSmallest(node.right, k);

        return smallest;
    }

    //inorder traversal needed - simplified!
    private Node kthSmallest2(Node node, int k){
        if(node == null) return null;

        //left traversal
        Node left = kthSmallest2(node.left, k);

        if(left != null) return left; //answer has been found, don't bother with anything anymore!

        count++;

        //current node
        if(count == k)
            return node;

        //right traversal
        return kthSmallest2(node.right, k);
    }

    public void treeFromPreAndIn(int[] preArr, int[] inArr){
        super.root = buildTree(preArr, inArr);
    }

    //create a binary tree from 2 arrays of preorder traversal and inorder traversal
    private Node buildTree(int[] preArr, int[] inArr){
        if(preArr.length == 0 || inArr.length == 0) return null;

        //finding the root node from preorder (first element)
        Node node = new Node(preArr[0]);

        //finding the left and right portions of the above root from inorder
        int index = 0; //current root index
        for (int i = 0; i < inArr.length; i++) {
            if(node.value == inArr[i])
                index = i;
        }

        node.left = buildTree(Arrays.copyOfRange(preArr, 1, index+1), Arrays.copyOfRange(inArr, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preArr, index+1, preArr.length), Arrays.copyOfRange(inArr, index+1,inArr.length));

        return node;
    }

    public List<Integer> getSerializedTree(){
        return getSerializedTree(super.root);
    }

    //traverse preorder
    private List<Integer> getSerializedTree(Node node){
        List<Integer> result = new ArrayList<>();
        if(node == null){
            result.add(null); //we want to add nulls also to the final result for keeping the structure intact
            return result;
        }

        result.add(node.value);
        result.addAll(getSerializedTree(node.left));
        result.addAll(getSerializedTree(node.right));
        return result;
    }

    //form the binary tree from a given list of nodes
    public void deserializeTree(List<Integer> nodeList){

        //to not pick items from the front of linkedlist (it needs shifting -> takes more time)
        //better to pick from the end of the linkedlist (constant time), hence reverse
        Collections.reverse(nodeList);
        System.out.println("Reversed List: " + nodeList);

        super.root = deserialize(nodeList);
    }

    //IMPORTANT: form with postorder traversal
    //better to pick from the end of the linkedlist (constant time)
    private Node deserialize(List<Integer> nodeList) {

        //we don't need to check the condition where list becomes empty -> because the list has exact elements to complete proper stacking of traversal funcs

        Integer current = nodeList.remove(nodeList.size() - 1);
        //if this node is supposed to be null - no children would be present - go back
        if(current == null) return null;

        Node node = new Node(current);
        node.left = deserialize(nodeList);
        node.right = deserialize(nodeList);
        return node;
    }

    //returns true if there is a path from root to leaf in this tree where the sum equals the target sum
    public boolean pathSum(int targetSum){
        return pathSum(super.root, targetSum, 0);
    }

    private boolean pathSum(Node node, int targetSum, int currentSum){
        if(node == null) return false; //root node

        //adding the current node's value to the sum until now
        currentSum = currentSum + node.value;

        if(node.left == null && node.right == null){
            //reached leaf node, check if targetsum is reached
            return targetSum == currentSum; //we return false if in this path - the sum wasn't reached
        }

        //traverse left
        if(pathSum(node.left, targetSum, currentSum))
            return true;

        //traverse right
        return pathSum(node.right, targetSum, currentSum);
    }

    public long sumLeafToRootNums(){
        return sumLeafToRootNums(super.root, 0);
    }

    //num stores path of 1 root->leaf that is one complete number
    //Time complexity - O(n), Space can be O(n) if this is not a balanced tree since we have to go through all the nodes of a level
    private long sumLeafToRootNums(Node node, long num){
        if(node == null) { //root node case
            return 0;
        }

        num = (10*num) + node.value; //basic digit math
        if(node.left == null && node.right == null){ //no more child nodes, this is a complete number of the path -> return this number
            return num;
        }

        return sumLeafToRootNums(node.left, num) + sumLeafToRootNums(node.right, num); //check left and right children
    }

    //max sum between any two nodes (might not include root) - same as diameter - value instead of height here
    public int binaryTreeMaxPathSum(){
        maxPathSum(super.root);
        return maxSum; //we want this - not the int result of the func we called. This is max possible path
    }

    int maxSum = Integer.MIN_VALUE;
    //uses post order traversal, O(n) space and time complexity
    private int maxPathSum(Node node){
        if(node == null) return 0;

        int leftSum = maxPathSum(node.left);
        int rightSum = maxPathSum(node.right);

        //if left or right sum is negative - we take 0 instead of that negative since it'll reduce our overall ans
        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);

        //this is for max possible incase this ends up being the path with highest sum (will be used for final result) - global update
        maxSum = Math.max(maxSum, leftSum+rightSum+node.value);

        //this is max of 1 path possible to be taken by calling funcs (this won't be used in final result - just for calling functions)
        return Math.max(leftSum, rightSum) + node.value;
    }

    //given an array of numbers - find if that path exists in the tree!
    public boolean doesPathExistRootToLeaf(int[] arr){
        if(super.root == null){
            return arr.length == 0;
        }
        return doesPathExistRootToLeaf(super.root, arr, 0);
    }

    private boolean doesPathExistRootToLeaf(Node node, int[] arr, int index){
        if(index == arr.length-1) return true;
        if(node == null) return false;

        if(node.value == arr[index]){
            //the path continues
            return doesPathExistRootToLeaf(node.left, arr, index+1)
                    || doesPathExistRootToLeaf(node.right, arr, index+1);
        }else{
            return false;
        }
    }

    //tough ques - try again later!
    //number of paths possible in the tree (in any combination) which forms the sum given in the arg
    public int allPathSums(int sum){
        return allPathSums(super.root, sum);
    }

    //uses backtracking
    private int allPathSums(Node node, int sum){
        return 0;
    }
}
