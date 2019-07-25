# Cold hard cash

Canneloani and sons is a bank has millions of customers over Europe. 
Their transaction overview system has become quite slow, recently.
Maybe caching can help them speed up the call?

1. In TransactionService, make getAllTransactionsForUser respond faster if it is called twice for the same user in a short amount of time.
2. Do the same for getAllTransactionsStartedByUser.
3. Do the same for getAllTransactionsByUserInPound. Now run it a few times. Wait...are the values changing?

##Extra

1. Instead of directly returning a 403 error when the delete call goes wrong, throw a custom exception and add an errorhandler to return the correct http code.
