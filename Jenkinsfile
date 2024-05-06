pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Build your Maven project
                bat 'mvn -B -DskipTests clean package'
            }
        }
//         stage('Test') {
//             steps {
//                 // Run tests
//                 bat 'mvn -Dmaven.test.failure.ignore=true test'
//             }
//         }
        stage('Static Code Analysis') {
            steps {
                // Run PMD for static code analysis
                bat 'mvn pmd:pmd'
            }
        }
        stage('Generate Surefire Reports') {
            steps {
                // Generate Surefire reports
                bat 'mvn surefire-report:report'
            }
        }
        stage('Generate Javadoc') {
            steps {
                // Generate Javadoc
                bat 'mvn javadoc:javadoc'
            }
        }
    }

    post {
        always {
            // Archive artifacts
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}
