docker volume create jenkins-volume
docker run -v jenkins-volume:/var/jenkins_home --name jenkins -p 8081:8080 -p 50000:50000 jenkins/jenkins:lts-jdk8