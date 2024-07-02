import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window.
 *
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
public class LC_76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return ""; // edge case, empty string

        int minWindowLength = Integer.MAX_VALUE; // default window size
        int[] resultIdx = new int[2]; // stores start and end index of minimum window

        // frequency maps: <char : occurrences>
        Map<Character, Integer> windowMap = new HashMap<>(); // map for current sliding window
        Map<Character, Integer> subStringMap = new HashMap<>(); // map for string "t"

        // fill subStringMap from input string "t"
        for (char c : t.toCharArray()) {
            // adds +1 of current character to map
            subStringMap.put(c, subStringMap.getOrDefault(c, 0) + 1);
        }

        int leftP = 0; // left pointer for sliding window
        int matchingCharacters = 0; // number of characters in window that currently matches string "t"
        for (int rightP = 0; rightP < s.length(); rightP++) {
            char rightChar = s.charAt(rightP); // current char at right pointer

            // adds +1 of character at right pointer to map
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // check if rightChar is part of string "t" and if window has the correct amount of this character
            if (subStringMap.containsKey(rightChar)
                    && Objects.equals(windowMap.get(rightChar), subStringMap.get(rightChar))) {
                matchingCharacters++;
            }

            // keep shrinking window while it still contains all characters from string "t"
            while (matchingCharacters == subStringMap.size()) {
                int currentWindowLength = (rightP - leftP + 1); // update length of current window
                if (currentWindowLength < minWindowLength) { // update index pointers for result and minimum window length
                    resultIdx[0] = leftP;
                    resultIdx[1] = rightP;
                    minWindowLength = currentWindowLength;
                }

                char leftChar = s.charAt(leftP); // current char at left pointer --> to be removed
                windowMap.put(leftChar, windowMap.get(leftChar) - 1); // remove character from the left of window when shrinking

                // if removed character was part of string "t" and current window now has too few of that character: update current matches
                if (subStringMap.containsKey(leftChar) && windowMap.get(leftChar) < subStringMap.get(leftChar)) {
                    matchingCharacters--;
                }
                leftP++; // shrink window by moving left pointer +1
            }
        }
        // if window length has been altered, return substring from "s", otherwise return empty string
        return minWindowLength != Integer.MAX_VALUE ? s.substring(resultIdx[0], resultIdx[1] + 1) : "";
    }
}
