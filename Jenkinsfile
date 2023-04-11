pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                           branches: [[name: '*/hbdev']],
                           extensions: [],
                           userRemoteConfigs: [[credentialsId: 'hrishib_github_credentials',
                                                url: 'git@github.com:hrishi1096/Lloyds_bank_e2e_demo.git']]
                        ])
            }
        }
        stage('Run') {
            steps {
                git branch: 'hbdev',
                credentialsId: 'hrishib_github_credentials',
                url: 'git@github.com:hrishi1096/app_navig_automate.git'

                browserstack('hrishib_browserstack_credentials') {
                        sh '''npm install
                              mvn compile
                              export BROWSERSTACK_CONFIG_FILE="./config/browserstack-parallel.yml"
                              mvn test -P sample-test'''
                }
            }
        }
    }
}