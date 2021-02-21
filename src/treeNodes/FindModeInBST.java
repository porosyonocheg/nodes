package treeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Находит в бинарном дереве поиска чаще всего повторяющиеся значения узлов.
 * @author  Сергей Шершавин*/

public class FindModeInBST extends Command {
    private int maxFreq = 0;
    public FindModeInBST(TreeNode root) {
        super(root);
    }
        /**Подсчитывает число повторов значений, добавляет их во вспомогательную мапу, устанавливает значение
         * maxFreq - максимальное число повторов среди всех значений*/
    private void countNodeRepeats (TreeNode node, Map<Integer,Integer> values) {
        if (node == null) return;
        values.put(node.val, values.getOrDefault(node.val, 0) + 1);
        if (values.get(node.val) > maxFreq) maxFreq = values.get(node.val);
        countNodeRepeats(node.left, values);
        countNodeRepeats(node.right,values);
    }
        /**По совпадению значений в мапе, полученной во вспомогательном методе, с maxFreq получаем набор значений,
         * добавляемый  список result*/
    @Override
    Object execute() {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        countNodeRepeats(root, map);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) result.add(entry.getKey());
        }
        return result;
    }
}
