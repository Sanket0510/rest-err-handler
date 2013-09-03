This project provides an example of how to advanced error handling with a REST based web service.  
A problem with REST based web services is that over time the only error message that is seen is 
the dreaded HTTP 500 error.  However, by itself the 500 error really provides no significant 
information.  

The approach shown in this project will allow for the server to return a 500 error with some 
additional information to allow the error to clearly be understood on the client side.  The 
project was developed with Maven, Spring 3 and developed in Eclipse.  

You can also test the application from a web browser after building it with a query something 
like: 

    http://localhost:8080/rest-err-handler/ws/customer?name=bob
