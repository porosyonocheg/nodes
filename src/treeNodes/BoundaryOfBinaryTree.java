package treeNodes;

import java.util.*;

/**Возвращает список значений узлов, представляющих границу бинарного дерева при её обходе против часовой стрелки.
 * Границей считаются узлы, содержащиеся в крайней левой и правой ветках, корень и листья дерева
 * @author Сергей Шершавин*/

public class BoundaryOfBinaryTree extends Command {

    public BoundaryOfBinaryTree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) return Collections.singletonList(root.val);
        TreeNode node = root;
        if (root.left != null) {
        while (node.left != null || node.right != null) {
            result.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
        }
        else result.add(root.val);
        addLeaves(root, result);
        Deque<Integer> values = new ArrayDeque<>();
        if (root.right != null) {
            node = root.right;
            while (node.left != null || node.right != null) {
                values.addFirst(node.val);
                if (node.right != null) node = node.right;
                else node = node.left;
            }
        }
        while (!values.isEmpty()) {
            result.add(values.pollFirst());
        }
        return result;
    }

    private void rightBorder(TreeNode node, List<Integer> result) {
        if (node.left == null && node.right == null) return;
        if (node.left != null) rightBorder(node.left, result);
        if (node.right != null) rightBorder(node.right, result);
        result.add(node.val);
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) result.add(node.val);
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
}
