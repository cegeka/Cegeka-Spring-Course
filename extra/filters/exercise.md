# Book club bouncer

You're the owner of an exclusive book club. Only members are allowed to enter and even those members need to have the necessary proof with them to get past the front door.
Luckily, you've recently hired a professional to guard the doors of you club, mister Phil Ter.

1. Read up on Spring's filter mechanism: [bealdung](https://www.baeldung.com/spring-boot-add-filter)
2. Create a filter that checks if the 'MEMBERSHIP_STATUS' header is filled in and if it has a valid status (it should be one of the MembershipStatus enum values). If the header is missing or wrong, return an HTTP 400 error with a fitting message.
3. Check if the memberId provided in the url is an existing id contained in the MemberRepository. If the header is missing or wrong, return an HTTP 400 error with a fitting message.
4. Create a filter that logs every access request to console (eg: 'Member <name> wants to enter')
5. The order of the filtering should be: 
    1. Does the memberId exist
    2. Is the membership status correct
    3. Logging to console who wants to enter
    4. Logging to console that the request has successfully completed for the user id (should happen _after_ the request returns)
6. Some members tend to forget their credentials, but are old friends of the owner, so they should be able to enter anyway. Create a new rest endpoint on /back-entrance/{id}.
The checks on the header and memberId should not happen when calling this url (so it should be possible to perform a request without those two requirements when calling the backdoor, while the regular entrance should still be secured).

# Handy links

[On determining which filters should be used on which urls](https://www.surasint.com/spring-boot-filter-urlpattern/)    
Spring has its own, similar mechanism, called [Interceptors](https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm)