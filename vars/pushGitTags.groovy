//require: usernamePassword jenkins credentials
//args: url::String, credentialsId::String
def call(args) {
    withCredentials([usernamePassword(credentialsId: args.credentialsId, passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
        usc(script: "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@${args.url} --tags")
    }
}
