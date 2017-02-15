/*
  * arrange students into a chorus line ordered by height.
*/

public class ChorusFormation{
    int height;
    int stunum;
    boolean stand;
    Node left;
    Node right;
    Node parent;
    
    public ChorusFormation(boolean stand,int height,int stunum){
        this.stand = stand;
        this.height = height;
        this.stunum = stunum;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
    public void arrange(Student students){
        if(students == null){
            return;
        }
        if(students.height >= this.height){
            this.left = new Node(true,students.height,this.stunum + 1);
            this.left.parent = this;
            this.left.arrange(students.next);
        }
        this.right = new Node(false,this.height,this.stunum);
        this.right.parent = this;
        this.right.arrange(students.next);
    }

    public Node findMax(){
        if(right == null && left == null){
            return this;
        }
        if(left == null){
            return right.findMax();
        }
        Node r1 = left.findMax();
        Node r2 = right.findMax();
        if(r1.stunum >= r2.stunum){
            return r1;
        }else{
            return r2;
        }
    }
    
     public boolean[] flashBack(int num){
        boolean[] result = new boolean[num];
        int i = num - 1;
        Node search = this;
        while(i >= 0){
            result[i] = search.stand;
            i--;
            search = search.parent;
        }
        return result;
    }
    
    
}

class Student{
    public int height;
    public Student next;
    
    public Student(int height){
        this.height = height;
        this.next = null;
    }
    
    public int getNum(){
        Student search = this;
        int i = 0;
        while(search != null){
            i++;
            search = search.next;
        }
        return i;
    }
}
