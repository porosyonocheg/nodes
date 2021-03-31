package treeNodes;

import java.util.LinkedList;

/** Определяет является ли дерево полным (завершённым). Дерево считается полным, если на каждом уровне кроме последнего
 * все потомки ненулевые, а на последнем уровне все ненулевые потомки расположены слева:
 * [1, 2, 3] или [1, 2] - полные деревья
 * [1, null, 3] - не является полным
 * @author Сергей Шершавин*/

public class IsComplete extends Command {
    public IsComplete(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNotFill = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (isNotFill) return false;
                }
                else isNotFill = true;

                if (node.right != null) {
                    queue.offer(node.right);
                    if (isNotFill) return false;
                }
                else isNotFill = true;
            }
        }
        return true;
    }
}
