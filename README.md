
# Spring Security with JDBC on H2 embedded database

Using `spring-security` to implement 
  - Basic Authentication with username / password 
  - Authorization through Role Based Access Control



| API  | Required Role | Description |
| ------------ | ---- | --- |
| /greet/citizen | No Authentication | Any user can Access this API  
| /greet/avenger | Avenger or Director | Only users with role `Avenger` or  `Director` can access this API
| /greet/director | Director | Only users with role  `Director` can access this API

  - Security Configuration can be found [here](https://github.com/hemrajanilavesh/spring-auth-jdbc-h2/blob/main/src/main/java/io/hemrlav/springsecurityjdbch2/config/SecurityConfiguration.java)

  - Schema file for Users and Authorities can be found [here](https://github.com/hemrajanilavesh/spring-auth-jdbc-h2/blob/main/src/main/resources/schema.sql)

  - Data file which inserts sample users with roles can be found [here](https://github.com/hemrajanilavesh/spring-auth-jdbc-h2/blob/main/src/main/resources/data.sql)
