package treeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**Данный класс описывает примеры реализации некоторых методов работы с деревьями
 * @author  Сергей Шершавин*/

public class WorkWithTrees {
    public static void main(String[] args) {
        TreeNode l = new TreeNode(-5);
        TreeNode k = new TreeNode(-7);
        TreeNode j = new TreeNode(1);
        TreeNode i = new TreeNode(3);
        TreeNode h = new TreeNode(6);
        TreeNode g = new TreeNode(7,h,null);
        TreeNode f = new TreeNode(5,null,g);
        TreeNode e = new TreeNode(4,i,f);
        TreeNode d = new TreeNode(-6, k, l);
        TreeNode c = new TreeNode(-3);
        TreeNode b = new TreeNode(-1);
        TreeNode a = new TreeNode(-4, d, c);
        TreeNode left1 = new TreeNode(-2, a, b);
        TreeNode right1 = new TreeNode(2, j, e);
        TreeNode root = new TreeNode(0, left1, right1);
        System.out.println(root); // [0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5,
                                  // null, null, null, null, null, 7, null, null, null, null, 6]
        System.out.println(new MinDepthOfTree(root).execute()); // 3: 0 -> 2 -> 1 или 0 -> -2 -> -1
        System.out.println(new MaxDepthOfTree(root).execute()); // 6: 0 -> 2 -> 4 -> 5 -> 7 -> 6
        System.out.println(new InvertTree(root).execute()); // [0, 2, -2, 4, 1, -1, -4, 5, 3, null, null, null, null,
                                                  // -3, -6, 7, null, null, null, null, null, -5, -7, null, 6]
        System.out.println(new AverageOfLevels(right1).execute()); // [2.0, 2.5, 4.0, 7.0, 6.0]
    }
}
