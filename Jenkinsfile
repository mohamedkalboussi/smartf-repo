node {
/* Requires the Docker Pipeline plugin to be installed */
    docker.image('maven:3.5.0-jdk-8').inside('-v C:/Users/ADMIN/.m2:/root/.m2') {
        stage('Build') {
            sh 'mvn -B'
        }
    }
}