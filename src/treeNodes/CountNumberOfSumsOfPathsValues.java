package treeNodes;

import java.util.HashMap;
import java.util.Map;

/** Возвращает число путей в дереве, сумма значений которых соответствует переданному в конструкторе числу. Путём считается
 * только совокупность узлов от предка к потомкам.
 * @author Сергей Шершавин*/

public class CountNumberOfSumsOfPathsValues extends Command {
    private final int targetSum;
    public CountNumberOfSumsOfPathsValues(TreeNode root, int targetSum) {
        super(root);
        this.targetSum = targetSum;
    }

    @Override
    public Object execute() {
        if (root == null) return 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        return pathSum(root, prefixSums, 0);
    }

    /**prefixSums: ключ - сумма значений пути, значение - сколько раз сумма встречалась
     * numberOfPaths - число путей с искомой суммой, заканчивающихся текущим узлом*/
    private int pathSum(TreeNode node, Map<Integer, Integer> prefixSums, int currentSum) {
        if (node == null) return 0;
        currentSum += node.val;
        int numberOfPaths = prefixSums.getOrDefault(currentSum - targetSum, 0);
        prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1); // добавляем текущую сумму перед рекурсивным вызовом
        int result = numberOfPaths + pathSum(node.left, prefixSums, currentSum) + pathSum(node.right, prefixSums, currentSum);
        prefixSums.put(currentSum, prefixSums.get(currentSum) - 1); // восстанавливаем предыдущее значение для суммы перед выходом из рекурсивного вызова
        return result;
    }
}
