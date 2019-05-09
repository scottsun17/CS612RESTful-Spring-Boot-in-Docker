# CS612RESTful-Spring-Boot-in-Docker
This is a Spring Boot web service application running inside a docker container. 
The application has three parts:
1. Data model - it use a JSON file as a mock database to represent Objects: different games
2. Controller - controls the data flows, update the views and map URL parameters
3. View - view through `http://localhost:8080/game`
 
## How to run the application
------------------------------
1. Install Docker on your computer and make sure docker is running. Get [Docker](https://www.docker.com/)    

2. Pull image from docker hub or visit [my Dockerhub](https://hub.docker.com/r/suncot917/assignment1)

⋅⋅⋅fire the following command: `docker pull suncot917/assignment1`
![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/docker-pull.PNG "Docker Pull")
<br/>
![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/docker-pull-image.PNG "Docker Pull Image CMD")
<br/>
![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/cmd-image%20ls.PNG "Docker Image List")

3. Run the following code to run the application from Docker

`docker run -p 8080:8080 -t suncot917/assignment1:latest`
![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/dockerrunning.PNG "Run Application")

4. Open browser and typle in `http://localhost:8080/game`; you can will see the database summary in a JSON format.

![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/game.PNG "View in Localhost")

5. Visit each game by id number `http://localhost:8080/game + id number`
`http://localhost:8080/game/1`
`http://localhost:8080/game/10`

![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/id1.PNG "ID 1")
![alt text](https://raw.githubusercontent.com/scottsun17/CS612RESTful-Spring-Boot-in-Docker/master/others/images/id10.PNG "ID 10")

