# APIHackaton

## Description
This API allows managing users and activities, including user registration, activity data management, and importing/exporting activities in JSON format.

## Requirements
- Java 11 or higher
- Spring Boot 3.0.0
- MongoDB

Step 1: Configure MongoDB
Open MongoDB Compass and connect to your MongoDB instance.
Create a new database named app_api_hackaton.
Create a new collection named users in the app_api_hackaton database.
Create a new collection named activities in the app_api_hackaton database.

Step 2: Import Postman Collection
Open Postman.
Import the APIHackaton.postman_collection.json file located in the src/main/resources/postman directory.
Use the imported collection to test the API endpoints.

## Endpoints
### Users
GET /users - Get all users
POST /users - Create a new user
GET /users/{id} - Get user by ID
PUT /users/{id} - Update user by ID
DELETE /users/{id} - Delete user by ID

### Activities
GET /activities - Get all activities 
POST /activities - Create a new activity 
GET /activities/{id} - Get activity by ID 
PUT /activities/{id} - Update activity by ID 
DELETE /activities/{id} - Delete activity by ID 
POST /activities/import - Import activities from JSON file 
GET /activities/export - Export activities to JSON file
POST /activities/{activityId}/join/{userId} - Join an activity

## JSON Import
1. Place your JSON files in a folder named `jsons` at the root of the project.
2. Use the `/appActivitats/activities/import` endpoint to import activities from the JSON files.

## Running the Application
1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd APIHackaton
    ```

2. Run the application:
    ```sh
    ./gradlew bootRun
    ```