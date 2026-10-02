def call() {
    dependencyCheck(
        additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit',
        odcInstallation: 'OWASP'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
