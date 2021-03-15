package treeNodes;

/**Подсчитывает число хороших узлов в дереве. Хорошим считается узел, если на всём пути от корня к нему не встречается
 * узлов превышающих его по значению. Корень автоматически считается хорошим узлом.
 * @author Сергей Шершавин*/

public class CountGoodNodes extends Command {
    public CountGoodNodes(TreeNode root) {
        super(root);
    }

    private void countGoodNodes(TreeNode root, int[] count, int maxVal) {
        if (root == null) return;
        if (root.val >= maxVal ) {
            count[0]++;
            maxVal = root.val;
        }
        countGoodNodes(root.left, count, maxVal);
        countGoodNodes(root.right, count, maxVal);
    }

    @Override
    public Object execute() {
        int[] count = new int[1];
        if (root != null) {
            count[0]++;
            int maxVal = root.val;
            countGoodNodes(root.left, count, maxVal);
            countGoodNodes(root.right, count, maxVal);
        }
        return count[0];
    }
}
