import java.util.Collections;
import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class LC_1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        // PriorityQueue is by default a min-heap, so we initialize it with a custom reverse-order comparator to get a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // adds all stones to the maxHeap, will be in sorted order
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // go through collection of stones and keep trying to smash them together
        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.poll(); // heaviest stone
            int secondStone = maxHeap.poll(); // second-heaviest stone

            // if stones are equal, both are destroyed, put one stone back with its new weight
            if (firstStone != secondStone) maxHeap.add(firstStone - secondStone);
        }

        // if one stone left, returns its weight, otherwise return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
