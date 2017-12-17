
Cross Check steps:

step1: import the given "spring_data_jpa.postman_collection.json" file into your postman tool

step2: submit request with Name: "make entries into todos table", as many times as you wish to create the records in todos table!

step3: To check if "todos" table indeed is created in H2 database please access below URL: http://localhost:8080/h2-console

step4: This completes the use of Named Queries with spring-data-jpa default naming strategy as we have followed the naming rule while creating the name of "named queries" (i.e [name of the Managed Entity]:[named of the invoked query method])
