package treeNodes;

/** Находит ближайшего общего предка (узел) для двух переданных значений узлов в данном дереве.
 * Значения узлов данного дерева должны быть уникальны.
 * @author Сергей Шершавин*/

public class LowestCommonAncestor extends Command {
    private final int val1;
    private final int val2;

    /**Конструктор содержит:
     * @param val1 значение одного из искомых узлов
     * @param val2 значение второго из искомых узлов*/
    public LowestCommonAncestor(TreeNode root, int val1, int val2) {
        super(root);
        this.val1 = val1;
        this.val2 = val2;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null || root.val == val1 || root.val == val2) return root;
        TreeNode left = lowestCommonAncestor(root.left, val1, val2);
        TreeNode right = lowestCommonAncestor(root.right, val1, val2);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    @Override
    public Object execute() {
        return lowestCommonAncestor(root, val1, val2);
    }
}
