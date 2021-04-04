package treeNodes;

/** Возвращает сумму отклонений дерева. Отклонение для каждого узла равно абсолютной разнице значений его левого и
 * правого поддеревьев.
 * @author Сергей Шершавин*/

public class BinaryTreeTilt extends Command {
    private int sum;
    public BinaryTreeTilt(TreeNode root) {
        super(root);
        sum = 0;
    }

    private int postOrderTraversal(TreeNode node) {
        if (node == null) return 0;
        int left = postOrderTraversal(node.left);
        int right = postOrderTraversal(node.right);
        sum += Math.abs(left - right);
        return left + right + node.val;
    }

    @Override
    public Object execute() {
        postOrderTraversal(root);
        return sum;
    }
}
