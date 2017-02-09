package algorithms;

public class MergeSort{

   public void mergesort(int[] numbers){
       sort(numbers,0,numbers.length-1);
       for(int i = 0; i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
   }
   
   public void sort(int[] numbers,int low,int high){
       int mid = (low + high)/2;
       if(low<high){
           sort(numbers,low,mid);
           sort(numbers,mid+1,high);
           merge(numbers,low,mid,high);
       }
   }
   
   public static void merge(int[] numbers,int low,int mid,int high){
       int i = low,j = mid+1;//搜索指针
       int k = 0;//数据存入指针
       int[] newlist = new int[high-low+1];
       while(i <= mid && j <= high){
           if(numbers[i] < numbers[j]){
               newlist[k] = numbers[i];
               i++;k++;
           }else{
               newlist[k] = numbers[j];
               j++;k++;
           }
       }
       while(i <= mid){
           newlist[k] = numbers[i];
           i++;k++;
       }
       while(j <= high){
           newlist[k] = numbers[j];
           j++;k++;
       }
       for(k = 0;k < high-low+1;k++){
           numbers[low+k] = newlist[k];
       }
   }
}
