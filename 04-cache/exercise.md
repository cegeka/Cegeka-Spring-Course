# Cold hard cash

Canneloani and sons is a bank has millions of customers over Europe. 
Their transaction overview system has become quite slow, recently.
Maybe caching can help them speed up the call?

1. In TransactionService, make getAllTransactionsForUser respond faster if it is called twice for the same user in a short amount of time.
2. Do the same for getAllTransactionsStartedByUser.
3. Now run getAllTransactionsByUserInPound a few times. <br /> 
Wait...are the values changing?
That should not happen...
4. Implement the clearCache method in cacheController. 
It should clear the cache whose name was passed through in the REST call. 
5. Implement the preCache method. 
It allows a cache whose name was passed to be filled programmatically. 
The key is the id that is provided, the value can be an empty list.