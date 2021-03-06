package treeNodes;

import java.util.LinkedList;

/**Возвращает сумму значений всех узлов дерева, чьи "прародители" имеют значение в зависимости от параметра,
 * передаваемого в конструктор: true - четное значение; false - нечетное значение.
 * @author  Сергей Шершавин*/
public class SumOfNodesWithOddOrEvenValuedGrandparent extends Command {

    private final boolean isEvenGrandparent;
    public SumOfNodesWithOddOrEvenValuedGrandparent(TreeNode root, boolean isEvenGrandparent) {
        super(root);
        this.isEvenGrandparent = isEvenGrandparent;
    }

    private int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
                if (current.val%2==0) {
                    if (current.left.left != null) {
                        sum += current.left.left.val;
                    }
                    if (current.left.right != null) {
                        sum += current.left.right.val;
                    }
                }
            }
            if (current.right != null) {
                queue.add(current.right);
                if (current.val%2==0) {
                    if (current.right.left != null) {
                        sum += current.right.left.val;
                    }
                    if (current.right.right != null) {
                        sum += current.right.right.val;
                    }
                }
            }
        }
        return sum;
    }

    private int sumOddGrandparent(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
                if (current.val%2 != 0) {
                    if (current.left.left != null) {
                        sum += current.left.left.val;
                    }
                    if (current.left.right != null) {
                        sum += current.left.right.val;
                    }
                }
            }
            if (current.right != null) {
                queue.add(current.right);
                if (current.val%2 != 0) {
                    if (current.right.left != null) {
                        sum += current.right.left.val;
                    }
                    if (current.right.right != null) {
                        sum += current.right.right.val;
                    }
                }
            }
        }
        return sum;
    }

    @Override
    public Object execute() {
        return isEvenGrandparent ? sumEvenGrandparent(root) : sumOddGrandparent(root);
    }
}
