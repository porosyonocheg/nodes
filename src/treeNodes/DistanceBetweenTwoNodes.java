package treeNodes;

import java.util.LinkedList;
import java.util.Queue;

/**Находит расстояние (длину пути) между двумя узлами в бианрном дереве с уникальными значениями узлов
 * @author Сергей Шершавин*/

public class DistanceBetweenTwoNodes extends Command {
    private final int val1;
    private final int val2;
    private final boolean levelTraversal;

    /**@param val1 значение одного из искомых узлов в дереве
     * @param val2 значение второго искомого узла дерева*/
    public DistanceBetweenTwoNodes(TreeNode root, int val1, int val2) {
        super(root);
        this.val1 = val1;
        this.val2 = val2;
        levelTraversal = false;
    }

    /**@param levelTraversal определяет метод, которым считает расстояние между узлами:
     * true - расстояние считается методом обхода в ширину итеративным методом
     * false - расстояние считается двумя вызовами рекурсивного метода для каждого из значений узлов*/
    public DistanceBetweenTwoNodes(TreeNode root, int val1, int val2, boolean levelTraversal) {
        super(root);
        this.val1 = val1;
        this.val2 = val2;
        this.levelTraversal = levelTraversal;
    }

    /**Расстояние между узлами определяем как сумму расстояний от наименьшего общего предка до каждого из узлов
     * @return  -1 если предка не существует*/
    @Override
    public Object execute() {
        TreeNode lca = (TreeNode) new LowestCommonAncestor(root, val1, val2).execute();
        if (lca == null) return -1;
        if (levelTraversal) return distanceLevelOrder(lca);
        return getDistance(lca, val1) + getDistance(lca, val2);
    }

    private int getDistance(TreeNode node, int val) {
        if (node == null) return -1;
        if (node.val == val) return 0;
        int left = getDistance(node.left, val);
        int right = getDistance(node.right, val);
        int distance = Math.max(left, right);
        return distance >= 0 ? 1 + distance : -1;
    }

    private int distanceLevelOrder(TreeNode node) {
        int[] dist = new int[] {-1, -1};
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.val == val1) {
                    dist[0] = count;
                }

                if (node.val == val2) {
                    dist[1] = count;
                }

                if (dist[0] != -1 && dist[1] != -1) return dist[0] + dist[1];
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            count++;
        }
        return -1;
    }
}
