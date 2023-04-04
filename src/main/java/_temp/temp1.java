package _temp;

import readers.property.PropertyReader;

import java.util.List;

import static readers.property.PropertyReader.*;

public class temp1 {

    public void main(String[] args) {
        A aa = new A();
        A aa1 = A.get();

    }



}

class A{

    public static A get(){
        return new A();
    }
}
