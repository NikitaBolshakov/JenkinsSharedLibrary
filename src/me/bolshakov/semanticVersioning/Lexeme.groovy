package me.bolshakov.semanticVersioning

class Lexeme{
    LexemeType lexemeType;
    Boolean isFatal;
    String taskId;
    String description

    @NonCPS
    @Override
    String toString() {
        """
        LexemeType: $lexemeType
        IsFatal: $isFatal
        TaskId: $taskId
        Description: $description
        """
    }
}
