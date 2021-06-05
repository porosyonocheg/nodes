package treeNodes.nAryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** Сериализация и десериализация n-рного дерева
 * @author Сергей Шершавин*/

public class SerializationOfNAryTree {

    /**Преобразует n-рное дерево в строку, где сначала идёт значение текущего узла, а следом количество его потомков, а
     * далее сами потомки (если есть)*/
    public String serialize(NaryTree root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(',').append(root.children.size());
        for (int i = 0; i < root.children.size(); i++) {
            sb.append(',').append(serialize(root.children.get(i)));
        }
        return sb.toString();
    }

    /**Восстанавливает из сериализованной строки n-рное дерево*/
    public NaryTree deserialize(String data) {
        return data.isEmpty() ? null : dfs(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private NaryTree dfs(Queue<String> queue) {
        NaryTree root = new NaryTree(Integer.parseInt(queue.poll()));
        int size = Integer.parseInt(queue.poll());
        for (int i = 0; i < size; i++) {
            root.children.add(dfs(queue));
        }
        return root;
    }
}
