package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private List<Character> characters;

    public Value() {
    }

    public List<Character> getQCharacters() {
        return this.characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Value{" +
                "characters='" + characters + '\'' +
                '}';
    }
}