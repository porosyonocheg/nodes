package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Составляет список значений листьев бинарного дерева, составляет список листьев дерева, которое получилось бы после
 * удаления всех листьев, продолжая данную операцию пока дерево не стало бы пустым.
 * @author Сергей Шершавин*/

public class LeavesOfBinaryTree extends Command {

    public LeavesOfBinaryTree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<List<Integer>> result = new ArrayList<>();
        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode node, List<List<Integer>> result) {
        if (node == null) return -1;
        int depth = Math.max(findLeaves(node.left, result), findLeaves(node.right, result)) + 1;
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        return depth;
    }
}
