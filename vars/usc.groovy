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
        unixScript = args?.unix != null ? args.unix : script
        windowsScript = args?.windows != null ? args.windows : script
        returnStatus = args?.returnStatus != null ? args.returnStatus : false
        returnStdout = args?.returnStdout != null ? args.returnStdout : false
        encoding = args?.encoding
        label = args?.label
    }

    if(isUnix()){
        sh(script: unixScript, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
    }
    else
        bat(script:windowsScript, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
}
