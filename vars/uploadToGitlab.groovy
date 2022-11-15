def call(args) {
    withCredentials([string(credentialsId: args.credentialsId, variable: "token")]) {
        file_path = findFiles "${args.sourcePath}"
        usc script: """curl -k --header "PRIVATE-TOKEN: ${token}" --upload-file ${file_path.tokenize().last()} "${args.url}/${args.packageName}/${args.version}/${args.fileNameWithExtension}" """
    }
}
