# Application Overview
This is a small full stack application for a credit card provider. This app allows you to add new credit card accounts and view them as a list. The backend is served as RESTful API.

## Tech Stack Used

FE React APP:
- Javascript , Jquery and CSS for styling
- React Library


Back-end:
- Java with Spring Boot
- H2 Database (in memory)
- Junit5 for unit testing
- Gradle build automation tool

## Getting started

Run FrontEnd React App locally:

-  Download the source code from the repository
-  Navigate to /FrontEnd/ReactApp in terminal where package.json is present
- `npm install` to install dependencies
- `npm start` to start the server locally
-  Open the application on `http://localhost:3000/`

Run BackEnd SpringBoot App locally:

- Download the source code from the repository
- Navigate to the directory where `build.gradle` file is present
- Run following command `./gradlew bootRun`
- Java Application should run on `http://localhost:8080/`.

## Swagger Overview

1) GET endpoint : Returns all cards in the system
```curl
curl 'http://127.0.0.1:8080/creditCards/getAll' \
  -H 'Accept: */*' \
  -H 'Accept-Language: en-US,en;q=0.9' \
  -H 'Connection: keep-alive' \
  -H 'Origin: http://localhost:3000' \
  -H 'Referer: http://localhost:3000/' \
  -H 'Sec-Fetch-Dest: empty' \
  -H 'Sec-Fetch-Mode: cors' \
  -H 'Sec-Fetch-Site: cross-site' \
  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36' \
  -H 'sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  --compressed
```

2) POST endpoint : Creates a new credit card for a given name, card number, and limit upon validation.

```curl
curl 'http://127.0.0.1:8080/creditCards/add' \
  -H 'Accept: */*' \
  -H 'Accept-Language: en-US,en;q=0.9' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json;charset=UTF-8' \
  -H 'Origin: http://localhost:3000' \
  -H 'Referer: http://localhost:3000/' \
  -H 'Sec-Fetch-Dest: empty' \
  -H 'Sec-Fetch-Mode: cors' \
  -H 'Sec-Fetch-Site: cross-site' \
  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36' \
  -H 'sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  --data-raw '{"userName":"suresh","number":"4431-1234-1322-9056","limit":"300"}' \
  --compressed
```


Payload:
```json
{
  "userName": "suresh",
  "number": "4431-1234-1322-9056",
  "limit": "300"
}
```

## Custom Exceptions:

Custom exceptions are created to return the error messages in desired format.

## Authentication:

APIs are not protected at this point.


## Testing Guidelines:

- Spin up the FrontEnd APP using above instructions
- Spin up the BackEnd APP using above instructions
- Fill valid Name (alphabet), Card (16 to 19 digits separated by dashes/spaces) and Limit (>= 100) fields in the UI
- Click on Add button
- List of added cards will appear below


## TODO : App version 2

- Secure APIs with control access
- Implement security headers
- Implement structured logging to support monitoring and alerting
- Document API with Swagger/Open API
- Implement versioning 
- API documentation and run-books