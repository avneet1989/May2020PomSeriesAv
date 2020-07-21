pipeline {
  agent any
  stages {
    stage('Run on DEV') {
      parallel {
        stage('Run on DEV') {
          steps {
            bat 'echo "run on QA"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run on QA') {
      parallel {
        stage('Run on QA') {
          steps {
            sh 'echo "run on QA"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run on Stage') {
      parallel {
        stage('Run on Stage') {
          steps {
            sh 'echo "run on stage"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run on PROD') {
      parallel {
        stage('Run on PROD') {
          steps {
            sh 'Echo "run on prod"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

  }
}