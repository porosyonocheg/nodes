package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Вставляет новый узел с заданным значением в бинарное дерево поиска.
 * Значение нового узла должно быть уникальным для данного дерева.
 * @author Сергей Шершавин*/

public class InsertNewNode extends Command {
    private int value;
    public InsertNewNode(TreeNode root, int value) {
        super(root);
        this.value = value;
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            if (root.left != null) insertNewNode(root.left, val);
            else root.left = new TreeNode(val);
        }
        else {
            if (root.right != null) insertNewNode(root.right, val);
            else root.right = new TreeNode(val);
        }
        return root;
    }

    private void insertNewNode(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left != null) insertNewNode(node.left, val);
            if (node.left == null) node.left = new TreeNode(val);
        }
        else {
            if (node.right != null) insertNewNode(node.right, val);
            if (node.right == null) node.right = new TreeNode(val);
        }
    }

    @Override
    public Object execute() {
        return insertIntoBST(root, value);
    }
}
