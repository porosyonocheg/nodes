package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Определяет максимальную ширину дерева, как максимальное количество узлов (в том числе и нулевых)
 * между первым и последним ненулевыми узлами (находящимися на одной глубине) среди всех глубин дерева.
 * @author Сергей Шершавин*/

public class MaximumWidthOfBinaryTree extends Command {
    private int maxWidth = 0;

    public MaximumWidthOfBinaryTree(TreeNode root) {
        super(root);
    }

    /**@param depth текущая глубина дерева
     * @param id глобальный номер элемента в дереве, для root: id = 1;
     *           для root.left: id = 2; для root.right: id = 3 и т.д.
     * @param indexes хранит id первых ненулевых элементов на каждой глубине*/
    private void treeTraversal(TreeNode node, int depth, int id, List<Integer> indexes) {
        if (depth >= indexes.size()) {
            indexes.add(id);
        }
        maxWidth = Math.max(maxWidth, id - indexes.get(depth) + 1);
        if (node.left != null) treeTraversal(node.left, depth + 1, id * 2, indexes);
        if (node.right != null) treeTraversal(node.right, depth + 1, id * 2 + 1, indexes);
    }

    @Override
    public Object execute() {
        if (root != null) treeTraversal(root, 0, 1, new ArrayList<>());
        return maxWidth;
    }
}
