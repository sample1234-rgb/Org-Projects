package com.springrest.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
    public int pid;
    public String pname;

    public Product(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void print(){
        System.out.println("Hello Person");
    }
}
