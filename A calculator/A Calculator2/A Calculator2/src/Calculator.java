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
            case SPECIAL : {
                int x = stack.pop();
                x *=2;
                if (x >= 10 ){
                    int x3 = x % 10;
                    int x4 = x / 10;
                    x = (x3+x4);
                }
                stack.push(x);
                break;
            }
            case MOD : {
                int x = stack.pop();
                stack.push(x % 10);
                break;
            }
        }
    }    
    public static void main(String[] args) {
        Item value3 = new Item(ItemType.VALUE, 3);
        Item value4 = new Item(ItemType.VALUE,4);
        Item value2 = new Item(ItemType.VALUE,2);
        Item value9 = new Item(ItemType.VALUE, 9);
        Item value1 = new Item(ItemType.VALUE, 1);
        Item value0 = new Item(ItemType.VALUE, 0);
        Item value6 = new Item(ItemType.VALUE, 6);
        Item value10 = new Item(ItemType.VALUE, 10);
        Item value5 = new Item(ItemType.VALUE, 5);
        Item value7 = new Item(ItemType.VALUE, 7);
        Item value8 = new Item(ItemType.VALUE, 8);


        Item add1 = new Item(ItemType.ADD,0);
        Item mul1 = new Item(ItemType.MUL, 0);
        Item spec1 = new Item(ItemType.SPECIAL, 0);
        Item sub1 = new Item(ItemType.SUB, 0);
        Item mod1 = new Item(ItemType.MOD, 0);

        Item[] expr = {value10, value5, spec1, value6, add1, value0, spec1, add1, value8, add1, value0, spec1, add1, value8, add1, value2, spec1, add1, value7, add1, value9, spec1, add1, mod1, sub1};
        //Item[] expr = {value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, add1};
        Calculator calculate = new Calculator(expr);

        System.out.println(calculate.run());
        //System.out.println(calculate.benchmark());
        
    }
}