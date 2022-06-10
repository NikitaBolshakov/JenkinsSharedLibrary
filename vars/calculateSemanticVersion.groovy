import me.bolshakov.gitChangelog.ChangeSet
import me.bolshakov.semanticVersioning.LexemeType

@NonCPS
private def takeLessThen(lexemes, lexemeType){
    lexemes.takeWhile{it.lexemeType != lexemeType}
}

@NonCPS
def call(branch) {
    changelog = ChangeSet.retrieveGitChangelog(branch)
    lexemes = ChangeSet.readGitChangelogPrettyMedium(changelog)
    countWithTypeFiltered = {arr, lType ->  arr.findAll{z -> z.lexemeType == lType}.size()}
    countWithType = {it -> countWithTypeFiltered(lexemes, it)}

    return "${countWithType(LexemeType.Breaking) + 1}.${countWithTypeFiltered(takeLessThen(lexemes, LexemeType.Breaking), LexemeType.Feat)}.${countWithTypeFiltered(takeLessThen(lexemes, LexemeType.Feat), LexemeType.Fix)}"
}
