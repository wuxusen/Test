package mock;

import javax.transaction.InvalidTransactionException;

public class Transaction {



    public void testExecute_with_TransactionIsExpired() {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction() {

            @Override
            protected boolean isExpired() {
                return true;
            }
        };

    }





    private Long createdTimestamp;

    private STATUS status;

    public static Long days = 111L;




    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createdTimestamp > days;
    }

    public boolean execute() throws InvalidTransactionException {
        //...
        if (isExpired()) {
            this.status = STATUS.EXPIRED;
            return false;
        }
        //...

        return false;
    }
}

enum STATUS{
    EXPIRED
}
