# Regions Catalog Service

This service provides used with all basic CRUD operations on regions.

### Technologies
Used technologies are: Spring Boot, MyBatis, H2 (RDBMS).

### Interface (UI)
For convenience (and demo) purposes Swagger (interactive Postman-like way to mess around with API) specification was implemented. Demonstration of API with use of Swagger located in /demo folder.

### Structure / architecture
Project structured in a 'Clean Architecture'-like (Robert Martin) style.

### Possible improvements
- Use Unit Of Work pattern over Repositories to unify working with DB.
- Unit tests.
- Caching.
- Transform Resources to DTO if more adjacent services will appear and data interchange will increase (all that will live in RegionsDirectory.Common project).