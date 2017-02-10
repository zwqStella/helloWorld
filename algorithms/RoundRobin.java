/*
     * round robin game arrangement, 2^n only.
*/

public class RoundRobin{
  public void arrange(int n)  {  		
		int teams = (int) Math.pow(2, n); 		//the number of teams
		int [][] table = new int[teams][n+1]; 		//the table to store results
		
        for(int i = 0; i < teams; i++) {
        	  table[i][0]=i;  		//initialize the first line with the teams' name
        }
        
        int m = 1; 
        for(int s=1; s<=n; s++)  
        {  
        	teams /= 2;  
            for(int t=1; t<=teams; t++)  
            {  
                for(int i=m+1; i<=2*m; i++) 
                {  
                    for(int j=m+1; j<=2*m; j++) 
                    {  
                        table[i][j+(t-1)*m*2] = table[i-m][j+(t-1)*m*2-m]; 
                        table[i][j+(t-1)*m*2-m] = table[i-m][j+(t-1)*m*2]; 
                    }  
                      
                }  
            }  
            m *= 2;  
        }  
    }  
}
