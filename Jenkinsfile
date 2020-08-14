pipeline {
    agent any
    stages {
        stage('delete_workspace') {
            steps {
                 deleteDir()
            }
        }
        stage('build') {
            agent {
                docker {
                    label 'master'
                    image 'maven:3.6.3-openjdk-14'
                }
            }
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean package"
            }
            post {
                success { 

                archiveArtifacts 'target/*.war'
                                    
                }
            }
        }
        stage('docker build') {
            agent { label 'master'}
            steps {
                sh 'docker build -t test-tomcat:0.1 .'
            }
        }
        stage('tomcat run')
            agent { label 'master'}
            steps {
                sh 'docker build -t test-tomcat:0.1 .'              
            }
    }
}