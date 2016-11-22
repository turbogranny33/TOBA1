package com.toba.bll.transaction;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Long accountId;
    private double amount;
    //private Long destinationAccountId;
    //private double sourceAccountBalance;
    //private double destinationAccountBalance;

    public Transaction() {
    }
    
    public Transaction(long accountId, double amount)
    {
        this.amount = amount;
        this.accountId = accountId;
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

    public Long getAccountId()
    {
        return this.accountId;
    }
    
    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
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