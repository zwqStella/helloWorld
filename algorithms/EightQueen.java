/*
  * eight queen deposit problem
*/

public class EightQueen{
    boolean[] result;
    int queenNum;
    Solution left;
    Solution right;
    
    public EightQueen(){
        this.result = new boolean[64];       
        for(int i = 0;i < 64;i++){
            result[i] = false;
        }
        this.queenNum = 0;
        this.left = null;
        this.right = null;
    }
    
    public EightQueen(EightQueen s){
        this.result = s.result.clone();
        this.queenNum = s.queenNum;
        this.left = null;
        this.right = null;
    }
    
    public boolean canPut(int current){
        int i = 0;
        while(i < current){
            while(this.result[i] == false && i < current){
                i++;
            }
            if(i < current && (i%8 == current%8 || i/8 == current/8 || Math.abs(i%8 - current%8) ==  Math.abs(i/8 - current/8))){
                return false;
            }else{
                i++;
            }
        }
        return true;
    }
    
    public void arrange(int current){
        if(current >= 64){
            return;
        }
        if(this.canPut(current)){
            this.left = new Solution(this);
            this.left.result[current] = true;
            this.left.queenNum ++;
            this.left.arrange(current + 1);
        }
        this.right = new Solution(this);
        this.right.arrange(current + 1);
    }
    
    public void findSolutions(ArrayList<EightQueen> result){
        if(this.right == null && this.left == null){
            if(this.queenNum == 8){
                result.add(this);
            }
            return;
        }
        if(this.left != null){
            this.left.findSolutions(result);
        }        
        this.right.findSolutions(result);
    }
    
    public static void showSolutions(ArrayList<EightQueen> result){
        System.out.println(result.size());
    }
}
