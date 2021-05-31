package treeNodes;

import java.util.HashSet;
import java.util.Set;

/**Восстаавливает значения бинарного дерева по его структуре, согласно правилу: если потомок существует, то:
 * node.left.val = node.val * 2 + 1; node.right.val = node.val * 2 + 2. Значение корня root.val = 0.
 * @author Сергей Шершавин*/

public class RecoverContaminatedBinaryTree {
    private final Set<Integer> nodes;
    public RecoverContaminatedBinaryTree(TreeNode root) {
        nodes = new HashSet<>();
        if (root != null) {
            root.val = 0;
            nodes.add(0);
            addToSet(root);
        }
    }

    private void addToSet(TreeNode node) {
        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            nodes.add(node.left.val);
            addToSet(node.left);
        }

        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            nodes.add(node.right.val);
            addToSet(node.right);
        }
    }

    /**@return true, если переданный параметр value содержится в значениях восстановленных узлов, false - если нет*/
    public boolean find(int value) {
        return nodes.contains(value);
    }
}
