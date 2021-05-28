package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Находит следующий по величине значения узел после узла target, содержащийся в бинарном дереве поиска root.
 * @author Сергей Шершавин*/

public class InorderSuccessor extends Command {
    private final TreeNode target;

    public InorderSuccessor(TreeNode root, TreeNode target) {
        super(root);
        this.target = target;
    }

    /** Если правое поддерево target существует, то следующий по величине узел - самый левый потомок в этом поддереве,
     * в противном случае идём от корня, переписывая каждый раз значение узла, пока (если) оно превосходит значение target.
     * Дойдя до target возвращаем последнее записанное значение*/
    @Override
    public Object execute() {
        if (root == null || target == null) return null;
        if (target.right != null) return findLeftDescendant(target.right);
        TreeNode successor = null;
        while (root != null) {
            if (root.val == target.val) return successor;
            if (root.val > target.val) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return successor;
    }

    private TreeNode findLeftDescendant(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
