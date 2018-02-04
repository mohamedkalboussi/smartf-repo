pipeline {
    agent any
	
    stages {
		stage('Unit Tests') {
			parallel {
				stage('Unit Tests (back)') {
					agent {
						docker {
							reuseNode true
							image 'maven:3.5.0-jdk-8'
						}
					}
					steps {
						sh 'cd smartf-back && mvn clean test'
					}
				}
				stage('Unit Tests (front)') {
					steps {
						sh 'cd smartf-front'
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
						echo 'Push Image Docker to Artifactory (front)...'
						//sh 'docker tag smartf-back-image smartf/back:lts'
						//sh 'docker push smartf/back:lts'
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