pipeline {
    agent any

    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
				sh 'pwd'
				sh 'docker run -t -u 1000:1000 --volumes-from=jenkins-data -w F:/Formations/Docker/jenkins_home/workspace/uri-templates-in-docker maven:3.5.0-jdk-8'
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
