package treeNodes;

import java.util.LinkedList;

/** Два игрока по очереди раскрашивают ещё нераскрашенные соседние узлы (предка или любого из потомков) каждый в свой
 * цвет. Сначала первый игрок раскрашивает узел со значением target в красный, далее второй игрок выбирает узел отличный
 * от target  раскрашивает его в синий цвет. Побеждает тот, кто раскрасит больше узлов. Число узлов numberOfNodes
 * должно быть нечётным, чтобы избежать возможности ничьи. Значения узлов дерева должны быть уникальными.
 * @author Сергей Шершавин*/

public class BinaryTreeColoringGame extends Command {
private final int target;
private final int numberOfNodes;

/**Конструктор содержит:
 * @param target значение узла, выбранного первым игроком
 * @param numberOfNodes общее число узлов в дереве*/
    public BinaryTreeColoringGame(TreeNode root, int target, int numberOfNodes) {
        super(root);
        this.target = target;
        this.numberOfNodes = numberOfNodes;
    }

    /**Подсчёт числа потомков*/
    private int count(TreeNode root, int count) {
        if (root.left != null) count = count(root.left, count + 1);
        if (root.right != null) count = count(root.right, count + 1);
        return count;
    }

    /**@return true, если после выбранного первым игроком узла, существует возможность победы второго игрока,
     *         false, если победа второго игрока невозможна при оптимальном распределении ходов.*/
    @Override
    public Object execute() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val == target) break;
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }
        int countLeft = 0, countRight = 0;
        if (root.left != null) countLeft = count(root.left, 1);
        if (root.right != null) countRight = count (root.right, 1);
        int countParent = numberOfNodes - countLeft - countRight - 1;
        return (countLeft > countRight + countParent) || (countRight > countLeft + countParent) || (countParent > countLeft + countRight);
    }
}
