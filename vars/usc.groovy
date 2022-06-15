def call(script, encoding=null, label=null, returnStatus=true, returnStdout=false){
    if(isUnix()){
        sh(script:script, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
    }
    else
        bat(script:script, encoding:encoding, label:label, returnStatus:returnStatus, returnStdout:returnStdout)
}
