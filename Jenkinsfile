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
    }

}