/*
 * JV
 * COP 3503 : Computer Science II
 * Run Like Hell 
 * Due: Saturday, December 7th, 11:59pm
 * 
 */

//Dynamic Programming assignment. Runs in O(n) time and O(n) space complexity.
public class RunLikeHell {

	// This is the Dynamic Programming AKA "DP" (*snicker*) method.
	public static int maxGain(int[] blocks) {

		// handle cases where nothing is passed to it
		if (blocks == null || blocks.length == 0) {
			return 0;
		}
		// handle cases where only one item is in the array.
		if (blocks.length == 1) {
			return blocks[0];
		}

		// this is the array that is used to keep track of all of the
		// subproblem's sums. Using this memo array allows us to turn a normally
		// slow run time into a fast O(n) runtime.
		int memo[] = new int[blocks.length];

		// start off the first two indices so we can jump start the for-loop and
		// make some of the logic a little easier on ourselves.
		memo[0] = blocks[0];
		memo[1] = blocks[1];

		for (int i = 2; i < blocks.length; i++) {
			// if we aren't at the first cycle of the loop (second index) then
			// find the Max of the second and third index of the array, and add
			// it to this current index.
			if (i != 2)
				memo[i] += Math.max(memo[i - 2], memo[i - 3]) + blocks[i];
			else
				// if we are at the first cycle of the loop (second index) then
				// we want to just add the first index (index 0) to it because
				// it isn't possible to add the index directly before it (index
				// 1).
				memo[i] += blocks[i - 2] + blocks[i];
		}

		// return the largest index of the array, which will always be the last
		// or second to last index, depending on where the algorithm started at
		// in the array
		return Math.max(memo[blocks.length - 1], memo[blocks.length - 2]);
	}
	
	// Recursive function that get's called to call the actual recursive
	// function. (must call this method)
	public static int maxGainRecDriver(int[] blocks) {
		return maxGainRec(blocks.length - 1, blocks, 0);
	}

	// This is the recursive solution to the problem.
	public static int maxGainRec(int remainingItems, int[] blocks, int retVal) {
		// return zero if we are out of bounds
		if (remainingItems < 0) {
			retVal += 0;
			return 0;
		}
		// return what's at zero if we're at zero
		if (remainingItems == 0) {
			retVal += blocks[remainingItems];
			return retVal;
		}
		// if the current block is larger than the one before it add it and
		// decrement by two because we can't take the one directly before it.
		if (blocks[remainingItems] > blocks[remainingItems - 1]) {
			retVal += blocks[remainingItems]
					+ maxGainRec(remainingItems - 2, blocks, retVal);
			return retVal;
		}
		// if the block before it is larger add that one and then decrement by
		// three to skip the block that comes directly before because we aren't
		// allowed to take that one.
		else {
			retVal += blocks[remainingItems - 1]
					+ maxGainRec(remainingItems - 3, blocks, retVal);
			return retVal;
		}
	}

	public static double difficultyRating() {
		return 3.3333333;
	}

	public static double hoursSpent() {
		return 6.5;
	}
}
