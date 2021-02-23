package treeNodes;

import java.util.LinkedList;

/**Определяет является ли второй параметр, переданный в конструктор, поддеревом  первого параметра,
 * переданного в конструктор.
 * @author Сергей Шершавин*/

public class SubtreeOfAnotherTree extends Command {
    private TreeNode target;

    public SubtreeOfAnotherTree(TreeNode root, TreeNode target) {
        super(root);
        this.target = target;
    }

    private boolean isEqualsNodes(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null  || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isEqualsNodes(node1.left, node2.left) && isEqualsNodes(node1.right, node2.right);
    }

    @Override
    protected Object execute() {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isEqualsNodes(node, target)) return true;
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }
        return false;
    }
}
