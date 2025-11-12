def buildJar() {
    echo "building the application..."
    bat 'mvn package'
} 

def buildImage(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'my-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        bat "docker build -t shahzadk1/my-repo:1.1 ."
        bat "echo %PASS% | docker login -u %USER% --password-stdin"
        bat "docker push shahzadk1/my-repo:1.1"

    }

}
def deployApp() {
    echo 'deploying the application...'
} 

return this
