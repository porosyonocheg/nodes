package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/**Восстанавливает бинарное дерево поиска, в котором одна пара узлов ошибочно была поменяна местами.
 * @author Сергей Шершавин*/

public class RecoverBST extends Command {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode previous = null;

    public RecoverBST(TreeNode root) {
        super(root);
    }

    /***/
    private void recoverBST(TreeNode node) {
        if (node == null) return;
        recoverBST(node.left);

        if (first == null && (previous == null || previous.val >= node.val)) {
            first = previous;
        }

        if (first != null && previous.val >= node.val) {
            second = node;
        }

        previous = node;
        recoverBST(node.right);
    }

    @Override
    public Object execute() {
        recoverBST(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return root;
    }
}