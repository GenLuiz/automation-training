Meta:

Narrative:
As a customer of the bank
I want to perform a loan
So that I can get certain amount of money

Scenario: User should perform a loan
Given User is on loan page
And User clicks on targetAccount
And User select his account <cpfNumber>
And User fill the amountInput <amountValue>
And User have a balance equals to <balance>
When User clicks on makeLoanButton
Then the system should <status> the request
And show the message <message>
Examples:
| cpfNumber   | amountValue | balance | status  | message                                                                              |
| 07249738933 |    600      |   2000  | Approve | Operation completed with success                                                     |
| 07249738933 |    500      |   2000  | Deny    | There is a pending loan for this account                                             |
| 12345678910 |    650      |   2000  | Deny    | The requested loan ammount exceeds the available credit limit                        |
| 12345678910 |    300      |   2000  | Approve | Operation completed with success                                                     |
| 12345678911 |    300      |   1900  | Deny    | Insufficient balance in account for the loan operation. Minimum of $2000 is required |
