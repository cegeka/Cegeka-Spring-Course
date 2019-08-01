1. Generate a Properties Config server and a client via https://start.spring.io/ . For the server you'll need 'Config Server' and 'Actuator' dependencies, for the client you'll need 'Config Client', 'Actuator' and 'REST'.
2. You can find the properties at https://github.com/nielsjani/centralized-config-files . Fork this repository and refer to it from your Config Server.
3. Add a REST call to the client that returns the properties present on the server.
4. Implement a way to refresh the properties in the client after they've been changed on the server.