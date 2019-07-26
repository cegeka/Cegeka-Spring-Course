# Synchronized diving

The synchronized diving world championship is upon us once again. 
Men and women will perform elegant twists and turns in order to receive the highest possible scores from a panel of judges.
You have to make sure no erros with the registration of the teams are possible.

1. Teams have to register before they are allowed to enter. 
Make sure only valid TeamRegistrations are allowed (TeamRegistrationController).
    1. All fields are required
    2. Worldranking has to be between 1 and 100
    3. Email has to be valid
    4. They are allowed to bring up to 3 entourage members
2. Also validate if the url parameter 'league' is valid. The league has to be 1,2,3,4 or 5.
3. Teams also have to submit the 'dives' they will attempt to perform during the championship.
They can later update them. After creating a dive, it will be assigned an ID by the system, so it knows which dive it should update when the update call is used.
When creating a dive, we should validate if the difficulty is between 5 and 10 and if the name is not null. 
When updating we should check if the difficulty is between 7 and 10. 
Validate this at domain level.
4. Registrations from Russia and Lichtenstein are to be denied.
5. After some previous incidents, registrations from North-Korea and Peru are no longer allowed to bring any entourage with them.

 