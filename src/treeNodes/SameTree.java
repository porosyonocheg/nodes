package treeNodes;

/**Определяет являются ли два дерева идентичными (по наличию и значению соответствующих узлов)
 * @author  Сергей Шершавин*/

public class SameTree extends Command {
    private TreeNode target;

    public SameTree(TreeNode root, TreeNode target) {
        super(root);
        this.target = target;
    }
    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) return true;
        if ((first != null && second == null) || (first == null && second != null)) return false;
        if (first.val != second.val) return false;
        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }

    @Override
    Object execute() {
        return isSameTree(root, target);
    }
}
