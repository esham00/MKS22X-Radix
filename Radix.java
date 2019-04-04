import java.util.*;
public class Radix {
    @SuppressWarnings("unchecked")
    public static void radixsort(int[] data) {
	MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
	MyLinkedList merge = new MyLinkedList[data.length];
	int largestDigit = 0;
	for(int i = 0; i < buckets.length;i++) {
	    buckets[i] = new MyLinkedList();
	}
	for(int i = 0; i < data.length; i++) {
	    int numberOfDigits = length(data[i]);
	    int digit = getValue(data[i], 10);
	    if (numberOfDigits > largestDigit) {
		largestDigit = numberOfDigits;
	    }
	    if (data[i] < 0) {
		buckets[9-digit].add(data[i]);
		//System.out.println(buckets[9-digit]);
	    } else {
		buckets[digit+10].add(data[i]);
		//System.out.println(buckets[10+digit]);
	    }
	}
	merge.extend(buckets);
	for(int i = 0; i < largestDigit;i++) {
	    int removed = merge.remove(i);
	    int digit = getValue(removed, Math.pow(10, i));
	    if (data[i] < 0) {
		buckets[9-digit].add(removed);
	    } else {
		buckets[digit+10].add(removed);
	    }
	    merge.extend(buckets);
	}
	for(int i = 0; i < data.length; i++) {
	    data[i] = merge.remove(i);
	}
	return data;
    }
    private static int getValue(int value, int mod){
	return value%mod;
    }
    private static int length(int value) {
	int num = Math.abs(value);
	return (int)(Math.log10(n)+1);
    }
    public static void main(String[] args) {
	int[] a = new int[]{10,9,3,4,5,2,1};
	radixsort(a);
	System.out.print(Arrays.toString(a));
    }
}
	
