package me.bolshakov.gitChangelog

class ChangeSet {
    @NonCPS
    static def getChangeSets(build){
        build.changeSets
    }

    @NonCPS
    static def getJenkinsChanges(builds){
        def changes = []
        for (int x = 0; x < builds.size(); x++) {
            def currentBuild = builds[x];
            def changeLogSets = getChangeSets(currentBuild)
            for (int i = 0; i < changeLogSets.size(); i++) {
                def entries = changeLogSets[i].items
                for (int j = 0; j < entries.length; j++) {
                    def entry = entries[j]
                    String author = entry.author
                    def currentChange = new Change(author, entry.msg as String, 0);
                    changes.add(currentChange);
                }
            }
        }
        changes
    }

    static def retrieveGitChangelog(branch, isUnix){
        if(isUnix){
            sh returnStdout: true, script: "git log --pretty=medium ${branch}"
        }
        else{
            bat returnStdout: true, script: "git log --pretty=medium ${branch}"
        }
    }

    static def readGitChangelogPrettyMedium(changelog){
        //commit,Merge?,Author,Date,Title,Msg
        def changeList = []
        def commits = changelog.split("commit .+\n").tail()
        for(int i = 0; i < commits.length; i++){
            def commit = commits[i]
            def commitData = commit.split("\n")
            if(commitData.length < 4){
                continue
            }
            def parseChange = {offset ->
                commitData[(3+offset)..<commitData.length]
                        .collect{it -> it.trim()}
                        .findAll{it -> it != ""}
                        .each{it -> changeList.add(new Change(commitData[offset], it, i) )}
            }
            if(commitData[0].startsWith("Merge")){
                parseChange 1
            }
            else{
                parseChange 0
            }
        }
        changeList
    }
}
