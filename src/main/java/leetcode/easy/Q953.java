package leetcode.easy;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */
public class Q953 {
    public static void main(String[] args) {
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new Q953().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) return true;
        boolean isAlienSorted = true;
        for (int i = 0; i < words.length - 1; i++) {
            if (!isTrue(words[i], words[i + 1], order)) {
                isAlienSorted = false;
                break;
            }
        }
        return isAlienSorted;
    }

    private boolean isTrue(String a, String b, String order) {
        int index = 0, aLen = a.length(), bLen = b.length();
        while (index < aLen && index < bLen) {
            int aIndexIdx = order.indexOf(a.charAt(index));
            int bIndexIdx = order.indexOf(b.charAt(index));
            if (aIndexIdx > bIndexIdx) {
                return false;
            } else if (aIndexIdx < bIndexIdx) {
                return true;
            }
            index++;
        }
        return index >= aLen;
    }
}
