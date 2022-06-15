def call(args){
    if(args instanceof String)
    {
        script = args
        returnStatus = false
        returnStdout = false
        encoding = null
        label = null
    }
    else{
        script = args.script
        returnStatus = args?.returnStatus != null ? args.returnStatus : false
        returnStdout = args?.returnStdout != null ? args.returnStdout : false
        encoding = args?.encoding
        label = args?.label
    }

    if(isUnix()){
        sh(script:script, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
    }
    else
        bat(script:script, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
}
