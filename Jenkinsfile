pipeline {
    agent any

    environment {
        IMAGE_NAME = "movie-site"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/eMatthiola/movie-site.git'
            }
        }

        stage('Build Frontend') {
            steps {
                dir('client') {  
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Build Backend') {
            steps {
                dir('server') {  
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build & Deploy Docker') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose up -d --build'
            }
        }
    }
}
