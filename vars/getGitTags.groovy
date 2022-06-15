def call(){
    usc(script:"git tag", returnStdout:true).trim().split('\n')
}
