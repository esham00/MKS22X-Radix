import java.util.*;
public class Radix {
    @SuppressWarnings("unchecked")
    public static void radixsort(int[] data) {
	MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
	MyLinkedList<Integer> merge = new MyLinkedList();
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
	combine(merge, buckets);
	for(int i = 0; i < largestDigit;i++) {
	    for(int a = 0; a < data.length; a++) {
		int removed = merge.removeFront();
		int digit = getValue(removed, (int)Math.pow(10, i));
		if (removed < 0) {
		    buckets[9-digit].add(removed);
		} else {
		    buckets[digit+10].add(removed);
		}
	    }
	    combine(merge,buckets);
	}
	for(int i = 0; i < data.length; i++) {
	    data[i] = merge.removeFront();
	}
    }
    private static int getValue(int value, int mod){
	return value%mod;
    }
    private static int length(int value) {
	int num = Math.abs(value);
	return (int)(Math.log10(num)+1);
    }
    private static void combine(MyLinkedList<Integer> a, MyLinkedList<Integer>[] b) {
	// int tracker = 0;
	// try {
	    for(int i = 0; i < b.length; i++) {
		a.extend(b[i]);
	// 	System.out.println(a);
	// 	tracker++;
	    }
	// } catch (NullPointerException e) {
	//     System.out.println(b[tracker]);
	//     System.out.println(a);
	//     System.out.println(tracker);
	//}
    }
    public static void main(String[] args) {
	int[] a = new int[]{10,9,3,4,5,2,1,6,7,8};
	radixsort(a);
	System.out.print(Arrays.toString(a));
    }
}
