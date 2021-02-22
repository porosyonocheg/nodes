package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Выясняет есть ли в бинарном дереве поиска два узла, сумма значений которых равна заданному параметру
 * @author Сергей Шершавин*/

public class FindSumInBST extends Command {
    private int target;

    /**Коструктор содержит
     * @param target  - искомое значение суммы двух узлов*/
    public FindSumInBST(TreeNode root, int target) {
        super(root);
        this.target = target;
    }

    /**Вспомогательный метод заполняет переданный список значениями узлов дерева*/
    private void createListFromBST(TreeNode node, List<Integer> values) {
        if (node == null) return;
        createListFromBST(node.left, values);
        values.add(node.val);
        createListFromBST(node.right,values);
    }
    @Override
    Object execute() {
        List<Integer> list = new ArrayList<>();
        createListFromBST(root, list);
        for (int i = 0, j = list.size()-1; i < j;) {
            int sum = list.get(i) + list.get(j);
            if (sum > target) j--;
            else if (sum < target) i++;
            else return true;
        }
        return false;
    }
}
