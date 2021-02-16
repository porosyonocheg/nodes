package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**Данный класс описывает некоторые методы работы с деревьями, а также примеры их реализации
 * @author  Сергей Шершавин*/

public class WorkWithTrees {
    public static void main(String[] args) {
        TreeNode l = new TreeNode(-5);
        TreeNode k = new TreeNode(-7);
        TreeNode j = new TreeNode(1);
        TreeNode i = new TreeNode(3);
        TreeNode h = new TreeNode(6);
        TreeNode g = new TreeNode(7,h,null);
        TreeNode f = new TreeNode(5,null,g);
        TreeNode e = new TreeNode(4,i,f);
        TreeNode d = new TreeNode(-6, k, l);
        TreeNode c = new TreeNode(-3);
        TreeNode b = new TreeNode(-1);
        TreeNode a = new TreeNode(-4, d, c);
        TreeNode left1 = new TreeNode(-2, a, b);
        TreeNode right1 = new TreeNode(2, j, e);
        TreeNode root = new TreeNode(0, left1, right1);
        WorkWithTrees wWT = new WorkWithTrees();
        System.out.println(root); // [0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5,
                                  // null, null, null, null, null, 7, null, null, null, null, 6]
        System.out.println(wWT.minDepth(root)); // 3: 0 -> 2 -> 1 или 0 -> -2 -> -1
        System.out.println(wWT.maxDepth(root)); // 6: 0 -> 2 -> 4 -> 5 -> 7 -> 6
        System.out.println(wWT.invertTree(root)); // [0, 2, -2, 4, 1, -1, -4, 5, 3, null, null, null, null,
                                                  // -3, -6, 7, null, null, null, null, null, -5, -7, null, 6]
        System.out.println(wWT.averageOfLevels(right1)); // [2.0, 2.5, 4.0, 7.0, 6.0]
    }

    /**Поиск минимальной глубины дерева (количества узлов до самого близкого к корню листа)*/
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        searchMinDepth(root, 0);
        return minDepth;
    }
    /**Вспомогательный метод поиска минимальной глубины дерева*/
    private void searchMinDepth(TreeNode node, int currentDepth) {
        currentDepth++;
        if (node.left == null && node.right == null) {
            minDepth = Math.min(currentDepth, minDepth);
            return;
        }
        if (currentDepth >= minDepth) return;
        if (node.left != null) searchMinDepth(node.left, currentDepth);
        if (node.right != null) searchMinDepth(node.right, currentDepth);
    }

/**Поиск максимальной глубины дерева (количества узлов до самого дальнего от корня листа)*/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightMaxDepth = maxDepth(root.right);
        int leftMaxDepth = maxDepth(root.left);
        return rightMaxDepth > leftMaxDepth ? rightMaxDepth + 1 : leftMaxDepth + 1;
    }

/**Зеркальное отображение дерева относительно воображаемой вертикальной оси, проходящей через корень*/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**Подсчёт среднего значения величины узлов для каждого уровня дерева*/
    public List<Double> averageOfLevels(TreeNode root) {
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
