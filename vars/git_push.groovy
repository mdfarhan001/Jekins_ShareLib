def call(String repoUrl, String branch) {

    withCredentials([
        gitUsernamePassword(
            credentialsId: 'githubCred',
            gitToolName: 'Default'
        )
    ]) {

        sh """
            echo "Checking repository status..."
            git status

            echo "Adding changes..."
            git add .

            echo "Committing changes..."
            git commit -m "Updated Docker image tags" || echo "No changes to commit"

            echo "Pushing changes to GitHub..."
            git push ${repoUrl} ${branch}
        """
    }
}
