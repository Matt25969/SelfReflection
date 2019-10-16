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
                              sh label: '', script: '''if [ ! "$(sudo docker ps -q -f name=selfreflection)" ]; then
       				 		# cleanup
						whoami
        					sudo docker rm -f selfreflection
				fi
				sudo docker run -d --name selfreflection -p 8888:8888 selfreflection
				'''
                        }
                }
        }
}
