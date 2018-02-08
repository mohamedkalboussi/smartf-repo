pipeline {
    agent any
	
    stages {
		stage('Fetch Dependencies') {
			parallel {
				stage('Fetch Dependencies (back)') {
					agent {
						docker {
							reuseNode true
							image 'maven:3.5.0-jdk-8'
						}
					}
					steps {
						sh 'cd smartf-back && mvn clean dependency:go-offline'
					}
				}
				stage('Fetch Dependencies (front)') {
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli-e2e:1.6.7'     // ng-cli, ng-cli-karma, ng-cli-e2e
						}
					}
					steps {
						sh 'cd smartf-front && npm install'
					}
				}
			}
		}
		stage('E2E Tests') {
            agent {
                docker {
                    reuseNode true
                    image 'trion/ng-cli-e2e:1.6.7'
                }
            }
            steps {
                sh 'cd smartf-front && ng e2e'
			}
        }
        
    }
}