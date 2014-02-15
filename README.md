This project provides an example of how to use advanced error handling with a REST based web service.  
A problem with REST based web services is that over time the only error message that get back is 
the dreaded HTTP 500 error.  However, by itself the 500 error really provides no significant 
information.  

The approach shown in this project will allow for the server to return a 500 error with some 
additional information to allow the error to clearly be understood on the client side.  The 
project was developed with Maven, Spring 3 and in Eclipse.  

You can also test the application from a web browser after building it with a query something 
like: 

    http://localhost:8080/rest-err-handler/ws/customer?name=bob

Note: The first time you attempt build the artifact with Maven, you will want to skip the tests with something like:

    mvn package -Dmaven.test.skip=true
    
There is a sample test case that will fail, unless you start the server.  

I hava a web page that explains the project in much greater detail at

http://www.lopakalogic.com/articles/web-services-articles/advanced-error-handling-rest-based-web-service/
