package com.typstudy.java1;

import java.io.Serializable;

/**
 * @author typ
 * @date 2019/5/25 20:36
 * @Description: com.typstudy.java1
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -5230641655458323254L;
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
