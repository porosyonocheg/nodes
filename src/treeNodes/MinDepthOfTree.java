package treeNodes;

/**Поиск минимальной глубины дерева (количества узлов до самого близкого к корню листа)
 * @author Сергей Шершавин*/

public class MinDepthOfTree extends Command{
    int minDepth = Integer.MAX_VALUE;
    public MinDepthOfTree(TreeNode root) {
        super(root);
    }

    /**Вспомогательный метод поиска минимальной глубины дерева*/
    private void searchMinDepth(TreeNode node, int currentDepth) {
        currentDepth++;
        if (node.left == null && node.right == null) {
            minDepth = Math.min(currentDepth, minDepth);
            return;
        }
        if (currentDepth >= minDepth) return;
        if (node.left != null) searchMinDepth(node.left, currentDepth);
        if (node.right != null) searchMinDepth(node.right, currentDepth);
    }

    @Override
    protected Object execute() {
        if (root == null) return 0;
        searchMinDepth(root, 0);
        return minDepth;
    }
}
