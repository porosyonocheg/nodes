package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Возвращает список "маршрутов" от корня до каждого листа дерева.
 * @author Сергей Шершавин*/

public class BinaryTreePaths extends Command{
    public BinaryTreePaths(TreeNode root) {
        super(root);
    }

    private void visit(TreeNode node, List<String> list, String s) {
        s += " -> " + node.val;

        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }

        if (node.left != null)      visit(node.left, list, s);
        if (node.right != null)      visit(node.right, list, s);
    }

    @Override
    Object execute() {
        List<String> result = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) result.add(String.valueOf(root.val));
            if (root.left != null) visit(root.left, result, String.valueOf(root.val));
            if (root.right != null) visit(root.right, result, String.valueOf(root.val));
        }
        return result;
    }
}
