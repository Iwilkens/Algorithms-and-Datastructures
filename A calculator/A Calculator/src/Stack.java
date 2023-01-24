public class Stack {
    private int[] stack = new int[10];
    public int sp = -1;

    public void push(int value){
        if(sp == 10){
            System.out.println("STACKOVERFLOW!");
            return;
        } 
        sp++;
        stack[sp] = value;
    }
    
    public int pop(){
        if(sp == -1){
            return Integer.MIN_VALUE;
        }
        int value = stack[sp];
        sp--;
        return value;
    } 

    public void resetStack(){
        sp = -1;
    }
}