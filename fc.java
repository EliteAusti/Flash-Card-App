package fca;
public class fc {
    String word;
    String definition;
    public fc(String word1,String definition1){
        this.word=word1;
        this.definition=definition1;
    }
    public String getDefinition(){
        return definition;
    }
    public String getWord(){
        return word;
    }
    public void setDefinition(String definition1){
        definition=definition1;
    }
    public void setWord(String word1){
        word=word1;
    }
    public String toString(){
        return "Word: "+word+"   Definition: "+definition;
    }

}
