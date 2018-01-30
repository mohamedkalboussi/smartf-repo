node {
/* Requires the Docker Pipeline plugin to be installed */
    docker.image('maven:3.5.0-jdk-8') {
        stage('Build') {
            sh 'mvn -B'
        }
    }
}