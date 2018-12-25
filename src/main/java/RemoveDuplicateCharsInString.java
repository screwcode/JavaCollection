import java.util.HashSet;

public class RemoveDuplicateCharsInString {
    // 修改这个方法使得它能够输出正确结果：
    // 例如，输入aabbcc返回abc
    // 输入ccbbaa返回cba
    // 输入apple返回aple
    public static String removeDuplicateCharsInString(String s) {
        HashSet<Character> charSet = new HashSet<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!charSet.contains(ch)) {
                result += ch;
                charSet.add(ch);
            }
        }
        return result;
    }
}
