package treeNodes;

/**Построение зеркального отображения дерева относительно воображаемой вертикальной оси, проходящей через корень
 * @author Сергей Шершавин*/

public class InvertTree extends Command {

    public InvertTree(TreeNode root) {
        super(root);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    @Override
    public Object execute() {
        return invertTree(root);
    }
}
