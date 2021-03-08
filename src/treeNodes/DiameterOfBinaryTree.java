package treeNodes;

/** Возвращает максимальную длину пути от одного узла дерева до другого
 * @author Сергей Шершавин*/

public class DiameterOfBinaryTree extends Command {
    public DiameterOfBinaryTree(TreeNode root) {
        super(root);
    }

    private int diameterOfBinaryTree(TreeNode node, int[] maxLength) {
        if (node == null) return 0;
        int leftMax = diameterOfBinaryTree(node.left, maxLength);
        int rightMax = diameterOfBinaryTree(node.right, maxLength);
        maxLength[0] = Math.max(maxLength[0], leftMax + rightMax);
        return 1 + Math.max(rightMax, leftMax);
    }

    /**maxLength - искомая длина передаётся в рекурсивный виде массива с целью работы с ней по ссылке на объект*/
    @Override
    public Object execute() {
        int[] maxLength = new int[1];
        diameterOfBinaryTree(root, maxLength);
        return maxLength[0];
    }
}
