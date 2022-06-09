package 剑指offer专项突破;

/**
 * @author lingbohang on 2022/6/9
 *
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 *  输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 *  示例 1:
 *
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 *
 *  示例 2:
 *
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 *
 *  提示：
 *
 *
 *  每个字符串仅由字符 '0' 或 '1' 组成。
 *  1 <= a.length, b.length <= 10^4
 *  字符串如果不是 "0" ，就都不含前导零。
 *
 *
 *
 *
 *  注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
 *  Related Topics 位运算 数学 字符串 模拟 👍 38 👎 0
 */

public class Offer002 {
    /**
     *  思路：
     *      模拟加法的过程,从右往左一位一位的相加，只是由十进制变为了二进制，二进制逢2进1
     * */
    public String addBinary(String a, String b) {
        int i = a.length();
        int j = b.length();
        byte carry = 0;
        StringBuilder result = new StringBuilder();
        while (i>0||j>0){
            int numA = i>0?a.charAt(--i)-'0':0;
            int numB = j>0?b.charAt(--j)-'0':0;
            int sum = numA+numB+carry;
            if(sum>=2){
                carry = 1;
                result.append(sum%2);
            }else{
                carry = 0;
                result.append(sum);
            }
        }

        if(carry>0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
