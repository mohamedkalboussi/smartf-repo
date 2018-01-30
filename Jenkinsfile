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
				    reuseNode true
                    image 'maven:3.5.0-jdk-8'
					args '-u root '
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
