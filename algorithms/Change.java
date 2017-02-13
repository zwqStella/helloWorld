/*
  * an algorithm to get best (least coins) changes while buying things.
*/

public class Change{
    double num;
    int num25;
    int num10;
    int num5;
    int num1;
    
    public Change(){
        num = 0;
        num25 = 0;
        num10 = 0;
        num5 = 0;
        num1 = 0;
    }
    
    public static Change getChange(double num){
    	num = num*100;
        Change change = new Change();
        change.num = num;
        while(num > 0){
            if(num >= 25){
                change.num25++;
                num -= 25;
            }else if(num >= 10){
                change.num10 ++;
                num -= 10;
            }else if(num >= 5){
                change.num5 ++;
                num -= 5;
            }else if(num >= 1){
                change.num1 ++;
                num -= 1;
            }else{
                break;
            }
        }
        Change.showChange(change);
        return change;
    }
    
    public static void showChange(Change change){
         System.out.println("两角五分的： " + change.num25);
         System.out.println("一角的： " + change.num10);
         System.out.println("五分的： " + change.num5);
         System.out.println("一分的： " + change.num1);
         System.out.println("总共： " + change.num);
    }
}
