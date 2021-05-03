package treeNodes;

/**Возвращает максимальную сумму значений узлов среди всех бинарных деревьев поиска, являющихся поддеревьями исходного
 * дерева. По умолчанию пустое дерево - БДП, а сумма его узлов = 0.*/

public class MaximumSumOfBinarySearchSubtree extends Command {
    private int maxSum;

    public MaximumSumOfBinarySearchSubtree(TreeNode root) {
        super(root);
        maxSum = 0;
    }
    /**Возвращаемый массив содержит {минимальное значение узла для данного поддерева, максимальное значение узла для
     * данного поддерева, сумму значений узлов для данного поддерева}*/
    private int[] maxSumBST(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = maxSumBST(node.left);
        int[] right = maxSumBST(node.right);
        if (left == null || right == null || node.val <= left[1] || node.val >= right[0]) return null; //если происходит
        // выход за пределы минимального и максимального элемента - поддерево не является BST, и содержащее его дерево тоже,
        // значит считать сумму не нужно, возвращаем null
        int sum = left[2] + right[2] + node.val;
        if (sum > maxSum) maxSum = sum;
        int min = Math.min(node.val, left[0]);
        int max = Math.max(node.val, right[1]);
        return new int[] {min, max, sum};
    }

    @Override
    public Object execute() {
        maxSumBST(root);
        return maxSum;
    }
}
