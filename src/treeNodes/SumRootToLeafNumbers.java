package treeNodes;

/** Подсчёт суммы чисел, образованных путём от корня до листьев дерева. Например для следующего пути 1 -> 2 -> 3
 * число 123. Значения узлов дерева должны быть в диапазоне от 0 до 9.
 * @author Сергей Шершавин*/

public class SumRootToLeafNumbers extends Command {
    public SumRootToLeafNumbers(TreeNode root) {
        super(root);
    }

    private int traversalTree(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        int leftSum = traversalTree(node.left, currentSum);
        int rightSum = traversalTree(node.right, currentSum);
        return leftSum + rightSum;
    }

    @Override
    public Object execute() {
        return traversalTree(root, 0);
    }
}
