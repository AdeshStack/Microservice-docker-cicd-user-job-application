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
                   bat 'mvnw.cmd clean package -DskipTests'
                }
            }
        }

        stage('Build User Service') {
            steps {
                dir('UserServiceMS') {
                   bat 'mvnw.cmd clean package -DskipTests'
                }
            }
        }

      stage('Build Docker Images') {
    steps {

        dir('service-discovery/service-discovery') {
            echo 'Building Docker image for service registry...'

            bat 'docker build -t %DOCKER_USERNAME%/service-registry:latest .'
        }

        dir('UserServiceMS') {
            echo 'Building Docker image for user service...'

            bat 'docker build -t %DOCKER_USERNAME%/user-service:latest .'
        }
    }
}

      stage('Push to Docker Hub') {
            steps {
                echo 'Pushing Docker image to Docker Hub...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    bat '''
                        echo Logging into Docker Hub...
                        docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%
                        docker push %DOCKER_USERNAME%/service-registry:latest
			            docker push %DOCKER_USERNAME%/user-service:latest

                    '''
                }
            }
        }

stage('Deploy Using Docker Compose') {
    steps {

        bat 'docker compose down'

        bat 'docker compose up -d'
    }
}
    }
}
