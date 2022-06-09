package 剑指offer专项突破;

/**
 * @author lingbohang on 2022/6/9
 *
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 *  具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 *
 *  示例 2：
 *
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= s.length <= 1000
 *  s 由小写英文字母组成
 *
 *
 *
 *
 *  注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/
 *  Related Topics 字符串 动态规划 👍 52 👎 0
 */
public class Offer020 {
    /**
     * 思路：
     *      验证字符串常见的方法是双指针，分别从头尾处开始遍历
     *      还可以从字符串中间开始，向两边扩张来验证回文字符串，也就是left--和right++
     *      下方countPalindrome方法就是用的从中间开始扩张的方式
     *      countPalindrome(s,i,i);好理解，但是为什么还有个countPalindrome(s,i,i+1);呢
     *      因为countPalindrome(s,i,i)的子字符串只有奇数个字符，偶数字符串全都漏掉了
     *      所以countPalindrome(s,i,i+1)相当于专门统计偶数长度的字符串，自然也不会和countPalindrome(s,i,i)重复统计
     * */
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0;i<s.length();i++){
            count+=countPalindrome(s,i,i);
            count+=countPalindrome(s,i,i+1);
        }
        return count;
    }

    private int countPalindrome(String str,int left,int right){
        int count = 0;
        while (left>=0&&right<str.length()&&str.charAt(left--)==str.charAt(right++)){
            count++;
        }
        return count;
    }
}
