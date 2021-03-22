package treeNodes;

import java.util.ArrayList;
import java.util.List;

/** Возврщает список значений узлов дерева, которые находятся на заданном расстоянии distance от заданного узла.
 * Все значения узлов дерева должны быть уникальными
 * @author Сергей Шершавин*/

public class AllNodesDistanceK extends Command {
    private final int target;
    private final int distance;

    /**Конструктор содержит :
     * @param target значение целевого узла
     * @param distance искомое расстояние от целевого узла*/
    public AllNodesDistanceK(TreeNode root, int target, int distance) {
        super(root);
        this.target = target;
        this.distance = distance;
    }

    private int dfs(TreeNode node, int depth, List<Integer> result) {
        return 0;
    }

    @Override
    public Object execute() {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
}
