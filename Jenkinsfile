pipeline {
  agent any

  tools {
    jdk 'jdk17'
    maven 'maven3'
  }

  parameters {
    string(name: 'ENV', defaultValue: 'qa', description: 'Test environment: qa/stg')
    string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser: chrome/firefox')
    booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Run headless?')
    string(name: 'GROUPS', defaultValue: 'smoke', description: 'TestNG groups: smoke/regression')
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build & Test') {
      steps {
        sh """
          mvn -q clean test \
            -Denv=${params.ENV} \
            -Dbrowser=${params.BROWSER} \
            -Dheadless=${params.HEADLESS} \
            -Dgroups=${params.GROUPS} || true
        """
      }
      post {
        always {
          archiveArtifacts artifacts: 'target/surefire-reports/**', allowEmptyArchive: true
          archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
        }
      }
    }

    stage('Allure Report') {
      steps {
        allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
      }
    }
  }
}

