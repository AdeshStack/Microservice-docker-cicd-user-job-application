pipeline {

    agent any

    environment {
        DOCKER_USERNAME = "adeshprime17"
    }

     stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build Service Registry') {
            steps {
                dir('service-discovery/service-discovery') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build User Service') {
            steps {
                dir('UserServiceMS') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {

                dir('service-discovery') {
                    sh 'docker build -t $DOCKER_USERNAME/service-registry:latest .'
                }

                dir('UserServiceMS') {
                    sh 'docker build -t $DOCKER_USERNAME/user-service:latest .'
                }
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Images') {
            steps {

                sh 'docker push $DOCKER_USERNAME/service-registry:latest'

                sh 'docker push $DOCKER_USERNAME/user-service:latest'
            }
        }

        stage('Deploy Using Docker Compose') {
            steps {
                sh 'docker compose down'
                sh 'docker compose up -d'
            }
        }
    }
}
