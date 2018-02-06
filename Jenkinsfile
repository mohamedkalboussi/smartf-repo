pipeline {
    agent any
	
    stages {
		
        
		
		
        stage('Deploy to Production') {
			when {
                branch 'master'
            }
            steps {
				sh 'docker run --name smartf-front-app -p 9091:80 -d --link smartf-back-app:smartf-back-app smartf-front-image'
				sh 'docker run --name smartf-back-app -p 9090:8080 -d smartf-back-image'
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