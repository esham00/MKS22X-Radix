import java.util.*;
public class Radix {
    @SuppressWarnings("unchecked")
    public static void radixsort(int[] data) {
	MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
	for(int i = 0; i < buckets.length;i++) {
	    buckets[i] = new MyLinkedList();
	}
	for(int i = 0; i < data.length; i++) {
	    System.out.println(data[i]);
	    int digit = getValue(data[i], (int)Math.pow(10, 1));
	    //System.out.println(digit);
	    if (data[i] < 0) {
		buckets[9-digit].add(data[i]);
		System.out.println(buckets[9-digit]);
	    } else {
		buckets[digit+10].add(data[i]);
		System.out.println(buckets[10+digit]);
	    }
	}
	
    }
    private static int getValue(int value, int mod){
	return value%mod;
    }
    public static void main(String[] args) {
	int[] a = new int[]{10,9,3,4,5,2,1};
	radixsort(a);
	System.out.print(Arrays.toString(a));
    }
}
	
