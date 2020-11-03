package Trees;

public class MinHeap {
	private int maxSize;
	private int size;
	private int[] heap;
	
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}
	
	private int parent(int childPos) {
		return (childPos)/2;
	}
	
	private int leftChild(int parentPos) {
		return (2 * parentPos);
	}
	
	private int rightChild(int parentPos) {
		return (2 * parentPos) + 1;
	}
	
	private void swap(int pos1, int pos2) {
		int tmp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = tmp;
	}
	
	public void insert(int ele) {
		//System.out.println(size);
		if (size >= maxSize)return;
		
		heap[++size] = ele;
		//System.out.println(heap[size]);
		int current = size;
		
		while (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}	
	}
	
	private boolean leafNode(int pos) {
		if (pos > size/2 && pos <= size)	return true;
		return false;
	}
	
	private void minHeapify(int pos) {
		if (!leafNode(pos)) {
			if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	public int remove() {
		int popped = heap[1];
		
		heap[1] = heap[size];
		size--;
		minHeapify(1);
		
		return popped;
	}
	
	public void minHeap() {
		for (int pos = size/2; pos >= 1; pos--) {
			minHeapify(pos);
		}
	}
	
	public void printHeap() {
		
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MinHeap mh = new MinHeap(10);
		mh.insert(2);
		mh.insert(0);
		mh.insert(9);
		mh.insert(6);
		mh.insert(1);
		mh.insert(-1);
		mh.remove();
		mh.remove();
		mh.printHeap();
		mh.minHeap();
		mh.printHeap();
	}
}
