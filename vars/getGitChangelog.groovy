import me.bolshakov.gitChangelog.ChangeSet

@NonCPS
def call(builds){
    ChangeSet.getChanges(builds)
}
