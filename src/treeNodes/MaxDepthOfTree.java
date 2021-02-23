package treeNodes;

/**Поиск максимальной глубины дерева (количества узлов до самого дальнего от корня листа)
 * @author Сергей Шершавин*/

public class MaxDepthOfTree extends Command {
    public MaxDepthOfTree(TreeNode root) {
        super(root);
    }

    @Override
    protected Object execute() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightMaxDepth = maxDepth(root.right);
        int leftMaxDepth = maxDepth(root.left);
        return rightMaxDepth > leftMaxDepth ? rightMaxDepth + 1 : leftMaxDepth + 1;
    }
}
