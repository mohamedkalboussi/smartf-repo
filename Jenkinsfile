pipeline {
    agent any

    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
				sh 'pwd'
				sh 'docker run -t -u root -v /F:/Formations/Docker:/root/.m2 maven:3.5.0-jdk-8 ./mvnw -v'
            }
        }
        stage('Build') {
			agent {
                docker {
				    reuseNode true
                    image 'maven:3.5.0-jdk-8'
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
