# RIOT API for League of Legends

Provides a means to search summoners for now, but leaves the architecture and the classes needed to extend
and easily add new API endpoints. Includes modules for the RIOT API service and a web application.

Technology details:
- Java 8
- Implemented a generic rest service that can be extended to call implement other endpoints with ease
- Spring security with stateless JWT token based authentication
- Frontend in Angular, using local storage to keep the auth header