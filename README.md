# Bloomberg FX Deal Data Warehouse

The Bloomberg FX Deal Data Warehouse is a Spring Boot application that allows you to import, validate, and store FX deal details into a MongoDB database. This repository provides a step-by-step guide for setting up and running the application in a Docker container.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Checking the database](#checking-the-database)
- [Additional Information](#checking-the-database)
  
## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Docker](https://www.docker.com/get-started) installed and running.
- A MongoDB instance accessible, either locally or remotely. ( If you dont want to run with docker compose)

## Getting Started

1. Clone this repository:

   ```shell
   git clone https://github.com/TuqaMatar/clustered_data_warehouse.git
   ```
2. Navigate to the file path 
   ```shell
   cd clustered_data_warehouse
   ```

## Run the Appliction
   
3. Run Command docker-compose up
   ```shell
   cd docker-compose up 
   ```
## Testing 

Open Postman or any API testing tool.

Make a POST request to the following URL:

```bash
http://localhost:8080/deals/import
```
In the request body, provide a JSON object with deal details. For example:

```json
{
  "dealUniqueId": "DEAL123",
  "fromCurrencyISOCode": "USD",
  "toCurrencyISOCode": "EUR",
  "dealTimestamp": "2023-10-30T12:00:00",
  "dealAmount": 1000.00
}
``` 
Send the POST request. You should receive a successful response.

## Checking the Database
You can check that the deals have been successfully stored in the MongoDB database.

1.Open a terminal window.

2.Access the MongoDB shell within the Docker container by running the following command:

```bash
docker exec -it mongodb mongo
```
3.Use the MongoDB shell to view all documents in the "deals" collection of the "fx_deals" database:
```bash
use fx_deals
db.deals.find({})
```
This will display all the JSON documents representing the deals stored in the database.

## Additional Information
The Spring Boot application runs on port 8080.

The MongoDB database is available on localhost at port 27017.

Make sure to customize the JSON data in your POST request to match your specific deal details.

Ensure that Docker Compose is correctly set up to run the application and MongoDB container.

Make sure you have configured your Spring Boot application to connect to the MongoDB container within Docker Compose.

Enjoy using the Data Warehouse application!
