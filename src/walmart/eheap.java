package walmart;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class eheap {
	private List<Float> heap;
	private int size;
	private int childrin;
	
	private float max_val;
	private int max_pos;
	
	eheap(int size) {
		heap = new ArrayList<Float>();
		this.size = size;
		this.childrin = 2 << (size-1);
	}
	
	private IntStream getChildren(int pos) {
		return IntStream.rangeClosed(childrin*pos+1, childrin*pos+childrin);
	}
	
	private int getParent(int pos) {
		if (pos % childrin == 0) {
			return (pos / childrin) - 1;
		} else {
			return pos / childrin;
		}
	}
	
	public float peek() {
		return heap.get(0);
	}
	
	private void swap(int pos1, int pos2) {
		float value2 = heap.get(pos2);
		heap.set(pos2, heap.get(pos1));
		heap.set(pos1, value2);
	}
	
	public void push(float value) {
		int pos = heap.size();
		int parent = getParent(pos);
		heap.add(value);
		if (parent < 0 | pos == 0 ) {
			return;
		}
		while (heap.get(pos) >  heap.get(parent) ) {
			swap(pos,parent);
			pos = parent;
			parent = getParent(pos);
			if (parent < 0) {
				return;
			}
		}
	}
	
	private void getMax(int i) {
		if (i >= heap.size()) {
			return;
		}
		if (heap.get(i) > max_val) {
			max_val = heap.get(i);
			max_pos = i;
		}
	}
	
	
	public float pop() {
		if (heap.size() <= 0) {
			return Float.NaN;
		} 
		float value = this.peek();
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		if (heap.size() <= 0) {
			return value;
		}
		int pos = 0;
		while (true) {
			IntStream children = this.getChildren(pos);
			max_val = heap.get(pos);
			max_pos = -1;
			children.forEach(this::getMax);
			if (max_pos == -1) {
				return value;
			} else {
				this.swap(pos, max_pos);
				pos = max_pos;
			}
		}
	}
}
