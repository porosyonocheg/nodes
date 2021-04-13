package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Возвращает список узлов, которые были бы видны, если бы мы смотрели на дерево "справа"
 * @author Сергей Шершавин*/

public class BinaryTreeRightSideView extends Command {
private int maxDepth = -1;

    public BinaryTreeRightSideView(TreeNode root) {
        super(root);
    }

    private void traversalTree(TreeNode node, int depth, List<Integer> nodes) {
        if (depth > maxDepth) {
            nodes.add(node.val);
            maxDepth = depth;
        }
        if (node.right != null) traversalTree(node.right, depth + 1, nodes);
        if (node.left != null) traversalTree(node.left, depth + 1, nodes);
    }

    @Override
    public Object execute() {
        List<Integer> list = new ArrayList<>();
        if (root != null) traversalTree(root, 0, list);
        return list;
    }
}
