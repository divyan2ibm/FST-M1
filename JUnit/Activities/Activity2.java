package Session1;

import org.junit.jupiter.api.Test;
import Session1.BankAccount;
import Session1.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
       
        BankAccount account = new BankAccount(9);

       
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
       
        BankAccount account = new BankAccount(100);
   
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}