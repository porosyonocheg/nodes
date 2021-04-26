package treeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Возвращает список наиболее часто повторяющихся сумм поддерревьев
 *@author Сергей Шершавин*/

public class MostFrequentSubtreeSum extends Command {
    private final Map<Integer, Integer> freeqOfSum; // сумма - частота повторений суммы в дереве
    private int maxFreeq; // максимальная частота повторений

    public MostFrequentSubtreeSum(TreeNode root) {
        super(root);
        freeqOfSum = new HashMap<>();
        maxFreeq = 0;
    }

    private int countSum(TreeNode node) {
        if (node == null) return 0;
        int currentSum = countSum(node.left) + countSum(node.right) + node.val;
        int currentCount = freeqOfSum.getOrDefault(currentSum, 0) + 1;
        freeqOfSum.put(currentSum, currentCount);
        maxFreeq = Math.max(currentCount, maxFreeq);
        return currentSum;
    }

    @Override
    public Object execute() {
        countSum(root);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freeqOfSum.entrySet()) {
            if (entry.getValue() == maxFreeq) result.add(entry.getKey());
        }
        return result;
    }
}
