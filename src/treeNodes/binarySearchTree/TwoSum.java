package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Определяет содержатся ли в каждом из двух бинарных деревьев поиска по узлу, сумма значений которых равна target
 * @author Сергей Шершавин*/

public class TwoSum extends Command {
    private final TreeNode root2;
    private final int target;
    public TwoSum(TreeNode root1, TreeNode root2, int target) {
        super(root1);
        this.root2 = root2;
        this.target = target;
    }

    @Override
    public Object execute() {
        return twoSumBST(root, root2);
    }

    private boolean twoSumBST(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (isTarget(root2, target - root1.val)) return true;
        return twoSumBST(root1.left, root2) || twoSumBST(root1.right, root2);
    }

    private boolean isTarget(TreeNode root, int value) {
        if (root == null) return false;
        if (root.val == value) {
            return true;
        }

        if (root.val < value) return isTarget(root.right, value);
        else return isTarget(root.left, value);
    }
}
