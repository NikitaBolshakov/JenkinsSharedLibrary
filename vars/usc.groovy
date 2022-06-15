call(script){
    if(isUnix()){
        sh(script:script, returnStdout:true)
    }
    else
        powershell(script:script, returnStdout:true)
}
