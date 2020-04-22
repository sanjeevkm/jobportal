# Job Portal


Technologies used:
Java 8, Springboot, Hibernate, H2 DB, Maven



How to run?  
- You can run as Java application from IDE (e.g eclipse)  
- Use Maven wrapper.  
	1. Go to project folder.  
	2. Call './mvnw spring-boot:run' from command line.  
- Open browser and enter http://localhost:9001/rest/  

- To view DB  
	1. Open browser and enter http://localhost:9001/rest/h2-console/login.do  
	2. Enter JDBC URL = jdbc:h2:mem:bootapp  
	3. UserName = sa  
	4. Password = Leave blank   

- File is currently saved in java temp directory (java.io.tmpdir). Location varies on Operating systems. 




Pending:
Logging, Unit Testing, L18N
	
	
