package com.screwcode;

import java.util.*;

public class RemoveDuplicateCharsInString {
    // 修改这个方法使得它能够输出正确结果：
    // 例如，输入aabbcc返回abc
    // 输入ccbbaa返回cba
    public static String removeDuplicateCharsInString(String s) {
        TreeSet<Character> charSet = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }

        String result = "";
        Iterator iterator = charSet.descendingIterator();
        while (iterator.hasNext()) {
            Character ch = (Character) iterator.next();
            result += ch;
        }

        return result;
    }
}
