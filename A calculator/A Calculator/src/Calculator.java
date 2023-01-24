public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;
    int k = 1_000_000;
    long t0 = System.nanoTime();
    long t_total = 0;
    
    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack();
    }

    public int run() {
        while ( ip < expr.length ) {
        step();
        }
        return stack.pop();
    }

    public double benchmark(){
        for (int i = 0; i < k; i++){
            run();
            resetPointer();
            stack.resetStack();
        }
        t_total = (System.nanoTime() - t0);
        return t_total/(double)k;
    }
    
    public void resetPointer(){
        this.ip = 0;
    }



    public void step() {
        Item nxt = expr[ip++];

        switch(nxt.type) {
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE : {
                stack.push(nxt.value);
                break;
            }
        }
    }    
    public static void main(String[] args) {
        Item value3 = new Item(ItemType.VALUE, 3);
        Item value4 = new Item(ItemType.VALUE,4);
        Item value2 = new Item(ItemType.VALUE,2);

        Item add1 = new Item(ItemType.ADD,0);
        Item mul1 = new Item(ItemType.MUL, 0);

        Item[] expr = {value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, add1};

        
        Calculator calculate = new Calculator(expr);
        //System.out.println(calculate.run());

        System.out.println(calculate.benchmark());
    }
}