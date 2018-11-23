# PreferencesApplication

How to start the PreferencesApplication application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/preferences-sample-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

You can change database configuration values in the `config.yml` to use db of your choice.

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

# To create user

Use postman and fire a query
`POST http://localhost:8080/user/create`

with POST method

with this payload.

```
 {
        "userId": "akhilesh",
        "userName": "tyagi",
        "emailId": "an email",
        "preferences": {
        	"fontName": "Arial",
        	"style": "one style",
        	"icon": "base 64 encoded icon string"
        }
    }
```

To retrieve list of users.

`GET http://localhost:8080/user/list`

To retrieve one  user

`Get http://localhost:8080/user/<userid>`
