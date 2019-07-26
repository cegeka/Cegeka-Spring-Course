# Spring festival

The Spring festival starts today. 
Over 50.000 people are expected to attend the concerts and other fun activities.
Some computer problems might ruin the fun for everyone, though. 
It's up to you to make sure that does not happen.

a. All attendees get a goodie bag (as long as stock lasts).
Attendees with a regular ticket receive a goodie bag with:
 - a pair of sunglasses
 - 1 food/drink voucher
 - a cap <br/> <br/>
Attendees with a VIP ticket receive the same goodie bag with some extra items:
- a bottle of champagne
- a tent
- 5 food/drink vouchers instead of 1 <br />

Implement the GoodieBagController's methods. 
The controller calls the service and the service calls the manager. 
The manager should grab the necessary items out of the GoodiebagStock and return it to the service.
The service should return the goodiebag to the controller, but not before he sends an event indicating that a goodie bag (of type regular or vip) was just retrieved.
The stock should listen to this event(s) and update its stock accordingly.
All of this should happen synchronously.

b. Attendees can also buy additional (virtual) foodvouchers. 
To prevent overloading the infrastructure of the financial institutions, the bank accounts of the voucher buyers should be emptied asynchronously.
If it turns out their bank balance is lower than the cost of the vouchers, the system should cancel the vouchers of the buyer.
If the vouchers are already spent by the time they would be recalled, that's a loss the festival has to take.    

Start in the VoucherController and see where you should send this event and what data should be on it.

The BankAccountService has a Thread.sleep of 3 seconds. 
If everything is implemented correctly, this delay should not impact the speed of the REST call.

You can call the VoucherAndBankBalanceController to see if both voucher and bank balance are correct after a person has bought vouchers.
