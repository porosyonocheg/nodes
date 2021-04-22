package treeNodes;

/**Возвращает значение самого глубокого левого узла бинарного дерева.
 * @author Сергей Шершавин*/

public class FindBottomLeftTreeValue extends Command {
    public FindBottomLeftTreeValue(TreeNode root) {
        super(root);
    }

    /** Вместо глобальных переменных используем массив, в 0-й ячейке которого будем хранить значение узла на наибольшей
     * текущей глубине (при обходе Preorder узел будет самым левым из возможных на данной глубине), а в 1-й ячейке -
     * максимальную текущую глубину*/
    private int findBottomLeftValue(TreeNode node, int depth, int[] result) {
        if (depth > result[1]) {
            result[0] = node.val;
            result[1] = depth;
        }
        if (node.left != null) findBottomLeftValue(node.left, depth + 1, result);
        if (node.right != null) findBottomLeftValue(node.right, depth + 1, result);
        return result[0];
    }

    @Override
    public Object execute() {
        if (root == null) throw new IllegalArgumentException("Nothing to look for");
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
}
