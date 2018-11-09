import java.util.Arrays;

public class ArraysLab3 {
	public static void main (String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {4,5,6,7,8};
		System.out.println(Arrays.toString(sum(arr1,arr2)));
		System.out.println(Arrays.toString(append(arr1,6)));
		System.out.println(Arrays.toString(remove(arr1,1)));
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
				newArray[counter]=newArray[i];
				counter++;
			}
		}
		return newArray;
		
	}
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0) {
				sum = arr[i] + sum;
			}
		}
		return sum;
	}
	public static void rotateRight(int[] arr) {
		int last = arr[arr.length-1];
		for(int i = arr.length-2; arr)
	}


}
