# webServiceUserAddress

In the MVC based Spring project;


Model: The model establishes the data and business logic of the web service. Address – two as User
The model class is created.
View: It is responsible for showing the data for the client. In this project userDTO and addressDTO
used.
Controller: The controller handles incoming HTTP requests, communicates with the model, and
returns the response to the client. 

In this project, there are two addressAPI and userAPI which are controller classes.


Using the architecture over two tables ( Address and User) Create,Read,Update,Delete operations checked. 
The connection between these two tables was set up as OneToOne (one address for each user).
UserName-LastName character for login is provided with limitation was made and nullable-false was set to prevent null value entry.

In the general flow, when the Client sends a request, the request is managed by the controller. 
Then controller communicates with the model and gets the appropriate data and returns a response for the client.
For example, when a client sends a GET request to fetch all users, 
Controller communicates using userRepository and retrieves all users from database and returns data returns.

Similarly, updates and deletions are managed by the Controller. 

Matching tables;
The relationship between the User class and the Address class has been defined with  @OneToOne annotation. This relationship
specifies and carries every change in the User to the Address class. 
@JoinColunm(name=”Address_ID”) specifies the name of the column connecting the two classes.

Initializer Class ;
Bean starts by creating and repository access is provided.

Application properties:
In it, the server port is entered as server.port=8088.
"Tomcat started on port(s): 8088 (http) with context path '
It can also be accessed via Postman with the following endpoints.
Address operations are accessed from localhost:8088/api/v1/address.
User actions are accessed from localhost:8088/api/v1/user



