# phoneValidator

## Project scope : 

build phone validator service using SpringBoot for JUMIA interview 

## Pre installed software on machine : 
- Java 1.8 or above 
- maven 
- docker 

## To run this app as SpringBoot
- open cmd 
- cd to dolnlowded app path 
- run bellow commands in cmd with same order 
    - ``` mvn clean install ```   Note: to install all needed jars and dependances 
    - ``` mvn spring-boot:run ``` Note: to start empeded tomcat server on port 2222
    - navigate to below swagger URL 
         - (http://localhost:2222/swagger-ui.html#/)
	- open phone-validator-controller tab u will find 2 GET APIs
	    - /api/phones/validation/smoketest 
	        -  which used to check status of app if it is up and running or not
		- /api/phones/validation
			-  which used to apply required buisness and tack 2 parameters 
				- country : String which have default value all to validate all customers in DB , or one of next list {Cameroon , Ethiopia , Morocco , Mozambique , Uganda} if not match it will return bad request response 
				- page : set page num as each page will return 10 customer per call 

## To run this app as Docker image 
- open cmd 
- cd to dolnlowded app path 
- run bellow commands in cmd with same order 
	 - ``` mvn clean install ```   Note: to install all needed jars and
	 - ``` mvn docker:build  ```   Note: to create docker image 
	 - ``` docker images ```   Note: to make sure image is created 
	 - ``` docker run -p 2222 2222 -t validator ```   Note: to fire docker image 
	 - ``` docker-machine ls ```   Note: to list all runing docker images and validate your image run succ
   - navigate to below swagger URL 
         - (http://localhost:2222/swagger-ui.html#/)
	- open phone-validator-controller tab u will find 2 GET APIs
	    - /api/phones/validation/smoketest 
	        -  which used to check status of app if it is up and running or not
		- /api/phones/validation
			-  which used to apply required buisness and tack 2 parameters 
				- country : String which have default value all to validate all customers in DB , or one of next list {Cameroon , Ethiopia , Morocco , Mozambique , Uganda} if not match it will return bad request response 
				- page : set page num as each page will return 10 customer per call 