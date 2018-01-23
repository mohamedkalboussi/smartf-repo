pipeline {
    agent any

    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
				sh 'pwd'
            }
        }
        stage('Build') {
			agent {
                docker {
                    image 'maven:3-alpine'
                }
            }
            steps {
                echo 'Building..'
				sh 'mvn --version'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
