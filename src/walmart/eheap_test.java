package walmart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class eheap_test {

	float[] list = {-12,1,10,0,12,34,25,24,1,43,123,43,1234,321,356,1,10,0,12,34,25,24,1,43,123,43,1234,321,356};
	float[] listSorted = {1234,1234,356,356,321,321,123,123,43,43,43,43,34,34,25,25,24,24,12,12,10,10,1,1,1,1,0,0,-12};
	
	long start;
	
	@BeforeEach
    public void start() {
        start = System.currentTimeMillis();
    }

	
	@Test
	void correct_vales_size_1() {
		eheap heap = new eheap(1);
		for (int i = 0; i < 50; i++) {
			for (float val : list) {
				heap.push(val);
			}
			
			for (float val : listSorted) {
				assertEquals(heap.pop(),val);
			}
		}
		
		assertTrue(start-System.currentTimeMillis() < 50);
	}
	
	@Test
	void correct_vales_size_1() {
		eheap heap = new eheap(1);
		for (int i = 0; i < 50; i++) {
			for (float val : list) {
				heap.push(val);
			}
			
			for (float val : listSorted) {
				assertEquals(heap.pop(),val);
			}
		}
		
		assertTrue(start-System.currentTimeMillis() < 50);
	}
	
	@Test
	void correct_vales_size_1() {
		eheap heap = new eheap(1);
		for (int i = 0; i < 50; i++) {
			for (float val : list) {
				heap.push(val);
			}
			
			for (float val : listSorted) {
				assertEquals(heap.pop(),val);
			}
		}
		
		assertTrue(start-System.currentTimeMillis() < 50);
	}
	

}
