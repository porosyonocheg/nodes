package treeNodes;

/** Проверяет корректность сериализации бинарного дерева. Сериализация представляет собой строку, в которой через запятую
 * записаны значения узлов, а нулевые узлы заменены знаком #. Для корректной сериализации необходимо присутствие в строке
 * всех возможных потомков, включая "нулевых".
 * @author Сергей Шершавин*/

public class CheckValidPreorderSerialization {

    /**Счётчик countChildren следит за текущим количеством потенциальных потомков в дереве на каждом этапе.
     * Флаг isComma подсказывает была ли запятая предыдущим символом, чтобы для многозначных значений узлов
     * потомки не добавлялись несколько раз*/
    public static boolean isValidSerialization(String preorder) {
        if (preorder.charAt(0) == '#') return preorder.length() == 1;
        int countChildren = 2;
        boolean isComma = false;
        for (int i = 1; i < preorder.length(); i++) {
            if (countChildren == 0) return false;
            switch (preorder.charAt(i)) {
                case ',':
                    isComma = true;
                    break;
                case '#':
                    countChildren--;
                    break;
                default:
                    if (isComma) {
                        countChildren++;
                        isComma = false;
                    }
                    break;
            }
        }
        return countChildren == 0;
    }
}
