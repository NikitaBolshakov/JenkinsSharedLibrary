call(script, encoding=null, label=null, returnStatus=true, returnStdout=false){
    if(isUnix()){
        sh(script, encoding=encoding, label=label, returnStatus=returnStatus, returnStdout=returnStdout)
    }
    else
        powershell(script, encoding=encoding, label=label, returnStatus=returnStatus, returnStdout=returnStdout)
}
