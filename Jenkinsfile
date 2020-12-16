pipeline {
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
                sh 'mvn clean install 
            }
        }
    }
}
