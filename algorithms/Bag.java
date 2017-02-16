/*
  * simple 0-1 bag problem.
*/

oublic class Bag{
    public int cap;
    public int maxcap;
    public int value;
    
    public Bag(int c){
        this.cap = 0;
        this.value = 0;
        this.maxcap = c;
    }
    
    public Node arrange(Good goods){
        Node root = new Node();
        load(goods,root,0);
        unLoad(goods,root,0);
        return root;
    }
    
    public void load(Good goods,Node root,int current){
        if(goods != null && cap + goods.weight <= maxcap){
            cap += goods.weight;
            value += goods.value;
            root.left = new Node(root);
            root.left.value = value;
            root.left.list[current] = goods.ID;
            //System.out.println(goods.weight + " is load,v is " +value);
            load(goods.next,root.left,current + 1);
            unLoad(goods.next,root.left,current + 1);
            cap -= goods.weight;
            value -= goods.value;
        }//else{
            //System.out.println("return: " +value);  
        //}
    }
    
    public void unLoad(Good goods,Node root,int current){        
        if(goods != null){
            root.right = new Node(root);
            root.right.list[current] = -1;
            //System.out.println(goods.weight + " is not load,v is " +value);
            load(goods.next,root.right,current + 1);
            unLoad(goods.next,root.right,current + 1);
        }
    }
}

class Node{
    public int value;
    public int[] list;
    public Node left;
    public Node right;
    
    public Node(){
        this.value = 0;
        this.list = new int[0];
        this.left = null;
        this.right = null;
    }
    
    public Node(Node root){
        this.value = root.value;
        this.list = new int[root.list.length + 1];
        for(int i = 0; i < root.list.length; i++){
            this.list[i] = root.list[i];
        }
        this.left = null;
        this.right = null;
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
        if(r1.value >= r2.value){
            return r1;
        }else{
            return r2;
        }
    }
}

class Good{
    public static int IDcount = 0;
    public int ID;
    public int weight;
    public int value;
    public Good next;
    
    public Good(int w,int v){
        this.ID = IDcount++;
        this.weight = w;
        this.value = v;
        this.next = null;
    }
    
    public int getNum(){
        Good search = this;
        int i = 0;
        while(search != null){
            i++;
            search = search.next;
        }
        return i;
    }

}
