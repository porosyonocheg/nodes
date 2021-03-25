package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

import java.util.LinkedList;

/**Возвращает значение k-го наименьшего узла бинарного дерева поиска. Если k превышает значение числа узлов дерева или
 * меньше 1, пробрасывает RuntimeException
 * @author Сергей Шершавин*/

public class KthSmallestElement extends Command {
    private final int k;

    /**Конструктор содержит:
     * @param k номер искомого элемента, индексированный с 1.*/
    public KthSmallestElement(TreeNode root, int k) {
        super(root);
        this.k = k;
    }

    @Override
    public Object execute() {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 0;
        stack.offer(root);
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            count++;
            root = stack.pop();
            if (count == k) return root.val;
            root = root.right;

        }
        throw new RuntimeException("Incorrect k");
    }
}
