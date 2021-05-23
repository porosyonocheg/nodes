package treeNodes;

import java.util.*;

/** Находит и возвращает значение ближайшего (по количеству узлов между ними) листа к узлу, значение которого
 * соответствует переданному параметру target, в бинарном дереве с уникальными значениями узлов.
 * @author Сергей Шершавин*/

public class ClosestLeaf extends Command {
    private final int target;
    private TreeNode goal;

    public ClosestLeaf(TreeNode root, int target) {
        super(root);
        this.target = target;
    }

    /**@return -1, если узла с искомым значением не найдено, либо значение ближайшего листового узла. При равной
     * дистанции между несколькими листьями преимущество отдаётся потомкам слева, затем потомкам справа.*/
    @Override
    public Object execute() {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        goal = null;
        findTarget(root, null, parents);
        if (goal == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(goal);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left == null && current.right == null) return current.val;

            if (current.left != null && !visited.contains(current.left.val)) {
                queue.offer(current.left);
                visited.add(current.left.val);
            }

            if (current.right != null && !visited.contains(current.right.val)) {
                queue.offer(current.right);
                visited.add(current.right.val);
            }

            current = parents.get(current);
            if (current != null && !visited.contains(current.val)) {
                queue.offer(current);
                visited.add(current.val);
            }
        }
        return -1;
    }

    private void findTarget(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null) return;
        parents.put(node, parent);
        if (node.val == target) goal = node;
        findTarget(node.left, node, parents);
        findTarget(node.right, node, parents);
    }
}
