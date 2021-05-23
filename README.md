# phoneValidator

Project scope : 
	build phone validator service using SpringBoot for JUMIA interview 

Pre installed software on machine : 
	1. Java 1.8 or above 
	2. maven 
	3. docker 
	
To run this app as SpringBoot
	0. open cmd 
	1. cd to dolnlowded app path 
	2. run bellow commands in cmd with same order 
		a. mvn clean install 
			# to install all needed jars and dependances 
		b. mvn spring-boot:run
			# to start empeded tomcat server on port 2222
	3. navigate to below swagger URL 
		http://localhost:2222/swagger-ui.html#/
	4. open phone-validator-controller tab u will find 2 GET APIs 
		a. /api/phones/validation/smoketest
			# which used to check status of app if it is up and running or not 
		b. /api/phones/validation
			# which used to apply required buisness and tack 2 parameters 
				I. country : String which have default value all to validate all customers in DB , or one of next list {Cameroon , Ethiopia , Morocco , Mozambique , Uganda} if not match it will return bad request response 
				II. page : set page num as each page will return 10 customer per call 

To run this app as Docker image 
	0. open cmd 
	1. cd to dolnlowded app path 
	2. run bellow commands in cmd with same order 
		a. mvn clean install 
			# to install all needed jars and dependances 
		b. mvn docker:build 
			# to create docker image 
		c. docker images
			# to make sure image is created 
		d. docker run -p 2222 2222 -t validator
			# fire docker image 
		e. docker-machine ls 
			# to list all runing docker images and validate your image run succ
	3. navigate to below swagger URL 
		http://localhost:2222/swagger-ui.html#/
	4. open phone-validator-controller tab u will find 2 GET APIs 
		a. /api/phones/validation/smoketest
			# which used to check status of app if it is up and running or not 
		b. /api/phones/validation
			# which used to apply required buisness and tack 2 parameters 
				I. country : String which have default value all to validate all customers in DB , or one of next list {Cameroon , Ethiopia , Morocco , Mozambique , Uganda} if not match it will return bad request response 
				II. page : set page num as each page will return 10 customer per call 