package treeNodes;

/**Объединяет два дерева в одно, суммируя значения соответствующих совпадающих узлов
 * @author Сергей Шершавин*/

public class MergeTwoBinaryTrees extends Command {
    private final TreeNode target;

    public MergeTwoBinaryTrees(TreeNode root, TreeNode target) {
        super(root);
        this.target = target;
    }

    private TreeNode mergeTrees(TreeNode root, TreeNode target) {
        if (root == null && target == null) return null;
        if (root == null) return target;
        if (target == null) return root;

        root.val += target.val;
        root.left = mergeTrees(root.left, target.left);
        root.right = mergeTrees(root.right, target.right);
        return root;
    }

    @Override
    public Object execute() {
        return mergeTrees(root, target);
    }
}
