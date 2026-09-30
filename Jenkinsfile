pipeline
{
    agent any

    stages{
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
                              curl.exe -sS -f -X POST "https://api.github.com/repos/sanskarchandak/portfolio/actions/workflows/deploy.yml/dispatches" ^
                              -H "Authorization: Bearer %GITHUB_TOKEN%" ^
                              -H "Accept: application/vnd.github+json" ^
                              -H "Content-Type: application/json" ^
                              -H "X-GitHub-Api-Version: 2022-11-28" ^
                              -d "{\"ref\":\"main\",\"inputs\":{\"environment\":\"production\"}}"
                          '''
                      }
                  }
          }
    }
}