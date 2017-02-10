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
        for(int s=0; s<n; s++)  
        {  
        	teams /= 2;  
            for(int t=0; t<teams; t++)  
            {  
                for(int i=m; i<2*m; i++) 		//row number
                {  
                    for(int j=m; j<2*m; j++) 		//line number
                    {  
                        table[j+t*m*2][i] = table[j+t*m*2-m][i-m]; 
                        table[j+t*m*2-m][i] = table[j+t*m*2][i-m]; 
                    }  
                      
                }  
            }  
            m *= 2;  
        } 
    }  
}
