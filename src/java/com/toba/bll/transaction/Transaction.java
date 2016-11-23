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
    @JoinColumn(name = "AccountID")
    @ManyToOne
    private Account account;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    //private Long destinationAccountId;
    //private double sourceAccountBalance;
    //private double destinationAccountBalance;

    public Transaction() {
    }
    
    public Transaction(Account sourceAccount, double amount)
    {
        this.amount = amount;
        this.account = sourceAccount;
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

    public Account getAccount()
    {
        return this.account;
    }
    
    public void setAccount(Account account)
    {
        this.account = account;
    }
    
    public Date getTransactionDate()
    {
        return this.transactionDate;
    }
    
    public void setTransactionDate(Date date) {
        this.transactionDate = date;
    }
    
/*    
    public Long getDestinationAccountId()
    {
        return this.destinationAccountId;
    }
    
    public void setDestinationAccountId(Long destinationAccountId)
    {
        this.destinationAccountId = destinationAccountId;
    }
    
    public double getSourceAccountBalance()
    {
        return this.sourceAccountBalance;
    }
    
    public void setSourceAccountBalance(Long sourceAccountBalance)
    {
        this.sourceAccountBalance = sourceAccountBalance;
    }
    
    public double getDestinationAccountBalance()
    {
        return this.destinationAccountBalance;
    }
    
    public void setDestinationAccountBalance(Long destinationAccountBalance)
    {
        this.destinationAccountBalance = destinationAccountBalance;
    }
*/
}