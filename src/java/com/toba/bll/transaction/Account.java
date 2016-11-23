package com.toba.bll.transaction;

import com.toba.bll.authentication.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @JoinColumn(name = "UserID")
    @ManyToOne
    private User accountOwner;
    private String accountType;
    private double balance;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    List<Transaction> transactions;

    public Account()
    {
    }
    
    public Account(String accountType, double startingBalance, User accountOwner)
    {
        this.accountOwner = accountOwner;
        this.accountType = accountType;
        this.balance = startingBalance;
    }
    
    public Long getAccountId()
    {
        return this.accountId;
    }
    
    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }
    
    public double getBalance()
    {
        return this.balance;
    }
    
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public User getAccountOwner()
    {
        return this.accountOwner;
    }
    
    public void setAccountOwner(User accountOwner)
    {
        this.accountOwner = accountOwner;
    }

    public String getAccountType()
    {
        return this.accountType;
    }
    
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }
    
    public List<Transaction> getTransactions() {
        return this.transactions;
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public void credit(double amount) {
        this.balance += amount;
    }
    
    public void debit(double amount) {
        this.balance -= amount;
    }
}