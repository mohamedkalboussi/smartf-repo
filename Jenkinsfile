pipeline {
    agent none

    stages {
        stage('Build') {
			agent {
                docker {
					reuseNode true
                    image 'maven:3.5.0-jdk-8'
                }
            }
            steps {
                echo 'Building..'
				sh "mvn -v"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
