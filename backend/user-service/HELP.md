# USER SERVICE

## Getting started

- Add .env file as below to the root of the service.

```bash
DB_USERNAME=Your_DB_username
DB_PASSWORD=Your_DB_password
```

- This is how the application.properties look.

```bash

spring.application.name=user-service
spring.datasource.url=jdbc:postgresql://localhost:5432/online_store_userdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server Configuration
server.port=9001

#JWT Configuration
jwt.secret=Add_Your_Secret.
jwt.expiration=3600000
jwt.refresh.expiration=604800000

# Logging Configuration
logging.level.org.springframework=INFO

spring.cloud.config.enabled=false
spring.cloud.config.import-check.enabled=false


```