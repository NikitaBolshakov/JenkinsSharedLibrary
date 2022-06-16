def call(args) {
    withCredentials([string(credentialsId: args.credentialsId, variable: "token")]) {
        usc script: """curl -k --header "PRIVATE-TOKEN: ${token}" --upload-file ${args.sourcePath} "${args.url}/${args.packageName}/${args.version}/${args.fileNameWithExtension}" """
    }
}
