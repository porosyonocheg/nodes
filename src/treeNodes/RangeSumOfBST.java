package treeNodes;

/** Подсчёт суммы значений всех узлов бинарного дерева поиска в заданном диапазоне
 * @author Сергей Шершавин*/

public class RangeSumOfBST extends Command {
    private int low;
    private int high;
    private int sum;

    /**Конструктор содержит
     * @param low  нижняя граница диапазона
     * @param high верхняя граница диапазона*/
    public RangeSumOfBST(TreeNode root, int low, int high) {
        super(root);
        this.low = low;
        this.high = high;
    }

    /**Рекурсивно вызываем метод пока значение переданного узла не окажется внутри заданного диапазона,
     * затем вызываем вспомогательный метод подсчёта суммы значений узлов*/
    private int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        sum = 0;
        sum(root, low, high);
        return sum;
    }

    private void sum (TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            if (root.val > low) {
                sum(root.left, low, high);
            }
            if (root.val < high) {
                sum(root.right, low, high);
            }
        }
    }

    @Override
    Object execute() {
        return rangeSumBST(root, low, high);
    }
}
