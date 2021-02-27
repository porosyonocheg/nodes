package treeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Составляет список списков значений узлов по уровням от корня к листьям.
 * @author Сергей Шерашавин*/

public class BinaryTreeLevelTraversal extends Command {

    public BinaryTreeLevelTraversal(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                result.add(list);
            }
        }
        return result;
    }
}
