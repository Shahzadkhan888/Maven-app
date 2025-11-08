pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {

        stage("Build JAR") {
            steps {
                script {
                    echo "Building the application..."
                    bat "mvn clean package"
                }
            }
        }

        stage("Build Docker Image") {
            steps {
                script {
                    echo "Building the Docker image..."
                    withCredentials([usernamePassword(credentialsId: 'my-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        bat "docker build -t shahzadk1/my-repo:1.2 ."
                        bat "echo %PASS% | docker login -u %USER% --password-stdin"
                        bat "docker push shahzadk1/my-repo:1.2"
                    }
                }
            }
        }

        stage("Deploy") {
            steps {
                script {
                    echo "Deploying the Application..."
                }
            }
        }
    }
}
