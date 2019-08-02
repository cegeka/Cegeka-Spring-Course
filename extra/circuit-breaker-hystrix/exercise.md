#Victory lap

You're the manager of a team of Formula 1 drivers. Their cars are the peak of human engineering, and so is the software running its systems. 
The software is hosted on a central server ('circuit-breaker-failing-server'). The cars continuously make calls to the server for all kinds of calculations and reports.
Sometimes these calls fails due to a server overload or the server takes too long to respond. In that case the cars should switch over to their internal, limited systems.

1. Read up on the circuit breaker pattern https://martinfowler.com/bliki/CircuitBreaker.html
2. And how to do it in Spring using Netflix's Hystrix library https://spring.io/guides/gs/circuit-breaker/
3. The circuit breaker application calls the failing server. As its name implies, it fails every so often. If it does, make the circuit breaker application switch over to its internal systems.