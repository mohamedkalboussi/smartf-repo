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
					steps {
						sh 'cd smartf-front'
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
							//sh 'docker build -t smartf-front-image .'
						}
					}
				}
			}
        }
		stage('Push Image Docker to Artifactory') {
			parallel {
				stage('Push Image Docker to Artifactory (back)') {
					environment {
						//Use "Pipeline Utility Steps" plugin to read information from pom.xml into env variables
						IMAGE = readMavenPom().getArtifactId()
						VERSION = readMavenPom().getVersion()
					 }
					steps {
						sh 'docker tag smartf-back-image ${IMAGE}:${VERSION}'
						//sh 'docker push ${IMAGE}:${VERSION}'
					}
				}
				stage('Push Image Docker to Artifactory (front)') {
					steps {
						sh 'docker tag smartf-front-image smartf-front-image:ltsss'
						//sh 'docker push ${IMAGE}:${VERSION}'
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