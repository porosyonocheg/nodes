package treeNodes;

/**Поиск максимальной глубины дерева (количества узлов до самого дальнего от корня листа)
 * @author Сергей Шершавин*/

public class MaxDepthOfTree extends Command {
    public MaxDepthOfTree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
