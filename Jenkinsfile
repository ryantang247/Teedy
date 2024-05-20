pipeline {
    agent any
    stages {
        stage('Package') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ryantang247/Teedy.git']])
                bat 'mvn -B -DskipTests clean package'
            }
        }
        // Building Docker images
        stage('Building image') {
            steps {
                script {
                    docker.build("teedy-ryantang247")
                    bat "docker tag teedy-ryantang247 ryantang247/teedy-ryantang247"
                }
            }
        }
        // Uploading Docker images into Docker Hub
        stage('Upload image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'ryantang-dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        bat "docker login -u ryantang247 -p \"$DOCKER_PASSWORD\""
                        bat 'docker push ryantang247/teedy-ryantang247'
                    }
                }
            }
        }
        // Running Docker container
        stage('Run containers') {
            steps {
                script {
                    bat 'docker run -d ryantang247/teedy-ryantang247'
                    bat 'timeout /t 50'
                }
            }
        }
    }
}
