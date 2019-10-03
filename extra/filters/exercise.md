# Book club bouncer

You're the owner of an exclusive book club. Only members are allowed to enter and even those members need to have the necessary proof with them to get past the front door.
Luckily, you've recently hired a professional to guard the doors of you club, mister Phil Ter.

1. Read up on Spring's filter mechanism: [bealdung](https://www.baeldung.com/spring-boot-add-filter)
2. Create a filter that checks if the 'MEMBERSHIP_STATUS' header is filled in and if it has a valid status (it should be one of the MembershipStatus enum values). If the header is missing or wrong, throw an exception.
3. Check if the memberId provided in the url is an existing id contained in the MemberRepository. If the header is missing or wrong, throw an exception.
4. Create a filter that logs every access request to console (eg: 'Member <name> wants to enter')
5. The order of the filtering should be: 
    1. Does the memberId exist
    2. Is the membership status correct
    3. Logging to console who wants to enter
    4. Logging to console that the request has successfully completed for the user id (should happen _after_ the request returns)