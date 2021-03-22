package treeNodes.binarySearchTree;

import treeNodes.TreeNode;

/** Конструирует бинарное дерево поиска из массива соответствующего preorder-обходу.
 * @author  Сергей Шершавин*/

public class ConstructTreeFromPreorder {
    private final int[] preorder;

    public ConstructTreeFromPreorder(int[] preorder) {
        this.preorder = preorder;
    }

    public Object execute() {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            new InsertNewNode(root, preorder[i]).execute();
        }
        return root;
    }
}
