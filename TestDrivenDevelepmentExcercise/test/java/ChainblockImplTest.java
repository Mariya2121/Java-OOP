package TestDrivenDevelepmentExcercise.test.java;

import TestDrivenDevelepmentExcercise.main.java.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void prepare() {
        this.chainblock = new ChainblockImpl();
        transactions = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Sasho", 10);
        Transaction transaction2 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Tosho", 11);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Ivan", "Sasho", 10);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Gosho", "Tosho", 11);
        transactions.add(transaction);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }


    @Test
    public void test_Add_Should_Add_New_Transactions() {
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void test_Add_Should_Not_Add_Duplicate_Transaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0)); // here we also test contains
        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void test_Contains_Should_Return_False() {
        chainblock.add(transactions.get(0));
        boolean result = chainblock.contains(transactions.get(1));
        Assert.assertFalse(result);
    }

    @Test
    public void test_Contains_Should_Return_True() {
        chainblock.add(transactions.get(0));
        boolean result = chainblock.contains(transactions.get(0));

        Assert.assertTrue(result);
    }

    @Test
    public void test_Contains_With_Id_Should_Return_False() {
        chainblock.add(transactions.get(0));
        boolean result = chainblock.contains(transactions.get(1).getId());

        Assert.assertFalse(result);
    }

    @Test
    public void test_Contains_With_Id_Should_Return_True() {
        chainblock.add(transactions.get(0));
        boolean result = chainblock.contains(transactions.get(0).getId());

        Assert.assertTrue(result);
    }

    @Test
    public void test_Change_Transaction_Status_Should_Change_Status() {
        chainblock.add(transactions.get(0));
        chainblock.changeTransactionStatus(transactions.get(0).getId(), TransactionStatus.FAILED);

        Assert.assertEquals(transactions.get(0).getStatus(), TransactionStatus.FAILED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Change_Transaction_Status_Should_Throw_Exception_When_No_Such_Transaction() {
        chainblock.add(transactions.get(0));
        chainblock.changeTransactionStatus(transactions.get(1).getId(), TransactionStatus.FAILED);

    }

    @Test
    public void test_RemoveTransactionById_Should_Remove_Transaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));

        chainblock.removeTransactionById(transactions.get(0).getId());

        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransactionById_Should_Throw_Exception_When_No_Such_Transaction() {
        chainblock.add(transactions.get(0));
        chainblock.removeTransactionById(transactions.get(1).getId());
    }

    @Test
    public void test_GetById_Should_Return_Correct_Transaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));

        Transaction expected = chainblock.getById(0);
        Transaction actual = transactions.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_Should_Throw_Exception_When_No_Such_Transaction() {
        chainblock.getById(3);
    }
}