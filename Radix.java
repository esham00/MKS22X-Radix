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
	System.out.println(merge);
	for(int i = 0; i < largestDigit;i++) {
	    for(int a = 0; a < merge.size(); a++) {
		int removed = merge.removeFront();
		int digit = getValue(removed, (int)Math.pow(10, i+1));
		if (removed < 0) {
		    buckets[9-digit].add(removed);
		} else {
		    System.out.println(removed);
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
	System.out.println(mod);
        if (mod != 10 && value % mod == value) {
	     return 0;
	} else {
	    return Math.abs(value%mod);
	}
    }
    private static int length(int value) {
	int num = Math.abs(value);
	return (int)(Math.log10(num)+1);
    }
    private static void combine(MyLinkedList<Integer> a, MyLinkedList<Integer>[] b) {
	//try {
	for(int i = 0; i < b.length; i++) {
	    if (b[i].size() > 0) {
		a.extend(b[i]);
	    }
	    //System.out.println("merge in combine" + a);
	}
	// } catch (NullPointerException e) {
	//     System.out.println("element failure:" + b[tracker]);
	//     //System.out.println(a);
	//     System.out.println(tracker);
	// }
    }
    public static void main(String[] args) {
	// MyLinkedList x = new MyLinkedList();
	// x.add(1);
	// MyLinkedList b = new MyLinkedList();
	// b.extend(x);
	// System.out.println(b);
	int[] a = new int[]{10,9,3,4,5,2,1,6,7,8};
	radixsort(a);
	System.out.print(Arrays.toString(a));
    }
}
