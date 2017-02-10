/*
     * round robin game arrangement, 2^n only.
*/

public class RoundRobin{
  public void race(int k){
        int[][] table = new int[2*k][2*k];
        for(int i = 0;i < 2*k ;i++){
            table[i][0]= i;
        }
        arrange(table,0,2*k-1,0,2*k-1);
        for(int i = 0;i < 2*k;i++){
            for(int j = 0;j < 2*k;j++){
                System.out.print("   "+table[i][j]);
            }
            System.out.print("\n");
        }
  }
  
  public void arrange(int[][] table,int days,int date,int start,int end){
        int mid = (start+end)/2;
        if(days < date){
            arrange(table,days,(days+date)/2,start,mid);
            arrange(table,days,(days+date)/2,mid+1,end);
            swap(table,days,date,start,mid,end);
        }
  }
  
  public void swap(int[][] table,int days,int date,int start,int mid,int end){
        if(date - days == 2){
            table[start][days + 1] = table[mid][days];
            table[mid][days + 1] = table[end][days];
            table[end][days + 1] = table[start][days];
            table[start][days + 2] = table[end][days];
            table[mid][days + 2] = table[start][days];
            table[end][days + 2] = table[mid][days];
        }else{
            int i = start,j = mid+1;
            int m = days,n = (days+date)/2 + 1;
            while(n <= date){
                while(j <= end){
                    table[i][n] = table[j][m];
                    table[j][n] = table[i][m];
                    i++;j++;
            }
            i = start;j = mid+1;
            m++;n++;
        }
        }
  }
  
}
