package treeNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** Вертикальный обход бинарного дерева. Для каждого узла на позиции (x,y) координата левого узла (x+1,y-1), правого
 * узла (x+1, y+1). Корень находится на позиции (0,0). Обход происходит от сверху вниз по y, начиная с его минимального
 * и заканчивая максимальным значением. В случае, когда есть несколько узлов с одинаковыми координатами, они
 * упорядочиваются по значениям узлов.
 * @author Сергей Шершавин*/

public class VerticalOrderTraversal extends Command {
    public VerticalOrderTraversal(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> p1.y != p2.y ? p1.y - p2.y : p1.x != p2.x ? p1.x - p2.x : p1.val - p2.val);
        dfs(root, 0, 0, queue);
        int prevValue = Integer.MIN_VALUE;
        List<Integer> currentList;
        while(!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            if (currentPoint.y > prevValue) {
                currentList = new ArrayList<>();
                currentList.add(currentPoint.val);
                result.add(currentList);
            }
            else {
                currentList = result.get(result.size()-1);
                currentList.add(currentPoint.val);
            }
            prevValue = currentPoint.y;
        }
        return result;
    }

    private void dfs(TreeNode node, int x, int y, PriorityQueue<Point> queue) {
        if (node == null) return;
        queue.offer(new Point(x, y, node.val));
        dfs(node.left, x+1, y-1, queue);
        dfs(node.right, x+1, y+1, queue);
    }
}

class Point {
    final int x, y, val;
    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}