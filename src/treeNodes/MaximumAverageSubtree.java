package treeNodes;

/** Возвращает максимальное среднее значение узлов среди всех поддеревьев данного бинарного дерева
 * @author Сергей Шершавин*/

public class MaximumAverageSubtree extends Command {
    public MaximumAverageSubtree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        double[] maxAvg = new double[1];
        postOrderTraversal(root, maxAvg);
        return maxAvg[0];
    }

/** data[0] хранит сумму значений узлов данного поддерева, data[1] хранит количество узлов данного поддерева*/
    private int[] postOrderTraversal(TreeNode node, double[] maxAvg) {
        int[] data = new int[2];
        if (node == null) return data;
        int[] leftData = postOrderTraversal(node.left, maxAvg);
        int[] rightData = postOrderTraversal(node.right, maxAvg);
        data[0] = node.val + leftData[0] + rightData[0];
        data[1] = 1 + leftData[1] + rightData[1];
        double avg = data[0]*1.0 / data[1];
        maxAvg[0] = Math.max(avg, maxAvg[0]);
        return data;
    }
}
