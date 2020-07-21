pipeline {
  agent any
  stages {
    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'echo "run on QA"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

    stage('End') {
      steps {
        sh 'echo "The End"'
      }
    }

  }
}