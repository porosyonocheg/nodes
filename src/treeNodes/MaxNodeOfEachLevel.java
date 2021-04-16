package treeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Возвращает список максимальных значений узлов для каждого уровня от корня до листьев
 * @author Сергей Шершавин*/

public class MaxNodeOfEachLevel extends Command {
    public MaxNodeOfEachLevel(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.val > max) max = current.val;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.add(max);
        }
        return result;
    }
}
