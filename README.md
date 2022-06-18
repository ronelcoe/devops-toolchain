# devops-toolchain

#Setup
1. Run compose
    docker-compose up -d

2. Setup Gogs
    1. Access http://localhost:3000
    2. Configure - Install Steps For First-time Run (DB, Admin account)
    3. Create a user account http://localhost:3000/user/sign_up
    4. Create a repository

3. Setup Jenkins
    1. Access http://localhost:8080/
    2. From CLI, run to get admin password - docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
    3. Copy the initial admin password and paste in the UI
    4. Choose the preferred plugin to finish the setup
    5. 

4. Setup Jenkins Slave - TODO

5. Setup Sonarqube - TODO

6. Setup Nexus - TODO

#Cleanup
1. docker-compose down -v
2. delete bind mounts directory - rm -rf gogs jenkins