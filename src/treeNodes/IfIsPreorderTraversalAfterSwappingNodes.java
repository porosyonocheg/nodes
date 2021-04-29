package treeNodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Массив preorder представляет собой искомый preorder обход дерева. Если переданное дерево можно привести к данному
 * массиву путём перемены потомков любых его узлов, то вернуть список узлов, потомки которых изменили положение. Если
 * получить preorder нельзя вернуть -1.
 * @author Сергей Шершавин*/

public class IfIsPreorderTraversalAfterSwappingNodes extends Command {
    private final int[] preorder;
    private final List<Integer> result;
    private int index;
    public IfIsPreorderTraversalAfterSwappingNodes(TreeNode root, int[] preorder) {
        super(root);
        this.preorder = preorder;
        result = new ArrayList<>();
        index = 0;
    }

    private boolean flipMatchVoyage(TreeNode node, int[] preorder) {
        if (node == null) return true;
        if (node.val != preorder[index++]) return false;
        if (node.left != null && node.left.val != preorder[index]) {
            result.add(node.val);
            return flipMatchVoyage(node.right, preorder) && flipMatchVoyage(node.left, preorder);
        }
        return flipMatchVoyage(node.left, preorder) && flipMatchVoyage(node.right, preorder);
    }

    @Override
    public Object execute() {
        return flipMatchVoyage(root, preorder) ? result : Collections.singletonList(-1);
    }
}
