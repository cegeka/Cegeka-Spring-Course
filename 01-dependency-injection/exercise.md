# Doctor McNeedles

Doctor McNeedles is a general practitioner with a problem: all of his equipment is malfunctioning.
It's up to you to fix it.

1. Get the VaccineController to work. If you want to test if you've implemented this task correctly, navigate to localhost:8080/vaccinate.
This should show you the text 'This might sting a little'.
2. Injecting a syringe into an arm won't cure anyone. The doctor also needs the vaccine.
This vaccine is supplied by another firm and can be found in the 'ExternalMedicineComponent'.
Autowire this component in the VaccineController and call its single method instead of returning the string in the 'helloVaccinatedWorld' method.
You are not allowed to change any code in the ExternalMedicineComponent to turn it into a Bean.
3. Create a new package in the 'com.cegeka.springcourse.dependencyinjection' package called 'applicationstart'. 
Move the 'Application' class into this package.
The REST call should be broken now. Fix it.
4. Turn the 'PillsController' and the 'PaymentController' into Spring Beans using the correct annotations.
Put them into separate packages (eg 'pills' and 'payment'). The Payment REST-call should work, the Pills REST-call should not.
5. Turn the Child- and AdultVaccinationDosisService into beans. Inject the adultDosisService into the VaccinationController while only using the interface.
Call this service when calling the 'helloVaccinatedWorld' method and append it to its result.

##Extra

1. The 'Application' class should not contain any logic concerning package scanning or bean creation.
Move this into a separate Configuration file.
2. Beans in Spring are singletons by default. Prove this. 
Add an integer field to the AdultVaccinationDosisService and increment it when the method is called, then print the number in the console.
