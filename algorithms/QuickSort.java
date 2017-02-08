package algorithms;

public class QuickSort {

	public void quickSort(int [] list){
		int l = list.length;
		if(l <= 1){
			return;
		}
		int mid = 0;
		int temp = list[0];
		for(int i = 1; i < l ; i++){
			if(list[i] < temp){
				move(list,0,l,i);
				mid ++;
			}
		}
		sort(list,0,mid);
		sort(list,mid+1,l);
	}
	
	private void sort(int [] list,int low,int high){
		int l = high - low;
		if(l <= 1){
			return;
		}
		int mid = low;
		int temp = list[low];
		for(int i = low+1; i < high ; i++){
			if(list[i] < temp){
				move(list,low,high,i);
				mid ++;
			}
		}
		sort(list,low,mid);
		sort(list,mid+1,high);
	}
	
	private void move(int [] list,int low,int high,int index){
		int temp = list[index];
		for(int i = index ; i > low ; i--){
			list[i] = list[i-1];
		}
		list[low] = temp;
	}
}
