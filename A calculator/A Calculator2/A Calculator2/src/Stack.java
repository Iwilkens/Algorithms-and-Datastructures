public class Stack {
    private int[] stack = new int[4];
    int stackSize = 4;
    private int sp = -1;

    public void push(int value){
        if(sp == (stackSize-1)){
            extendStack();
        } 
        sp++;
        stack[sp] = value;
    }

    public int pop(){
        if(sp == -1){
            return Integer.MIN_VALUE;
        }
        if( stackSize >= 4 && sp <= (stackSize/4)){
            reduceStack();
        }
        int value = stack[sp];
        sp--;
        return value;
    }

    private void extendStack(){
        stackSize = stackSize*2;
        int[] tempStack = new int[stackSize];
        for (int i=0; i < (stackSize/2); i++){
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }

    private void reduceStack(){
        stackSize = stackSize/2;
        int[] tempStack = new int[stackSize];
        for (int i=0; i < stackSize; i++){
            tempStack[i]= stack[i];
        }
        stack = tempStack;       
    }

    public void resetStack(){
        sp = -1;
    }
    
}
