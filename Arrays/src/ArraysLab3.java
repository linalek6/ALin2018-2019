import java.util.Arrays;

public class ArraysLab3 {
	public static void main (String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		a1 = rotateRight(a1);
		System.out.println("sumArr: " + Arrays.toString(sumArr));
		System.out.println("appendArr: " + Arrays.toString(appendArr));
		System.out.println("removeArr: " + Arrays.toString(removeArr));
		System.out.println("Sum Of Evens: " + sumOfEvens);
		System.out.println("a1: " + Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		return arr3;
	}
	public static int[] append(int[] arr, int num) {
		int[] extend = new int[arr.length+1];
		for(int i = 0; i < arr.length; i++) {
			extend[i] = arr[i];
		}
		extend[extend.length-1]= num;
		return extend;
	}
	public static int[] remove(int[] arr, int idx) {
		int counter = 0;
		int[] newArray = new int[arr.length-1];
		for(int i = 0; i < arr.length; i++) {
			if(i != idx) {
				newArray[counter]=arr[i];
				counter++;
			}
		}
		return newArray;
		
	}
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i+=2) {
			sum = arr[i] + sum;
		}
		return sum;
	}
	public static int[] rotateRight(int[] arr) {
		int last = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0]=last;
		return arr;
	}


}
