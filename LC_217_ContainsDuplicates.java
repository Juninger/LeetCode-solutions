import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class LC_217_ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); //create empty set, easy to check for duplicates

        for (int num : nums) {
            //before adding to set, we check if it already contains number
            if (set.contains(num)) {
                return true;
            }
            set.add(num); //add to set if not present
        }

        return false; //no duplicates after adding all numbers
    }
}
