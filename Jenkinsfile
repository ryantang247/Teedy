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
                    docker.build("ryantang247/practicedocker:newversion")
                    bat 'docker tag ryantang247/practicedocker:newversion ryantang247/practicedocker:firstversion'
                }
            }
        }
        // Uploading Docker images into Docker Hub
        stage('Upload image') {
            steps {
                script {
                    withCredentials([usernameColonPassword(credentialsId: 'dockerhub-credentials', variable: 'docker-acc')]) {
                        bat 'docker login -u %docker-acc% -p %docker-acc:.*//}'
                    }
                    bat 'docker push ryantang247/practicedocker:firstversion'
                }
            }
        }
        // Running Docker container
        stage('Run containers') {
            steps {
                script {
                    bat 'docker run -d ryantang247/practicedocker:firstversion'
                    bat 'timeout /t 50'
                }
            }
        }
    }
}
