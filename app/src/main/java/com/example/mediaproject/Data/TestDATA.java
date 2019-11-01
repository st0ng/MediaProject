package com.example.mediaproject.Data;

import java.util.HashMap;
import java.util.Map;

public class TestDATA {
    String a;
    String b;
    String c;

    public TestDATA(String a , String b, String c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public Map<String , Object> toMap()  {
        HashMap<String, Object> result = new HashMap<>();
        result.put("a" , a);
        result.put("b", b);
        result.put("c",c);
        return result;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }



}
