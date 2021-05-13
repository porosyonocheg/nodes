package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Возвращает список из списков узлов, представляющих из себя пути от корня к листу, сумма значений которых соответствует
 * заданному в конструкторе параметру.
 * @author Сергей Шершавин*/

public class RootLeafPathsEqualTargetSum extends Command {
    private final int targetSum;

    /**@param targetSum искомое значение суммы узлов на пути от корня к листу*/
    public RootLeafPathsEqualTargetSum(TreeNode root, int targetSum) {
        super(root);
        this.targetSum = targetSum;
    }

    @Override
    public Object execute() {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode node, int target, int currentSum, ArrayList<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;
        currentSum += node.val;
        currentPath.add(node.val);
        if (node.left == null && node.right == null && currentSum == target) {
            result.add(new ArrayList(currentPath));
        }
        pathSum(node.left, target, currentSum, currentPath, result);
        pathSum(node.right, target, currentSum, currentPath, result);
        currentPath.remove(currentPath.size() - 1);
    }
}
