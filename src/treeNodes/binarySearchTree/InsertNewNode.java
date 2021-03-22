package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Вставляет новый узел с заданным значением в бинарное дерево поиска.
 * Значение нового узла должно быть уникальным для данного дерева.
 * @author Сергей Шершавин*/

public class InsertNewNode extends Command {
    private final int value;

    public InsertNewNode(TreeNode root, int value) {
        super(root);
        this.value = value;
    }

    private void insertNewNode(TreeNode node) {
        if (value < node.val) {
            if (node.left != null) insertNewNode(node.left);
            if (node.left == null) node.left = new TreeNode(value);
        }
        else {
            if (node.right != null) insertNewNode(node.right);
            if (node.right == null) node.right = new TreeNode(value);
        }
    }

    @Override
    public Object execute() {
        if (root == null) return new TreeNode(value);
        if (value < root.val) {
            if (root.left != null) insertNewNode(root.left);
            else root.left = new TreeNode(value);
        }
        else {
            if (root.right != null) insertNewNode(root.right);
            else root.right = new TreeNode(value);
        }
        return root;
    }
}
