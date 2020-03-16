package com.copy;


import lombok.Data;

public class CopyingObject {
    public static void main(String[] args) throws CloneNotSupportedException {
        Dummy d1=new Dummy();
        d1.setI(1);
        d1.setJ(2);
        // deep copy i.e new object
        Dummy d2=new Dummy();
        d2.setI(3);
        d2.setJ(4);
       // System.out.println("d1:"+d1+"\n  d2: "+d2);
        // shallow copy
        Dummy d3=d2;
        d3.setI(0);
        //System.out.println("d2 "+d2+" \n d3 "+d3);
        // clone() looks like shallow copy but follows deep copy
        Dummy d4=(Dummy)d2.clone();
        System.out.println("d4 "+d4);
		
    }
}
@Data
class Dummy {
    int i;
    int j;
    @Override
    public    Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}