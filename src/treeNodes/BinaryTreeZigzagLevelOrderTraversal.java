package treeNodes;

import java.util.*;

/** Возвращает список значений узлов при зиг-загообразном обходе дерева. Аналог обхода в ширину, но каждый нечетный
 * уровень обходится справа налево.
 * @author Сергей Шершавин*/

public class BinaryTreeZigzagLevelOrderTraversal extends Command {
    public BinaryTreeZigzagLevelOrderTraversal(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean isStraight = true;
            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> current = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    root = queue.poll();
                    current.add(root.val);
                    if (root.left != null) queue.add(root.left);
                    if (root.right != null) queue.add(root.right);
                }
                if (isStraight) {
                    isStraight = false;
                }
                else {
                    Collections.reverse(current);
                    isStraight = true;
                }
                result.add(current);
            }
        }
        return result;
    }
}
