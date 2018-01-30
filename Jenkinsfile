pipeline {
    agent any

    stages {
		stage('Test') {
            steps {
                echo 'Testing..'
				echo '${env.PATH}'
				echo '${env.BUILD_NUMBER}'
				sh 'docker ps'
				sh 'pwd'
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
				'${env.PATH}' = '/usr/local/bin'
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
