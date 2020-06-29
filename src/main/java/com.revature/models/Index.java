package com.revature.models;

import java.io.Serializable;


public class Index implements Serializable {

    int num = 0;

    public Index() {
    }

    public Index(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Index{" +
                "num=" + num +
                '}';
    }
}

