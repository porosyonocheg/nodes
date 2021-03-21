package treeNodes;

import java.util.LinkedList;

/** Определяет является ли дерево чётно-нечётным. В чётно-нечётном дереве каждый чётный ряд (потомков относительно корня)
 * должен содержать только нечётные числа в строго возврастающем порядке слева направо, а каждый нечётный - только чётные
 * числа в строго убывающем порядке. Корневой ряд считается нулевым.
 * @author Сергей Шершавин*/

public class IsEvenOddTree extends Command {
    public IsEvenOddTree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEven = true;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            TreeNode current = queue.poll();
            if ((isEven && current.val %2 == 0) || (!isEven && current.val %2 != 0)) return false;
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
            int baseValue = current.val;
            for (int i = 1; i < currentSize; i++) {
                current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                if (isEven && (current.val %2 == 0 || current.val <= baseValue)) return false;
                if (!isEven && (current.val %2 != 0 || current.val >= baseValue)) return false;
                baseValue = current.val;
            }
            isEven = !isEven;
        }
        return true;
    }
}
