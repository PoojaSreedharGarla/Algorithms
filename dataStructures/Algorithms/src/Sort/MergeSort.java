package Sort;

public class MergeSort {
	
	public void merge(int[] arr, int l, int m, int r) {
		//length of each sub array
		int subA1L = m - l + 1;
		int subA2L = r - m;
		
		//tmp arrays
		int[] subA1 = new int[subA1L];
		int[] subA2 = new int[subA2L];
		
		//fill the tmp arrays
		for (int i = 0; i < subA1L; i++) {
			subA1[i] = arr[l + i];
		}
		for (int j = 0; j < subA2L; j++) {
			subA2[j] = arr[m + 1 + j];
		}
		
		//merge the 2 sub arrays
		int i = 0; 
		int j = 0;
		int k = l;
		while (i < subA1L && j < subA2L) {
			if (subA1[i] < subA2[j]) {
				arr[k] = subA1[i];
				i++;
			} else {
				arr[k] = subA2[j];
				j++;
			}
			k++;
		}
		
		while (i < subA1L) {
			arr[k] = subA1[i];
			i++;
			k++;
		}
		
		while (j < subA2L) {
			arr[k] = subA2[j];
			j++;
			k++;
		}
		
	}
	
	
	//Divide the array into subarrays and call merge function
	public void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
		
			sort(arr, l, m);
			sort(arr, m + 1, r);
			
			merge(arr, l, m ,r);
		}
		
	}
	
	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {12, 9, 3, 1, 8, 0, -4, 6};
		ms.sort(arr, 0, arr.length - 1);
		ms.print(arr);
	}
}

/*Time: O(nlogn)
 * As merge sort always divides the array into two halves and take linear time to merge two halves.
 * Space: O(n)
 * you have to store the elements somewhere. 
 * if you count stack frames, then it's O(n)+ O(log n) , so still O(n) in case of arrays. In case of lists it's O(log n) additional memory
 */
