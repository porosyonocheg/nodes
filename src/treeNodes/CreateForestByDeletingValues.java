package treeNodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Возвращает список деревьев, образованных после удаления всех узлов по переданным в массиве значениям.
 * @author Сергей Шершавин*/

public class CreateForestByDeletingValues extends Command {
    private final int[] valuesToDelete;

    /** Конструктор содержит:
     * @param valuesToDelete массив значений для удаления*/
    public CreateForestByDeletingValues(TreeNode root, int[] valuesToDelete) {
        super(root);
        this.valuesToDelete = valuesToDelete;
    }

    @Override
    public Object execute() {
        List<TreeNode> nodes = new ArrayList<>();
        Set<Integer> deleteValues = new HashSet<>();
        for (int i : valuesToDelete) deleteValues.add(i);
        if (postOrderTraversalTree(root, deleteValues, nodes) != null){
            nodes.add(root);
        }
        return nodes;
    }

    /**Если значение узла содержится в списке на удаление, возвращаем null его предку, а в список добавляем
     * его потомков, если они существуют*/
    private TreeNode postOrderTraversalTree(TreeNode node, Set<Integer> deleteValues, List<TreeNode> nodes) {
        if (node == null) return null;
        node.left = postOrderTraversalTree(node.left, deleteValues, nodes);
        node.right = postOrderTraversalTree(node.right, deleteValues, nodes);
        if (deleteValues.contains(node.val)) {
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
            return null;
        }
        return node;
    }
}
