# Managing low emission zone drivers

Every time a driver enters a low emission zone, his license plate gets scanned by a camera.
Using its license plate, a system will look up the emission values for the car.
After looking up the data, your system will get contacted by the camera system.
You will have to decide if the driver should get a fine because he entered the LEZ with a high emission zone or if his car's pollution is below the limit.

1. The project already has the necessary axon dependencies, but the axon server is not included yet.
[Download it](https://axoniq.io/product-overview/axon-server) and start it with a java -jar command.

2. Our system is contacted via the DriverReportController's _reportDriver_ method. 
It receives a DriverReportDto as input. Our system has to decide if the driver should be fined (if the emissionScore is <6) or not.
    - For the command side of things, create a 'HighEmissionDriver' object that has the car's license plate (id) and its score.
It also has a a 'status' field that should be set to 'AWAITING_FINE_PAYMENT' (only create this object if the emission score is <6).
    - On the query side, create a 'driverReport' object. It should have the license plate (id), car brand and type, the date at which the car entered the zone (which is the time at which the object is made) and a status (ALLOWED/FINE_NOT_PAID/FINE_PAID).
    Since we don't have a db, you can store these objects in a list or map.
3. A driver can pay his fine by calling the _payFine_ method. It should update the statuses of the command and query models accordingly.
4. A user should be able to query the system for
    - All drivers
    - All drivers who entered after a certain date
    - All drivers with unpaid fines    

    