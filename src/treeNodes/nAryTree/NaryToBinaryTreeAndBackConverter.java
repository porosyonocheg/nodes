package treeNodes.nAryTree;

import treeNodes.TreeNode;

/** Конвертер n-арного дерева в бинарное и обратно
 * @author Сергей Шершавин*/

public class NaryToBinaryTreeAndBackConverter {

    /**Преобразует n-арное дерево в бинарное*/
    public static TreeNode toBinaryTree(NaryTree root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        if (root.children.isEmpty()) return node;
        node.left = toBinaryTree(root.children.get(0));
        TreeNode current = node.left;
        for (int i = 1; i < root.children.size(); i++) {
                current.right = toBinaryTree(root.children.get(i));
                current = current.right;
        }
        return node;
    }

    /**Преобразует бинарное дерево в n-арное*/
    public static NaryTree toNaryTree(TreeNode root) {
        if (root == null) return null;
        NaryTree node = new NaryTree(root.val);
        TreeNode current = root.left;
        while (current != null) {
            node.children.add(toNaryTree(current));
            current = current.right;
        }
        return node;
    }
}
