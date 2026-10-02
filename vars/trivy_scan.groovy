def call() {

    sh '''
        echo "Starting Trivy filesystem scan..."

        trivy fs \
        --format json \
        -o trivy-fs-report.json \
        .

        echo "Trivy scan completed successfully."
    '''
}
