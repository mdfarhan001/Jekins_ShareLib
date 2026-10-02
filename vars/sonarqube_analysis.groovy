def call(String sonarTool, String projectKey, String projectName) {

    withSonarQubeEnv(sonarTool) {
        sh """
            ${tool(sonarTool)}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.sources=.
        """
    }
}
