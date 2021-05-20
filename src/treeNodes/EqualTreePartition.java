package treeNodes;

/** Определяет возможно ли разбить дерево на два поддерева с равными суммами занчений узлов
 * @author Сергей Шершавин*/

public class EqualTreePartition extends Command {
    private boolean equal;

    public EqualTreePartition(TreeNode root) {
        super(root);
        equal = false;
    }

    @Override
    public Object execute() {
        long[] sum = new long[]{getSum(root)};
        checkEqualTree(root, sum);
        return equal;
    }

    private long checkEqualTree(TreeNode node, long[] sum) {
        if (node == null || equal) return 0;
        long currentSum = checkEqualTree(node.left, sum) + checkEqualTree(node.right, sum) + node.val;
        if (sum[0] == currentSum << 1) {
            equal = true;
            return 0;
        }
        return currentSum;
    }

    private long getSum(TreeNode node) {
            if (node == null) return 0;
            return getSum(node.left) + getSum(node.right) + node.val;
    }
}
