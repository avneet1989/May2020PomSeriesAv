pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on dev') {
          steps {
            bat 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on qa') {
          steps {
            bat 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on stage') {
          steps {
            bat 'mvn test -Denv=stage'
          }
        }

      }
    }

    stage('publish reports') {
      steps {
        script {
          allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            result: [[path: '/allure-results']]
          ])
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}