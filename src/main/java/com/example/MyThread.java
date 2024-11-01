package com.example;

public class MyThread extends Thread{
    


    public MyThread(){

    }

    public void run(){

        

    }

    public String cambia(String s){
        return s.equalsIgnoreCase("ciao") ? "Si" : "No";
    }

    public int incrementa(int x){
        do {
            System.out.println(x);
            if(x == 100)
                return x;
            x++;
        } while (true);
    }
}
