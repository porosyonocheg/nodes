package treeNodes;

/** Возвращает количество поддеревьев, содержащих одинаковые значения узлов
 * @author Сергей Шершавин*/

public class CountUnivalueSubtrees extends Command {
    public CountUnivalueSubtrees(TreeNode root) {
        super(root);
    }

    private boolean isUnivalueTree(TreeNode node, int[] count) {
        if (node == null) return true;
        boolean left = isUnivalueTree(node.left, count);
        boolean right = isUnivalueTree(node.right, count);

        if (left && right) {
            if ((node.left != null && node.left.val != node.val) || (node.right != null && node.right.val != node.val)) return false;
            count[0]++;
            return true;
        }
        return false;
    }

    @Override
    public Object execute() {
        int[] count = new int[1];
        isUnivalueTree(root, count);
        return count[0];
    }
}
