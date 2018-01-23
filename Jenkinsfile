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
				sh 'mvn --version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
