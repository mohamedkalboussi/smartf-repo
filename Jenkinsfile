pipeline {
    agent any
	
    stages {
		
        
		stage('Build Image Docker') {
			parallel {
				stage('Build Image Docker (back)') {
					steps {
						dir('smartf-back') {
							sh 'docker build -t smartf-back-image .'
						}
					}
				}
				stage('Build Image Docker (front)') {
					steps {
						dir('smartf-front') {
							sh 'docker build -t smartf-front-image .'
						}
					}
				}
			}
        }
		
        stage('Deploy to Production') {
			//when {
              //  branch 'master'
            //}
            steps {
				echo 'docker run --name smartf-back-app -p 9090:8080 smartf-back-image'
                echo 'docker run --name smartf-front-app -p 9091:80 smartf-front-image'
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