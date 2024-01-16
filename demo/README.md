This is a spring boot server running the following checks for password validation.

Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
Must be between 5 and 12 characters in length.
Must not contain any sequence of characters immediately followed by the same sequence.

1.  In order to run this, you must have Java 17, and maven
2.  Make sure your JAVA_HOME environment variable is pointing to your installation...i.e. 
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/amazon-corretto-17.jdk/Contents/Home
3.  To run this server type in the command: "mvnw spring-boot:run"
4.  The spring boot server is running on http://localhost:8082
5.  You can test this by either using and modifying the curl commands in the curlTest.txt document 
	or use the angular front end that is also provided


