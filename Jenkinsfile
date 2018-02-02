pipeline {
    agent any
	
    stages {
		stage('Unit Tests (back)') {
            agent {
                docker {
				    reuseNode true
                    image 'maven:3.5.0-jdk-8'
                }
            }
            steps {
				sh 'cd smartf-back && mvn clean test'
            }
        }
		stage('Unit Tests (front)') {
            steps {
				sh 'cd smartf-front'
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
                sh 'mvn --version'
				sh 'cd smartf-back && mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
		stage('Get Jenkins Infos') {
            steps {
                echo 'Get Jenkins infos...'
				sh 'docker ps'
				sh 'pwd'
				sh 'whoami'
            }
        }
    }
}