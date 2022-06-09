package 剑指offer专项突破;

/**
 * @author lingbohang on 2022/6/9
 *
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 *  本题中，将空字符串定义为有效的 回文串 。
 *
 *
 *
 *  示例 1:
 *
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 *  示例 2:
 *
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= s.length <= 2 * 10⁵
 *  字符串 s 由 ASCII 字符组成
 *
 *
 *
 *
 *  注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/
 *  Related Topics 双指针 字符串 👍 24 👎 0
 */
public class Offer018 {
    /**
     * 思路:
     *  验证回文字符串最常见的方法就是双指针，分别从头尾开始遍历
     *  while循环的终止条件要注意一下，字符串有可能是奇数，那么最后left和right肯定会重合
     *  本题的字符串中有空格和其他符号，可以用isLetterOrDigit方法来判断字符是否是字母或数字
     *  如果面试中，面试官不让使用Java自带函数库，也可以用ASCII码来判别：
     *      0-9的ASCII码为48-57
     *      A-Z的ASCII码为65-90
     *      a-z的ASCII码为97-122
     *      只用记住它们的起始值即可
     * */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else{
                char l = Character.toLowerCase(s.charAt(left));
                char r = Character.toLowerCase(s.charAt(right));
                if(l!=r){
                    return false;
                }else{
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
