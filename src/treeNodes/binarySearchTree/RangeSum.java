package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Подсчёт суммы значений всех узлов бинарного дерева поиска в заданном диапазоне
 * @author Сергей Шершавин*/

public class RangeSum extends Command {
    private final int low;
    private final int high;
    private int sum;

    /**Конструктор содержит
     * @param low  нижняя граница диапазона
     * @param high верхняя граница диапазона*/
    public RangeSum(TreeNode root, int low, int high) {
        super(root);
        this.low = low;
        this.high = high;
    }

    /**Рекурсивно вызываем метод пока значение переданного узла не окажется внутри заданного диапазона,
     * затем вызываем вспомогательный метод подсчёта суммы значений узлов*/
    private int rangeSumBST(TreeNode root) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right);
        if (root.val > high) return rangeSumBST(root.left);
        sum = 0;
        sum(root);
        return sum;
    }

    private void sum (TreeNode root) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            if (root.val > low) {
                sum(root.left);
            }
            if (root.val < high) {
                sum(root.right);
            }
        }
    }

    @Override
    public Object execute() {
        return rangeSumBST(root);
    }
}
