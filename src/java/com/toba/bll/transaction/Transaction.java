package com.toba.bll.transaction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @JoinColumn(name = "SourceAccountID")
    @ManyToOne
    private Account sourceAccount;

    @JoinColumn(name = "DestinationAccountID")
    @ManyToOne
    private Account destinationAccount;
    
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    public Transaction() {
    }
    
    public Transaction(Account sourceAccount, Account destinationAccount, double amount)
    {
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionDate = new Date();
    }
    
    public Long getTransactionId()
    {
        return this.transactionId;
    }
    
    public void setTransactionId(Long transactionId)
    {
        this.transactionId = transactionId;
    } 

    public double getAmount()
    {
        return this.amount;
    }
    
    public void setAmount(double amount)
    {
        this.amount = amount;
    }    

    public Account getSourceAccount()
    {
        return this.sourceAccount;
    }
    
    public void setSourceAccount(Account sourceAccount)
    {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount()
    {
        return this.destinationAccount;
    }
    
    public void setDestinationAccount(Account destinationAccount)
    {
        this.destinationAccount = destinationAccount;
    }
    
    public Date getTransactionDate()
    {
        return this.transactionDate;
    }
    
    public void setTransactionDate(Date date) {
        this.transactionDate = date;
    }
}