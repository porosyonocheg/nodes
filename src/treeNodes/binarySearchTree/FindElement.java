package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Поиск узла в бинарном дереве поиска по значению. За корректность входных данных отвечает клиентская сторона.
 * @author Сергей Шершавин*/

public class FindElement extends Command {
    private final int target;

    public FindElement(TreeNode root, int target) {
        super(root);
        this.target = target;
    }

    private TreeNode searchBST(TreeNode root) {
        if (root == null) return null;
        if (root.val == target) return root;
        if (root.val > target) return searchBST(root.left);
        return searchBST(root.right);
    }

    @Override
    public Object execute() {
        return searchBST(root);
    }
}
