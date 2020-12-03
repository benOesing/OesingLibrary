package de.oesing.all;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OesingLibArray {


	/**
	 * Uses a linearsearch to find the given Object in the array. The types have to
	 * be equal.
	 *
	 * @param array The array that gets searched.
	 * @param obj   The object that gets searched for.
	 * @return Returns the position of obj in array, or -1 if not found.
	 */
	public static int linearSearch(final Object[] array, final Object obj) {
		for (int i = 0; i < array.length; i++) {
			final Object element = array[i];
			if (element.equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This solution implements the O(n^2) approach instead of saving every element
	 * seen in a hashing datastructure. Because conversion from Object to T[] is
	 * difficult, but necessary for the equal method. The function checks the last
	 * index first.
	 *
	 * @param arr The Array of objects that gets checked for duplicates.
	 * @return Returns true if there are no duplicates.
	 */
	public static boolean noDuplicates(final Object[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i].equals(arr[j])) {
					return false;
				}
				if (arr[i].getClass().isArray() && arr[j].getClass().isArray()) {
					Object[] o1 = new Object[Array.getLength(arr[i])];
					Object[] o2 = new Object[Array.getLength(arr[j])];
					try {
						o1 = (Object[]) arr[i];
						o2 = (Object[]) arr[j];
					} catch (final ClassCastException e) {
						for (int k = 0; k < o1.length; k++) {
							// This boxes primitives
							o1[k] = Array.get(arr[i], k);
							o2[k] = Array.get(arr[j], k);
						}
					}
					if (Arrays.deepEquals(o1, o2)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
