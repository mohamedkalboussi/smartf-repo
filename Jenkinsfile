pipeline {
    agent any
	
    stages {
		stage('Unit Tests') {
			parallel {
				
				stage('Unit Tests (front)') {
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli-karma:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && npm install && ng test --watch false --single-run true'
					}
				}
				stage('Lint Tests (front)') {
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli-karma:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && npm install && ng lint'
					}
				}
			}
		}
        stage('Build Artifact') {
			parallel {
				
				stage('Build Artifact (front)') {
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && npm install && ng build'
					}
				}
			}
        }
		stage('Build Image Docker') {
			parallel {
				
				stage('Build Image Docker (front)') {
					steps {
						dir('smartf-front') {
							sh 'docker build -t smartf-front-image .'
						}
					}
				}
			}
        }
		stage('Push Image Docker to Artifactory') {
			parallel {
				
				stage('Push Image Docker to Artifactory (front)') {
					steps {
						sh 'docker tag smartf-front-image smartf/front:lts'
						//sh 'docker push smartf/front:lts'
					}
				}
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