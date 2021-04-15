package treeNodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Возвращает список значений всех узлов всех деревьев в возврастаюем порядке
 * @author Сергей Шершавин*/

public class AllElementsFromListOfTrees {
    public static List<Integer> getAllElements(List<TreeNode> treeNodes) {
        List<Integer> nodes = new ArrayList<>();
        for (TreeNode t : treeNodes) getListFromTree(t, nodes);
        Collections.sort(nodes);
        return nodes;
    }

    private static void getListFromTree(TreeNode node, List<Integer> nodes) {
        if (node == null) return;
        getListFromTree(node.left, nodes);
        nodes.add(node.val);
        getListFromTree(node.right, nodes);
    }
}
