pipeline {
    agent any
	//tools {
      //  maven 'myMaven'
    //}
	
    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				sh 'docker ps'
				sh 'pwd'
				sh 'whoami'
				//sh 'mvn -v'
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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
