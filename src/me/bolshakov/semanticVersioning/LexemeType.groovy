package me.bolshakov.semanticVersioning

public enum LexemeType{
    Breaking('breaking', 'Breaking'),
    Feat('feat', 'Feature'),
    Fix('fix', 'Fix'),
    Minor('minor', 'Minor')

    final String id;
    final String desc;
    static final Map map
    static {
        map = [:] as TreeMap
        values().each{ it ->
            map.put(it.id, it)
        }
    }
    private LexemeType(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    static getLexemeType(String id) {
        map[id]
    }
}
