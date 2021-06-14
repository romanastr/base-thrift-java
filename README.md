# Base Thrift project with Maven and Java
[Apache Thrift](https://en.wikipedia.org/wiki/Apache_Thrift) is a powerful cross-platform definition
language and a binary communication protocol, which facilitates the development of scalable services.
This sample project with Java 11 and Maven demonstrates 
* a definition of a Thrift resource turned into Java code,
* an API definition in Thrift turned into Client and Server code in Java,
* fully working examples of a client and a server with persistence in memory,
* a convenient way to operate with auto-generated Java sources,
* Maven wiring to generate all required code within a standard Maven command (`mvn clean install`). 

## Setup
The prerequisites for the project are:
1. Java 11 JDK installed and available.
2. Maven 3+ installed and available /or/ bundled with IntelliJ IDEA.

Steps:
1. Check out the code into an arbitrary folder on your computer.
2. Download [Apache Thrift binary](https://thrift.apache.org/download) for your operating system.
3. Rename the file to `thrift` or `thrift.exe`, copy it to the root of the checked out directory,
and ensure the file is readable and executable by your user.
4. Ensure nothing is running on localhost port 9090 /or/ change the server port to some other
port in [ServerConfig](src/main/java/org/astroman/base/thrift/ServerConfig.java) class.
5. Build the project with `mvn clean install` command from your IDE or stand-alone Maven.

## Execution
1. Run server `main` method in 
   [CrossPlatformServiceServer](src/main/java/org/astroman/base/thrift/CrossPlatformServiceServer.java) class to start the server.
2. Run client `main` method in 
   [CrossPlatformClient](src/main/java/org/astroman/base/thrift/CrossPlatformClient.java) class to start the client.
   
Observe how the client logs the boolean response to ping and the list of resources returned by the server
after those resources were saved to the server by the client. Note that client exits after the execution.
On each subsequent execution of a client for the same instance of the server two additional resources are saved to the server
and are returned by the client.

## Acknowledgements
[Working with Apache Thrift article](https://www.baeldung.com/apache-thrift) served as the basis
for the current project. However, the code presented therein is neither complete (it doesn't send
the instances of `CrossPlatformResource` between the client and the server) nor self-sufficient (it 
requires a manual execution of thrift binary).

## Disclaimer
The project is based exclusively on publicly available resources and techniques.
No proprietary knowledge of any company I worked for is anyhow used.