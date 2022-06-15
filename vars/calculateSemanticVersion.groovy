import me.bolshakov.gitChangelog.ChangeSet
import me.bolshakov.semanticVersioning.LexemeType

@NonCPS
private def takeLessThen(lexemes, lexemeType){
    lexemes.takeWhile{it.lexemeType != lexemeType}
}

//@NonCPS
def getChangelogUnix(branch){
    sh(returnStdout: true, script: "git log --pretty=medium ${branch}")
}

//@NonCPS
def getChangelogWindows(branch){
    bat(returnStdout: true, script: "git log --pretty=medium ${branch}")
}

//@NonCPS
def getChangelog(branch){
    if(isUnix()){
        return getChangelogUnix(branch);
    }
    return getChangelogWindows(branch)
}

//@NonCPS
def call(branch) {
    changelog = getChangelog(branch)
    lexemes = ChangeSet.readGitChangelogPrettyMedium(changelog)
            .findAll{s -> s.message ==~ '''(fix|feat|breaking|minor)(\\([A-Z]+-\\d+\\)|\\(\\))!?:.*'''}
            .collect{t -> identifyToken(t.message)}
    countWithTypeFiltered = {arr, lType ->  arr.findAll{z -> z.lexemeType == lType}.size()}
    countWithType = {it -> countWithTypeFiltered(lexemes, it)}

    return "${countWithType(LexemeType.Breaking) + 1}.${countWithTypeFiltered(takeLessThen(lexemes, LexemeType.Breaking), LexemeType.Feat)}.${countWithTypeFiltered(takeLessThen(lexemes, LexemeType.Feat), LexemeType.Fix)}"
}
