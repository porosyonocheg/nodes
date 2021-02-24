package treeNodes;

import java.util.ArrayList;
import java.util.List;

/**Определяет обладают ли деревья идентичными по значению листьями при сохранении порядка обхода
 * @author Сергей Шершавин*/

public class SimilarLeavesTrees extends Command {
    private TreeNode target;

    public SimilarLeavesTrees(TreeNode root, TreeNode target) {
        super(root);
        this.target = target;
    }

    /**Находим листья и добавляем в список*/
    private void findLeaves(TreeNode node, List<Integer> list) {
        if (node.left != null) findLeaves(node.left, list);
        if (node.left == null && node.right == null) list.add(node.val);
        if (node.right != null) findLeaves(node.right, list);
    }

    /**Сравниваем полученные списки для двух деревьев, сначала по размеру, затем поэлементно*/
    @Override
    public Object execute() {
        List<Integer> listOfRoot = new ArrayList<>();
        findLeaves(root, listOfRoot);
        List<Integer> listOfTarget = new ArrayList<>();
        findLeaves(target, listOfTarget);
        if (listOfRoot.size() != listOfTarget.size()) return false;
        for (int i = 0; i < listOfRoot.size(); i++) {
            if (!listOfRoot.get(i).equals(listOfTarget.get(i))) return false;
        }
        return true;
    }
}
