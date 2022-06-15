def call(args){
    if(isUnix()){
        sh(script:args.script, encoding:args?.encoding, label:args?.label, returnStatus:args?.returnStatus, returnStdout:args?.returnStdout)
    }
    else
        bat(script:args.script, encoding:args?.encoding, label:args?.label, returnStatus:args?.returnStatus, returnStdout:args?.returnStdout)
}
