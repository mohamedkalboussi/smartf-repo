pipeline {
    agent any

    stages {
        stage('Build') {
			agent {
                docker {
                    image 'maven:3.5.0-jdk-8'
                }
            }
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				sh "mvn -version"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
