import me.bolshakov.semanticVersioning.Lexeme
import me.bolshakov.semanticVersioning.LexemeType

def call(String token) {
    lexeme = new Lexeme()
    data_description = token.tokenize(':')
    if(data_description.size > 1){
        lexeme.description  = data_description[1]
    }
    data = data_description[0]
    lexeme.isFatal = data[data.length() - 1] == '!'
    lexeme.lexemeType = LexemeType.getLexemeType(data.substring(0, data.indexOf('('))) as LexemeType
    lexeme.taskId = data.substring(data.indexOf('(') + 1, data.indexOf(')'))
    lexeme
}