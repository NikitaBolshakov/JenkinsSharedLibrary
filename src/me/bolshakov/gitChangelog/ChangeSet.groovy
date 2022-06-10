package me.bolshakov.gitChangelog

class ChangeSet {
    @NonCPS
    static def getChangeSets(build){
        build.changeSets
    }

    @NonCPS
    static def getChanges(builds){
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
}
