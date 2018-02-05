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
					agent {
						docker {
							reuseNode true
							image 'trion/ng-cli-karma:1.6.7'
						}
					}
					steps {
						sh 'cd smartf-front && ng test --watch false --single-run true'
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
						sh 'cd smartf-front && ng lint'
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
		
    }
}