/*
 * James Van Gaasbeck
 * PID: J2686979
 * COP 3503 : Computer Science II
 * Professor Sean Szumlanski
 * Assignment 8 : Run Like Hell 
 * Due: Saturday, December 7th, 11:59pm
 * 
 */

public class RunLikeHell {

	public static int maxGain(int[] blocks) {

		return 0;
	}

	public static int maxGainRecDriver(int[] blocks) {

		return maxGainRec(blocks.length - 1, blocks, 0);

		// return 0;
	}

	public static int maxGainRec(int remainingItems, int[] blocks, int retVal) {

		if (remainingItems < 0) {
			retVal += 0;
			return 0;
		}

		// If the knapsack is empty, or if there are zero remaining items to
		// choose from, we have no added value. Just return zero.
		if (remainingItems == 0) {
			retVal += blocks[remainingItems];
			return retVal;
		}

		// If there's still room in our knapsack for this item, then we can
		// either
		// pick it up or leave it behind. We look at the best possible result
		// for
		// both of these paths, and then choose the one that maximizes our
		// value.
		if (blocks[remainingItems] > blocks[remainingItems - 1]) {
			retVal += blocks[remainingItems]
					+ maxGainRec(remainingItems - 2, blocks, retVal);
			return retVal;
		}
		// If we can't pick up the kth item (which is at position (k-1) in the
		// zero-indexed array), then our only choice is to maximize the value we
		// can attain by choosing from the remaining (k-1) items.
		else {
			retVal += blocks[remainingItems - 1]
					+ maxGainRec(remainingItems - 3, blocks, retVal);
			return retVal;
		}
	}

	public static double difficultyRating() {
		return 4.0;
	}

	public static double hoursSpent() {
		return 5;
	}

	public static void main(String[] args) {
		// int[] blocks;

		// 52
		int[] blocks1 = { 15, 3, 6, 17, 2, 1, 20 };
		System.out.println(maxGainRecDriver(blocks1));

		// 45
		int[] blocks2 = { 9, 20, 13, 16, 9, 9, 6 };
		System.out.println(maxGainRecDriver(blocks2));

		// 45
		int[] blocks3 = { 9, 20, 13, 16, 9, 6, 9 };
		System.out.println(maxGainRecDriver(blocks3));

		// 52
		int[] blocks4 = { 15, 3, 6, 17, 2, 1, 20 };
		System.out.println(maxGainRecDriver(blocks4));

		// 67
		int[] blocks5 = { 16, 10, 15, 12, 2, 20, 2, 16 };
		System.out.println(maxGainRecDriver(blocks5));

		// 30
		int[] blocks6 = { 3, 5, 7, 3, 11, 5, 9, 8 };
		System.out.println(maxGainRecDriver(blocks6));

		// 56
		int[] blocks7 = { 7, 10, 18, 16, 17, 12, 14, 9 };
		System.out.println(maxGainRecDriver(blocks7));

		// 11260
		int[] blocks8 = { 573, 216, 451, 236, 42, 243, 743, 162, 317, 323, 4,
				407, 230, 380, 177, 89, 596, 421, 643, 655, 735, 441, 408, 716,
				449, 781, 28, 346, 241, 229, 697, 354, 685, 628, 535, 463, 578,
				275, 786, 362, 488, 372, 68, 434, 687 };
		System.out.println(maxGainRecDriver(blocks8));

	}

}
