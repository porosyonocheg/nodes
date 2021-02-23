package treeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**Подсчёт среднего значения величины узлов для каждого уровня дерева
 * @author Сергей Шершавин*/

public class AverageOfLevels extends Command{
    public AverageOfLevels(TreeNode root) {
        super(root);
    }

    @Override
    protected Object execute() {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            double sum = 0;
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(sum/currentSize);
        }
        return result;
    }
}
