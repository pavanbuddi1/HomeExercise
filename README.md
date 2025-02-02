Hello,

Here is the solution for Fetch Exercise. I used Java + SpringBoot and REST API to run in my local and test the app. 

There are two approaches to run the application

# Approach 1 -  Clone this repo and use the below docker commands 

cd /path/to/repo <br />
docker build -t homeexercise . <br />
docker run -p 8080:8080 homeexercise

# Approach 2 - Pull from Docker Hub

docker run -p 8080:8080 pavanbuddi1/homeexercise
