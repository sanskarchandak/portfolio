pipeline
{
    agent any

    stages
    {
             stage('Smoke Tests')
            {
                steps
                {
                   bat 'mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml"'
                }
            }
           stage('Deploy')
           {
                  steps {
                      withCredentials([
                          string(
                              credentialsId: 'github-actions-token',
                              variable: 'GITHUB_TOKEN'
                          )
                      ]) {
                          bat '''
                              echo {"ref":"main","inputs":{"environment":"production"}} > payload.json
                              curl.exe -sS -f -X POST "https://api.github.com/repos/sanskarchandak/portfolio/actions/workflows/deploy.yml/dispatches" ^
                              -H "Authorization: Bearer %GITHUB_TOKEN%" ^
                              -H "Accept: application/vnd.github+json" ^
                              -H "Content-Type: application/json" ^
                              -H "X-GitHub-Api-Version: 2022-11-28" ^
                              -d @payload.json
                              del payload.json
                          '''
                      }
                  }
          }
         stage('Regression Tests') {
             steps {
                 script {
                     def regressionResult = bat(
                         returnStatus: true,
                         script: 'mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng-regression.xml"'
                     )

                     if (regressionResult != 0) {
                         env.REGRESSION_FAILED = 'true'
                     }
                 }
             }
         }
         stage('Publish Report') {
             steps {
                 ftpPublisher(
                     continueOnError: false,
                     failOnError: true,
                     alwaysPublishFromMaster: false,
                     masterNodeName: '',
                     paramPublish: [parameterName: ''],
                     publishers: [
                         [
                             configName: 'infinityfree',
                             transfers: [
                                 [
                                     sourceFiles: 'target/surefire-reports/**',
                                     removePrefix: 'target/surefire-reports',
                                     remoteDirectory: 'reports/latest'
                                 ]
                             ]
                         ]
                     ]
                 )
             }
         }
    }
     post {
         always {
             junit 'target/surefire-reports/*.xml'

             script {
                 if (env.REGRESSION_FAILED == 'true') {
                     currentBuild.result = 'FAILURE'
                 }
             }
         }
     }
}