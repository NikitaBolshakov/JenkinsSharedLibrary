import me.bolshakov.gitChangelog.Change

def call(builds){
    def changes = []
    for (int x = 0; x < builds.size(); x++) {
        def currentBuild = builds[x];
        def changeLogSets = currentBuild.rawBuild.changeSets
        for (int i = 0; i < changeLogSets.size(); i++) {
            def entries = changeLogSets[i].items
            for (int j = 0; j < entries.length; j++) {
                entry = entries[j]
                String author = entry.author
                def currentChange = new Change(author, entry.msg as String, 0);
                changes.add(currentChange);
            }
        }
    }
    changes
}
