def call(args){
    script = args instanceof String ? args : args.script
    returnStatus = args?.returnStatus ? args.returnStatus : true
    returnStdout = args?.returnStdout ? args.returnStdout : false
    if(isUnix()){
        sh(script:script, encoding:args?.encoding, label:args?.label, returnStatus:returnStatus, returnStdout:returnStdout)
    }
    else
        bat(script:script, encoding:args?.encoding, label:args?.label, returnStatus:returnStatus, returnStdout:returnStdout)
}
