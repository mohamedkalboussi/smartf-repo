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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
