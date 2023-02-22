import java.util.*;

/**
 * @program: laiweilai
 * @description:算法题
 * @author: zhuzhiwen
 * @date: 2023/02/22 20:51
 **/

/**
 * 1.所有字母均为小写字母
 * 2.如果没有合法的顺序序列，输出空串
 * 3.如果有多个合法的顺序序列，输出任意一个即可
 */
public class Solution {

    public static void main(String[] args) {
        String[] words = new String[]{"xmc", "xmq", "em", "ecc", "mqcc"};
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(words));
    }

    public class Node {
        public int degree;
        public ArrayList<Integer> neighbour = new ArrayList<>();

        void Node() {
            degree = 0;
        }
    }

    public String alienOrder(String[] words) {
        Node[] node = new Node[26];
        boolean[] happen = new boolean[26];
        for (int i = 0; i < 26; i++) {
            node[i] = new Node();
        }
        for (int i = 0; i < words.length; i++) {
            int stortPoint = 0;
            int endPoint = 0;
            for (int j = 0; j < words[i].length(); j++) {
                happen[charToInt(words[i].charAt(j))] = true;
            }
            if (i != words.length - 1) {
                for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                    if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                        stortPoint = charToInt(words[i].charAt(j));
                        endPoint = charToInt(words[i + 1].charAt(j));
                        break;
                    }
                }
            }
            if (stortPoint != endPoint) {
                node[stortPoint].neighbour.add(endPoint);
                node[endPoint].degree++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (node[i].degree == 0 && happen[i]) {
                queue.offer(i);
                ans = ans + intToChar(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : node[now].neighbour) {
                node[i].degree--;
                if (node[i].degree == 0) {
                    queue.offer(i);
                    ans = ans + intToChar(i);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node[i].degree != 0) {
                return "";
            }
        }
        return ans;
    }

    private char intToChar(int i) {
        return (char) ('a' + i);
    }

    public int charToInt(char ch) {
        return ch - 'a';
    }


}
