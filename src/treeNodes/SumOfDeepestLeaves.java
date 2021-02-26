package treeNodes;

/** Вычисляет сумму всех листьев дерева, находящихся на максимальной глубине от корня.
 * @author Сергей Шершавин*/

public class SumOfDeepestLeaves extends Command {
    private int maxDepth;
    private int sum = 0;

    public SumOfDeepestLeaves(TreeNode root) {
        super(root);
    }

    private void sumOfDeepestLeaves(TreeNode node, int depth) {
        if (node == null) return;

        if (depth > maxDepth) {
            sum = 0;
            maxDepth = depth;
        }

        if (depth == maxDepth) sum += node.val;
        if (node.left != null) sumOfDeepestLeaves(node.left, depth+1);
        if (node.right != null) sumOfDeepestLeaves(node.right, depth+1);
    }

    @Override
    public Object execute() {
        sumOfDeepestLeaves(root, 0);
        return sum;
    }
}
