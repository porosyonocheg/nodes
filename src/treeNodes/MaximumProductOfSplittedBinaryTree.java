package treeNodes;

/**Поиск максимального произведения сумм значений узлов двух поддеревьев, которые могут быть получены при разбиении
 * переданного дерева. Значения узлов должны быть положительны. Так как результат может быть существенно большим, он
 * представлен по модулю 10^9 + 7
 * @author Сергей Шершавин*/

public class MaximumProductOfSplittedBinaryTree extends Command {
    private long maxProduct;
    public MaximumProductOfSplittedBinaryTree(TreeNode root) {
        super(root);
        maxProduct = 0;
    }

    private long getTotalSum(TreeNode root) {
        if (root == null) return 0L;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    private long getMaxProduct(TreeNode root, long totalSum) {
        if (root == null) return 0L;
        long left = getMaxProduct(root.left, totalSum);
        long right = getMaxProduct(root.right, totalSum);
        long currentSum = left + right + root.val; //сумма для текущего поддерева
        long currentProduct = currentSum * (totalSum - currentSum); //произведение для текущего "разбиения"
        if (currentProduct > maxProduct) maxProduct = currentProduct;
        return currentSum;
    }

    @Override
    public Object execute() {
        long totalSum = getTotalSum(root); // получим сумму всех узлов дерева
        getMaxProduct(root, totalSum);
        return (int) (maxProduct%(1e9+7));
    }
}
