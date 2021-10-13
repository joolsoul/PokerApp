package ru.vsu.kudinov_i_m.model;

public class Player
{
    private String name;

    private int balance;

    public Player(String name, int balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
