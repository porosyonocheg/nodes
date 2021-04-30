package treeNodes;

/** Возвращает максимальную сумму значений среди всех путей дерева. Путём считается совокупность узлов, каждая пара
 * которых имеет узел их соединяющий.
 * @author Сергей Шершавин*/

public class MaximumPathSum extends Command {
    private int maxSum;

    public MaximumPathSum(TreeNode root) {
        super(root);
        maxSum = Integer.MIN_VALUE;
    }

    /** left и right имеет смысл накапливать только в случае, если они положительны, тогда сумма будет возрастать*/
    private int maxPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathSum(node.left));
        int right = Math.max(0, maxPathSum(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    @Override
    public Object execute() {
        maxPathSum(root);
        return maxSum;
    }
}
