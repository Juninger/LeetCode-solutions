/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class LC_125_ValidPalindrome {

    // Most optimal solution in terms of efficiency. Does not modify original string.
    public boolean isPalindrome(String s) {

        s = s.toLowerCase(); // could also be done per character when comparing left<->right

        int left = 0; // pointer to first index in string
        int right = s.length()-1; // pointer to last index in string

        while (left < right) { // traverse the string until pointers meet

            char leftChar  = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) { // non-alphanumeric char --> skip and increase left pointer
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) { // non-alphanumeric char --> skip and increase right pointer
                right--;
            } else {
                if (leftChar != rightChar) { // both current chars are alphanumeric but not the same --> not a palindrome
                    return false;
                }
                // adjust pointers for next iteration
                left++;
                right--;
            }
        }
        return true; // full string traversed without false return --> is palindrome
    }

    // Easiest but slowest solution. Includes manipulating input string with regex.
    public boolean isPalindrome2(String s) {

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverse = new StringBuilder(s).reverse().toString();

        return s.equals(reverse);
    }

    // Another easy but slow solution. Somewhat hybrid solution with regex, two-pointer, and no StringBuilder library.
    public boolean isPalindrome3(String s) {

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0; //first index in string
        int right = s.length()-1; //last index in string

        while (left < s.length()/2) {

            if (s.charAt(left) != s.charAt(right)) {

                return false;

            } else {

                left++;
                right--;

            }
        }
        return true;
    }

}
