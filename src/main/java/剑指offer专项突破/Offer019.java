package 剑指offer专项突破;

/**
 * @author lingbohang on 2022/6/9
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 *
 *
 *  示例 1:
 *
 *
 * 输入: s = "aba"
 * 输出: true
 *
 *
 *  示例 2:
 *
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 *
 *
 *  示例 3:
 *
 *
 * 输入: s = "abc"
 * 输出: false
 *
 *
 *
 *  提示:
 *
 *
 *  1 <= s.length <= 10⁵
 *  s 由小写英文字母组成
 *
 *
 *
 *
 *  注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/
 *  Related Topics 贪心 双指针 字符串 👍 37 👎 0
 */
public class Offer019 {
    /**
     * 思路：
     *  双指针，分别指向头和尾，如果碰到不相等的字符就跳出循环
     *  因为可以删除一个字符串，但是不知道删除左边的还是右边的，可以左右都可以试一次，只要有一个返回true就行
     * */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }else{
                left++;
                right--;
            }
        }
        return left>=right||validPalindromeHelper(left+1,right,s)||validPalindromeHelper(left,right-1,s);
    }

    private boolean validPalindromeHelper(int left,int right,String s){
        while (left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }else{
                left++;
                right--;
            }
        }
        return left>=right;
    }
}
