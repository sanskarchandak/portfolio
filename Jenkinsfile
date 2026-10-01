pipeline
{
    agent any

    stages
    {
             stage('Smoke Tests')
            {
                steps
                {
                   bat 'mvn test "-Dgroups=smoke"'
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
             catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                 bat 'mvn test "-Dgroups=regression"'
             }
             }
         }
         stage('Publish Report') {
             steps {
                 ftpPublisher(
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
     post
         {
           always
            {
              junit 'target/surefire-reports/*.xml'
            }
         }
}