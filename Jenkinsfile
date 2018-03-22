pipeline {
    agent any
	
    stages {
		
		stage('Get Jenkins Infos') {
            steps {
                echo 'Get Jenkins infos...'
				sh 'docker ps'
				sh 'pwd'
				sh 'whoami'
            }
        }
    }
	
	post {
		// Always runs. And it runs before any of the other post conditions.
		always {
		    deleteDir()   /* clean up our workspace before we finish ! */
		}
    
		success {
			mail(from: "mohamedkalboussi@live.fr", 
				to: "kalboussi.mohamed5371@gmail.com", 
				subject: "That build passed.",
				body: "Nothing to see here")
		}

		failure {
			mail(from: "mohamedkalboussi@live.fr", 
				to: "kalboussi.mohamed5371@gmail.com", 
				subject: "That build failed!", 
				body: "Nothing to see here")
		}
	}
}