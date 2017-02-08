package algorithms;

public class BinarySearch {

	public int binarySearch(int[] list , int num){
		int l = list.length;
		if(l <= 1){
			if(list[0] == num){
				return 0;
			}else{
				return -1;
			}
		}
		int mid = l/2;
		if(num == list[mid]){
			return mid;
		}else if(num > list[mid]){
			return search(list,num,mid+1,l);
		}else{
			return search(list,num,0,mid);
		}
	}
	
	private int search(int[] list , int num,int low,int high){
		int l = high - low ;
		if(l <= 1){
			if(list[low] == num){
				return 0;
			}else{
				return -1;
			}
		}
		int mid = (low + high)/2;
		if(num == list[mid]){
			return mid;
		}else if(num > list[mid]){
			return search(list,num,mid+1,high);
		}else{
			return search(list,num,low,mid);
		}
	}
}
