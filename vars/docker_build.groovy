
def call(String imageName, String imageTag, String dockerHubUser) {

    sh """
        echo "Checking Docker build context..."
        pwd
        ls -la

        if [ ! -f .env.docker ]; then
            echo "ERROR: .env.docker not found in backend directory"
            exit 1
        fi

        docker build -t ${dockerHubUser}/${imageName}:${imageTag} .
    """
}
