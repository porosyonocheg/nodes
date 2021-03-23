package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/**Возвращает true, если дерево является бинарным деревом поиска и false, если нет. В бинарном дереве поиска:
 * 1. Все значения узлов левых поддеревьев должны быть меньше своих родителей
 * 2. Все значения узлов правых поддеревьев должны быть больше своих родителей
 * 3. Оба поддерева должны быть бинарными деревьями поиска.
 * @author Сергей Шершавин*/

public class IsValidBST extends Command {
    public IsValidBST(TreeNode root) {
        super(root);
    }

    /**Проверяем находится ли значение данного узла в диапазоне между минимальным и максимальным узлом поддерева,
     * значения проверяются на null, чтобы избежать крайних случаев со значениями максимального узла = Integer.MAX_VALUE
     * и/или минимального узла = Integer.MIN_VALUE */
    private boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) return true;
        return (maxVal == null || root.val < maxVal) && (minVal == null || root.val > minVal) &&
                isValidBST(root.right, root.val, maxVal) && isValidBST(root.left, minVal, root.val);
    }

    @Override
    public Object execute() {
        return isValidBST(root, null, null);
    }
}
