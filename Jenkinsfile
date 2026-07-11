pipeline {

    agent {
      label 'linux-agent'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh '''
                    mvn clean package
                '''
            }
        }

        stage('Parallel Jobs') {
            parallel {

                stage('Test') {
                    steps {
                        sh '''
                            mvn test
                        '''
                    }
                }

                stage('Verify') {
                    steps {
                        sh '''
                            mvn verify
                        '''
                    }
                }

            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts(
                    artifacts: 'target/*.jar',
                    fingerprint: true
                )
            }
        }

    }

    post {

        success {
            echo 'Build completed successfully.'
        }

        failure {
            echo 'Build failed.'
        }

        unstable {
            echo 'Build is unstable.'
        }

        aborted {
            echo 'Build was aborted.'
        }

        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }

    }

}
