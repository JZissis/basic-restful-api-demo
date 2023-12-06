# basic-restful-api-demo
A basic RESTful API implementation for receiving, sending and handling HTTP requests.

The requests are sent using Postman.
The body of some requests usually uses the JSON format but XML format is also available.

For example, a POST request with a URL: http://localhost:8080/users and a body of 
{
    "firstName": "yourFirstName",
    "lastName": "yourLastName",
    "email": "test@test.com",
    "password": "123456"
}

should return a response of 
{
    "firstName": "yourFirstName",
    "lastName": "yourLastName",
    "email": "test@test.com",
    "userId": "f37d5991-0a9d-428e-82a4-1b4c57985169"
}
where userId is a randomly generated id for the specific user.
