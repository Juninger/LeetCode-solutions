/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class LC_11_ContainerWithMostWater {

    public int maxArea(int[] height) {

        int leftP = 0; // left pointer
        int rightP = height.length - 1; // right pointer
        int maxArea = 0; // current maximum found

        // traverse input by moving pointers and calculating possible container sizes
        while (leftP < rightP) {
            int containerLength = rightP - leftP; // current length of container based on pointer positions
            int containerHeight = Math.min(height[leftP], height[rightP]); // current height is equal to the lower of the two lines
            int currentArea = containerLength * containerHeight; // area calculation for container

            maxArea = Math.max(maxArea, currentArea); // update maximum container found if needed

            if (height[leftP] < height[rightP]) leftP++; // move pointers
            else rightP--;
        }
        return maxArea;
    }
}
