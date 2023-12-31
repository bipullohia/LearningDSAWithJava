package com.bipul;

import com.bipul.algorithms.HuffmanCoder;
import com.bipul.algorithms.SqrtDecomposition;
import com.bipul.datastructures.trees.questions.BFS;
import com.bipul.datastructures.trees.questions.DFS;

public class Main {

    public static void main(String[] args) throws Exception {

        BFS dfs = new BFS();
        dfs.createSimpleSampleTree();
        dfs.display();

        dfs.printVerticalTree();
    }
}
