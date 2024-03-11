package org.example;

public class Dorm {
    private final int dormId;
    private final String dormName;
    int price;

    public Dorm(int dormId, String dormName, int price)
    {
        this.dormId = dormId;
        this.dormName = dormName;
        this.price = price;
    }

    public int getDormId()
    {
        return dormId;
    }

    public String getDormName()
    {
        return dormName;
    }

    public int getPrice()
    {
        return price;
    }
}
