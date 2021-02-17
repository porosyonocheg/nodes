package treeNodes;

/** Поиск узла в бинарном дереве поиска по значению. За корректность входных данных отвечает клиентская сторона.
 * @author Сергей Шершавин*/

public class FindElementInBST extends Command {
    private int target;

    public FindElementInBST(TreeNode root, int target) {
        super(root);
        this.target = target;
    }

    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        if (root.val > target) return searchBST(root.left, target);
        return searchBST(root.right, target);
    }

    @Override
    Object execute() {
        return searchBST(root, target);
    }
}
