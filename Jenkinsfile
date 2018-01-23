pipeline {
    agent any
	
	options {
		buildDiscarder(logRotator(daysToKeepStr: '1'))
	}

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
