/* 
  *Greedy algorithm for single source shortest path
*/
package algorithms;

public class ShortestPath{
    private int number;
    private int[][] matrix;
    
    public Graph(int number,int[][] matrix){
        this.number = number; 
        this.matrix = matrix.clone();
    }
    
    public boolean exist(int num,int[] nums){
        for(int i = 0;i < nums.length;i++){
            if(num == nums[i])
                return true;
        }
        return false;
    }
    
    public int[] getShortestPath(int start){
        if(start > number)
            return null;
        int[] result = new int[number];
        result[0] = start;
        int temp = 100000;
        for(int j = 1;j < number;j++){
            for(int i = 0;i < number;i++){
                if(matrix[start][i] > 0 && matrix[start][i] < temp && !exist(i,result)){
                    temp = matrix[start][i];
                    result[j] = i;
                }
            }
            temp = 100000;
            start = result[j];
        }
        return result;
    }
}
