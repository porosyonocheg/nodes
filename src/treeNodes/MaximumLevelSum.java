package treeNodes;

import java.util.LinkedList;
import java.util.Queue;

/**Возвращает номер наименьшего уровня (наименьшую глубину) дерева, на котором сумма значений узлов маскимальна. Если
 * корень существует, то он находится на уровне (глубине) 1.
 * @author Сергей Шершавин*/

public class MaximumLevelSum extends Command {
    public MaximumLevelSum(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        if (root == null) return 0;
        int maxSum = Integer.MIN_VALUE;
        int indexOfLevel = 1, maxIndex = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                currentSum += node.val;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxIndex = indexOfLevel;
            }
            indexOfLevel++;
        }
        return maxIndex;
    }
}
