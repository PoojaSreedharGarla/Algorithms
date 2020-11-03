package Sort;

public class QuickSort {
	//Pivot is the last element in the array
	//Puts the pivot ele in the right position in the sorted array
	//To its left, elements lesser than pivot will be there.
	//To its right, elements greater than the pivot will be present.
	private int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int j = 0;
		int pivot = arr[high];
		while (j < high) {
			if (arr[j] < pivot) {
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			j++;
		}
		int tmp = arr[j];
		arr[j] = arr[i + 1];
		arr[i + 1] = tmp;
		
		return i + 1;
	}
	
	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int fixPos = partition(arr, low, high);
			
			quickSort(arr, low, fixPos - 1);
			quickSort(arr, fixPos + 1, high);
			
		}
	}
	
	public void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {9, -3, 90, 20, 60, 45, 70};
		qs.quickSort(arr, 0, arr.length - 1);
		qs.printArr(arr);
	}
}

/*Time:O(nlogn)
 * Space:O(1)
 */
