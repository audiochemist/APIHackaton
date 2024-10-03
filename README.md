# APIHackaton

## Description
This API allows managing users and activities, including user registration, activity data management, and importing/exporting activities in JSON format.

## Requirements
- Java 11 or higher
- Spring Boot 3.0.0
- MongoDB

## Configuration
1. Set environment variables for MongoDB credentials:
    ```sh
    export MONGODB_USERNAME=yourUsername
    export MONGODB_PASSWORD=yourPassword
    ```

2. Configure the database in `application.properties`:
    ```properties
    spring.data.mongodb.uri=mongodb://${MONGODB_USERNAME}:${MONGODB_PASSWORD}@localhost:27017/apihackaton
    ```

## Database Setup
1. Start MongoDB server.
2. Create the database and collections:
    ```sh
    mongo
    use apihackaton
    db.createCollection("users")
    db.createCollection("activities")
    ```

## Endpoints
### Users
- `POST /appActivitats/user`: Register a new user.
- `PUT /appActivitats/users/{id}`: Update user data.
- `GET /appActivitats/users/{id}`: Get user information.
- `DELETE /appActivitats/users/{id}`: Delete a user.

### Activities
- `POST /appActivitats/activities/activity`: Create a new activity.
- `GET /appActivitats/activities`: Get activities.
- `POST /appActivitats/activities/join/{activityId}/{userId}`: Join an activity.
- `GET /appActivitats/activities/export`: Export activities in JSON format.
- `POST /appActivitats/activities/import`: Import activities from a JSON file.

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

## Testing
Run tests with:
```sh
./gradlew test