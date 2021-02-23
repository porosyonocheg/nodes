package treeNodes;

/**Определяет является ли дерево симметричным (содержит одинаковые значения в узлах, симметрично расположенных
 * относительно воображаемый оси, проходящей через корень)
 * @author Сергей Шершавин*/

public class SymmetricTree extends Command{
    public SymmetricTree(TreeNode root) {
        super(root);
    }

    private boolean isSymmetric(TreeNode tn1, TreeNode tn2) {
        if (tn1 == null && tn2 == null) return true;
        if (tn1 == null || tn2 == null) return false;
        if (tn1.val != tn2.val) return false;
        return isSymmetric(tn1.left, tn2.right) && isSymmetric(tn1.right, tn2.left);
    }

    @Override
    protected Object execute() {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
}
