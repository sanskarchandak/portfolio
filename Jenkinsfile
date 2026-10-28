pipeline
{
    agent any

    stages
    {
           stage('Smoke Tests') {
               steps {
                   script {
                       def smokeResult = 0

                       bat '''
                           echo Starting local portfolio server...

                           powershell -NoProfile -Command "$p = Start-Process -FilePath 'C:\\Users\\sansk\\AppData\\Local\\Programs\\Python\\Python311\\python.exe' -ArgumentList '-m','http.server','8000','--bind','127.0.0.1' -WorkingDirectory $env:WORKSPACE -PassThru; $p.Id | Set-Content -Path '%WORKSPACE%\\server.pid'"

                           echo Waiting for local server...

                           powershell -NoProfile -Command "$ok = $false; for ($i = 0; $i -lt 20; $i++) { try { Invoke-WebRequest -UseBasicParsing 'http://127.0.0.1:8000' -TimeoutSec 2 | Out-Null; $ok = $true; break } catch { Start-Sleep -Seconds 1 } }; if (-not $ok) { Write-Error 'Local server did not become available within 20 seconds.'; exit 1 }"

                           echo Local server is UP.
                       '''

                       try {
                           smokeResult = bat(
                               returnStatus: true,
                               script: 'mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml" "-DbaseUrl=http://127.0.0.1:8000"'
                           )
                       } finally {
                           bat '''
                               echo Stopping local server...

                               powershell -NoProfile -Command "if (Test-Path '%WORKSPACE%\\server.pid') { $serverPid = [int](Get-Content '%WORKSPACE%\\server.pid'); Stop-Process -Id $serverPid -Force -ErrorAction SilentlyContinue; Remove-Item '%WORKSPACE%\\server.pid' -Force -ErrorAction SilentlyContinue }"
                           '''
                       }

                       if (smokeResult != 0) {
                           error("Smoke tests failed")
                       }
                   }
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