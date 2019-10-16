pipeline{
        agent any
        stages{ 
		    stage('---Build_Image---'){
                        steps{
                            sh "sudo docker build -t selfreflection ."
                        }
                }
                stage('---clean---'){
                        steps{
                              sh "docker-compose up --build -d"
                        }
                }
        }
}
