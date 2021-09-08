import java.io.IOException;
import java.lang.NullPointerException;

public class MyInt {
    private int num;
    private int radix;
    public String[] lit;

    private char[] x;
    private char[] b;

    public MyInt(String literal){
        this.radix = getRadix(literal);
        this.num = getNum(literal);
    }

    public static void main(String[] args) {
        MyInt n1 = new MyInt("0b1010");
        MyInt n2 = new MyInt("0xA");
        MyInt n3 = n1.add(n2);
        System.out.println(n3.toString(8));
    }

    public int getRadix(String st){
        try{
            for(int i = 0; i < st.length(); i++){
                lit[i] = String.valueOf(st.charAt(i));
            }
            if(lit[0] == String.valueOf(0)){
                if(lit[1] == String.valueOf(x)){
                    this.radix = 16;
                }
                else if(lit[1] == String.valueOf(b)){
                    this.radix = 2;
                }
                else{
                    this.radix = 8;
                }
            }
            else{
                this.radix = 10;
            }
        }catch (NullPointerException e){

        }
        return this.radix;
    }

    public int getNum(String st){
        for(int i = 0; i < st.length(); i++){
            lit[i] = String.valueOf(st.charAt(i));
        }
        if(this.radix == 16){
            this.num = Integer.parseInt(st.substring(2));
        }
        if(this.radix == 8){
            this.num = Integer.parseInt(st.substring(1));
        }
        if(this.radix == 2){
            this.num = Integer.parseInt(st.substring(2));
        }
        else{
            this.num = Integer.parseInt(st);
        }

        return Integer.parseInt(String.valueOf(this.num));
    }

    public MyInt add(MyInt myInt){
        int sum;
        String out;
        sum = myInt.num + this.num;
        if(this.radix == 16){
            out = Integer.toHexString(sum);
        }
        if (this.radix == 8) {
            out = Integer.toOctalString(sum);
        }
        if(this.radix == 2){
            out = Integer.toBinaryString(sum);
        }
        else{
            out = String.valueOf(sum);
        }

        return new MyInt(out);
    }

    public MyInt subtract(MyInt myInt){
        int sub;
        String out;
        sub = myInt.num - this.num;
        if(this.radix == 16){
            out = Integer.toHexString(sub);
        }
        if (this.radix == 8) {
            out = Integer.toOctalString(sub);
        }
        if(this.radix == 2){
            out = Integer.toBinaryString(sub);
        }
        else{
            out = String.valueOf(sub);
        }

        return new MyInt(out);
    }


    public String toString(){
        System.out.println(String.valueOf(radix));
        return String.valueOf(radix);
    }

    public String toString(int red){
        String st = null;
        if(red == 2){
            st = Integer.toBinaryString(this.num);
        }
        if(red == 8){
            st = Integer.toOctalString(this.num);
        }
        if(red == 16){
            st = Integer.toHexString(this.num);
        }
        if(red == 0){
            st = String.valueOf(this.num);
        }
        
        return st;
    }
}






