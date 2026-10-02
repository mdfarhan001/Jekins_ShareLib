def call(String imageName, String imageTag, String dockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {

        sh '''
            echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
        '''

        sh """
            docker push ${dockerHubUser}/${imageName}:${imageTag}
        """
    }
}
