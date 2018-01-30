pipeline {
    agent any

    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
				sh 'pwd'
				sh 'docker run -t -u 1000:1000 /
    -w /var/jenkins_home/workspace/uri-templates-in-docker /
    –v F:/Formations/Docker/.m2:/root/.m2 /
    -v /var/run/docker.sock:/var/run/docker.sock /
     --name jenkins-slave /
	 maven:3.5.0-jdk-8 /
	 ./mvnw -v '
            }
        }
        stage('Build') {
			agent {
                docker {
				    reuseNode true
                    image 'maven:3.5.0-jdk-8'
					args '-u root -u 1000 -v /tmp:/tmp'
                }
            }
            steps {
                echo 'Building..'
				sh 'whoami'
				// sh 'mvn --version'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
