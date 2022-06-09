package 剑指offer专项突破;

/**
 * @author lingbohang on 2022/6/9
 *
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语
 * 的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *
 *
 *  示例 1:
 *
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 *  示例 2:
 *
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 *  示例 3:
 *
 *
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  2 <= words.length <= 1000
 *  1 <= words[i].length <= 1000
 *  words[i] 仅包含小写字母
 *
 *
 *
 *
 *  注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-
 * lengths/
 *  Related Topics 位运算 数组 字符串 👍 81 👎 0
 */


public class Offer005 {
    /**
     * 思路：
     *     用一个二维数组记录每个字符串字符是否出现,第一维是字符串数组的长度，第二维是26，也就是26个字母
     *     然后两两遍历字符串i和j，比较他们某个字符是否同时出现
     * 这个题目之所以归到位运算，是因为数组可以改成二进制的形式，二进制的1就是true，0就是false,这样数组就只有一维了
     * 不过因为26是常数，整体时间复杂度和空间复杂度改成二进制都没啥变化，所以个人感觉没必要写出二进制的形式，反而降低可读性
     * */
    public int maxProduct(String[] words) {
        boolean[][] flag = new boolean[words.length][26];
        for(int i = 0;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                flag[i][c-'a']=true;
            }
        }
        int result = 0;
        for(int i = 0;i<words.length-1;i++){
            for (int j = i+1;j<words.length;j++){
                int k = 0;
                for(;k<26;k++){
                    if(flag[i][k]&&flag[j][k]){
                        break;
                    }
                }
                if(k==26){
                    result = Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;

    }
}
