package com.example.shiva.try1;

public class Blog {
    private String order;
    private int tableno;
    private int price;
    private int time;
    public String getOrder() {
        return order;
    }

    public Blog(String order, int tableno,int price) {
        this.order = order;
        this.tableno = tableno;
        this.price=price;
        this.time=time;
    }
    public void setTime(int time){
        this.time=time;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public int getTime(){
        return time;
    }
    public int getPrice(){
        return price;
    }
    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public Blog(){

    }


}
