package treeNodes;

/**Каждый узел дерева содержит в качестве значения некоторое количество монет от нуля и выше. Суммарное количество монет
 * в дереве равно количеству узлов. Определим какое минимальное число перемещений монет потребуется, чтобы в каждом узле
 * содержалось по одной монете. Одно перемещение означает переход одной монеты от родителя к потомку или наоборот
 * @author Сергей Шершавин*/

public class DistributeCoinsInBinaryTree extends Command {

    public DistributeCoinsInBinaryTree(TreeNode root) {
        super(root);
    }

    /** Рекурсивно для каждого значения узла прибавляем из потомков "лишние" монеты или вычитаем "недостачу",
     * абсолютное значение движения монет аккумулируем в переменной count*/
    private int distributeCoins(TreeNode node) {
        int count = 0;
        if (node.left != null) {
            count += distributeCoins(node.left);
            node.val += node.left.val - 1;
            count += Math.abs(node.left.val - 1);
        }

        if (node.right != null) {
            count += distributeCoins(node.right);
            node.val += node.right.val - 1;
            count += Math.abs(node.right.val - 1);
        }

        return count;
    }

    @Override
    public Object execute() {
        return distributeCoins(root);
    }
}
