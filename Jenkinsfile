pipeline {
    agent any
	//tools {
      //  maven 'myMaven'
    //}
	
    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				//sh 'docker ps'
				//sh 'pwd'
				//sh 'mvn -v'
            }
        }
        stage('Build') {
			agent {
                docker {
				    reuseNode true
                    image 'maven:3.5.0-jdk-8'
					args '-u root -u 1000 -v /tmp:/tmp'
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
