public class Hash_tables {

    public static int hash(Integer key, int M){
        return key % M;
    }
    
    /* 
    int R= 31;

    public static Integer has(String key, int M){
        char[] chars = key.toCharArray(); //varje char i java är ett 16 bitards tal
        int value= 0;
        for (int i = 0; i < chars.length; i++){
            value = (R*value + chars [i]) %M;

        }
        return value;
    }
    */
}
