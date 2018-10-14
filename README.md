# Hospitality Service
This is a short project to consume the endpoint located at http://services.groupkt.com/state/get/USA/all. This service will allow you to retrieve either all states in the United States, or a state specified by the user. In order to see the exposed endpoints of the application, please refer to the documentation section.

## Documentation
This application has integrated Swagger to generate it's api documentation. After running the application you can navigate to http://localhost:8090/swagger-ui.html to see the exposed endpoints.

Example calls:

1. http://localhost:8090/travelport/state -> Returns all states
2. http://localhost:8090/travelport/state?name=Alabama&name=georgia -> returns the states Alabama and Georgia
3. http://localhost:8090/travelport/state/Alabama -> Returns the state of Alabama
