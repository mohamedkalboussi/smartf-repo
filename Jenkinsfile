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
							image 'trion/ng-cli-karma:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && npm install'
					}
				}
			}
		}
		
        stage('Build Artifact') {
			parallel {
				stage('Build Artifact (back)') {
					agent {
						docker {
							reuseNode true
							image 'maven:3.5.0-jdk-8'
						}
					}
					steps {
						sh 'cd smartf-back && mvn -DskipTests clean package'
					}
				}
				stage('Build Artifact (front)') {
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli-karma:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && ng build'
					}
				}
			}
        }
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
		stage('Push Image Docker to Artifactory') {
			parallel {
				stage('Push Image Docker to Artifactory (back)') {
					steps {
						sh 'docker tag smartf-back-image smartf/back:lts'
						//sh 'docker push smartf/back:lts'
					}
				}
				stage('Push Image Docker to Artifactory (front)') {
					steps {
						sh 'docker tag smartf-front-image smartf/front:lts'
						//sh 'docker push smartf/front:lts'
					}
				}
			}
        }
        stage('Deploy to Production') {
			when {
                branch 'master'
            }
            steps {
				echo 'docker run --name smartf-back-app -p 9090:8080 smartf/back:lts'
                echo 'docker run --name smartf-front-app -p 9091:80 smartf/front:lts'
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