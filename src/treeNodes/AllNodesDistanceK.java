package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Возврщает список значений узлов дерева, которые находятся на заданном расстоянии distance от заданного узла.
 * Все значения узлов дерева должны быть уникальными
 * @author Сергей Шершавин*/

public class AllNodesDistanceK extends Command {
    private final List<Integer> result;
    private final int target;
    private final int distance;

    /**Конструктор содержит :
     * @param target значение целевого узла
     * @param distance искомое расстояние от целевого узла*/
    public AllNodesDistanceK(TreeNode root, int target, int distance) {
        super(root);
        this.target = target;
        this.distance = distance;
        result = new ArrayList<>();
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return 0;
        if (depth == distance) {
            result.add(node.val);
            return 0;
        }
        int left, right;
        if (node.val == target || depth > 0) {
        left = dfs(node.left, depth+1);
        right = dfs(node.right, depth+1);
        }
        else {
            left = dfs(node.left, depth);
            right = dfs(node.right, depth);
        }

        if (node.val == target) return 1;

        if (left == distance || right == distance) {
            result.add(node.val);
            return 0;
        }

        if (left > 0) {
            dfs(node.right, left+1);
            return left + 1;
        }

        if (right > 0) {
            dfs(node.left,right+1);
            return right + 1;
        }
        return 0;
    }

    private boolean isTargetExist(TreeNode node) {
        if (node == null) return false;
        if (node.val == target) return true;
        return isTargetExist(node.left) || isTargetExist(node.right);
    }

    @Override
    public Object execute() {
        if (isTargetExist(root)) {
        if (distance == 0) {
            result.add(target);
        }
        else dfs(root, 0);
        }
        return result;
    }
}
