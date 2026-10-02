def call() {
    sh '''
        trivy fs --format template \
        --template "@contrib/html.tpl" \
        -o trivy-fs-report.html .
    '''
}
