package treeNodes;

/**Рекурсивно строит бинарное дерево из массива следующим образом: корень - максимальный элемент,
 * левый узел - максимальный элемент из подмассива слева от максимального элемента, правый узел - максимальный
 * элемент из подмассива справа от максимального элемента. Если подмассив пуст - соответствующий узел получает значение
 * null. Все значения исходного массива должны быть уникальными.
 * @author Сергей Шершавин*/

public class ConstructMaximumBinaryTree {
    private final int[] nums;

    public ConstructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
    }

    private TreeNode constructMaximumBinaryTree(int start, int end) {
        if (start == end) return null;
        if (end - start == 1) return new TreeNode(nums[start]);
        int max = nums[start];
        int indexOfMax = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(start, indexOfMax);
        root.right = constructMaximumBinaryTree(indexOfMax+1, end);
        return root;
    }

    public TreeNode execute() {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int max = nums[0];
        int indexOfMax = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(0, indexOfMax);
        root.right = constructMaximumBinaryTree(indexOfMax+1, nums.length);
        return root;
    }
}
