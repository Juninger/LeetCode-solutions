import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class LC_49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); // Map --> {sorted word : grouped anagrams}

        for (String s : strs) {

            // convert string to chars and sort them to find anagrams
            char[] word = s.toCharArray();
            Arrays.sort(word);

            // create string to use as key in map
            String sorted = new String(word);

            if (!map.containsKey(sorted)) {

                // first time we see a word --> create new group of anagrams
                map.put(sorted, new ArrayList<>());

            }

            // add the unsorted string to the correct group/list of anagrams
            map.get(sorted).add(s);

        }

        // creates new list and populate with grouped anagrams
        return new ArrayList<>(map.values());
    }
}
