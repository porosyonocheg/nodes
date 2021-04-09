package treeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Возвращает список полных деревьев для заданного числа узлов. Полным считается дерево, каждый узел которого имеет
 * либо 0, либо 2 потомка. Таким образом, из чётного числа узлов нельзя построить полное дерево. cacheMap будет хранить
 * готовые списки для "крайних" значений, дабы избежать повторных вычислений для симметричных позиций.
 * @author Сергей Шершавин*/

public class AllPossibleFullBinaryTrees {
    private final Map<Integer, List<TreeNode>> cacheMap = new HashMap<>();

    /**@param n число узлов, для которого строятся разновидности деревьев, должно быть положительным
     * @return список всех возможных полных деревьев для данного числа узлов*/
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) return result;

        if (n == 1) {
            result.add(new TreeNode());
            return result;
        }

        if (cacheMap.containsKey(n)) return cacheMap.get(n);

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftNodes)
                for (TreeNode right : rightNodes) {
                    result.add(new TreeNode(0, left, right));
                }
        }
        cacheMap.put(n, result);
        return result;
    }
}
