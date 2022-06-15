def call(args){
    returnStatus = args?.returnStatus ? args.returnStatus : true
    returnStdout = args?.returnStdout ? args.returnStdout : false
    if(isUnix()){
        sh(script:args.script, encoding:args?.encoding, label:args?.label, returnStatus:returnStatus, returnStdout:returnStdout)
    }
    else
        bat(script:args.script, encoding:args?.encoding, label:args?.label, returnStatus:returnStatus, returnStdout:returnStdout)
}
