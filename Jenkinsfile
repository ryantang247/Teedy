pipeline {
    agent any
    
    stages {
        stage('build') {
            steps {


                // Build your Maven project
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                bat 'mvn test'
            }
        }
        stage('pmd') {
            steps { bat 'mvn pmd:pmd' }
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

    post { always { archiveArtifacts artifacts: '**/target/site/**', fingerprint: true archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true } }
}
