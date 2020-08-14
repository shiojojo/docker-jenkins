pipeline {
    agent any
    environment {
        docker_image = 'tomcat-docotsubu'
        docker_version = '0.1'
        docker_run_name = 'unit-test-tomcat'
        docker_ps_result = ''
      }
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
                sh 'docker build -t ${docker_image}:${docker_version} .'
            }
        }
        stage('tomcat run') {
            agent { label 'master'}
            steps {
                environment {
                    docker_ps_result = sh(script: "docker ps -a -f -q name=${docker_run_name}")
                }
                sh 'echo ${docker_ps_result}'
                sh 'docker run -d --name ${docker_run_name} -p 8080:8080 ${docker_image}:${docker_version}'              
            }
        }
    }
}