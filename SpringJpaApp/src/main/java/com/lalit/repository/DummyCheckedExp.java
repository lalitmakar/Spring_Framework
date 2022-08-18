package com.lalit.repository;

public class DummyCheckedExp extends Exception{

    public DummyCheckedExp(String msg){
        super(msg);
        System.out.println("inside const of dummy exp | Dummy exp raised");
    }

}
