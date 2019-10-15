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
    					if [ "$(sudo docker ps -aq -f status=exited -f name=selfreflection)" ]; then
       				 		# cleanup
        					sudo docker rm -f selfreflection
    					fi
    					# run your container
				sudo docker run -d --name selfreflection -p 8888:8888 selfreflection
				fi'''
                        }
                }
        }
}
