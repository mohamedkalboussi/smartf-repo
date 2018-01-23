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
		stage('Front-end') {
            agent {
                docker { 
					image 'node:6-alpine'
					args '-p 3000:3000'
				}
            }
            steps {
                sh 'node --version'
            }
        }
        stage('Build') {
			agent {
                docker {
				    reuseNode true
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
