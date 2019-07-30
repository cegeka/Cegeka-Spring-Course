1. Go to https://start.spring.io/ and generate a new Spring project. You'll need REST functionalities, h2 db, JPA, webflux and actuator.
2. Change the server port to 5678 and make the h2 database's data persistent over server restarts. Also change the name of the h2 database, username and password.
3. On startup, create a db table called 'Person' with the properties 'Name', 'Firstname', 'age' and 'wearsGlasses'. Also fill it with 3 records. Check if this succeeded by opening the h2-console (this console is not enabled by default). 
4. Check the health of the application. Add a custom healthcheck and check if it was added to the health rest endpoint.
5. Add a yaml file with some properties and add a REST call to fetch properties based on their key.
6. Add 2 more properties files, each corresponding to a different profile. Start the server with profile 1 and see if the correct properties are read. The do this again with profile 2.