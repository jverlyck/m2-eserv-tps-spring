package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

	@Autowired
	private CharacterRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Character> getCharacters() {

    	return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Character getCharacter(@PathVariable Long id) {
    	return repository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Character postCharacter(@RequestBody Character character) {
    	return repository.save(character);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Character putCharacter(@PathVariable Long id, @RequestBody Character character) {
    	Character c = repository.findOne(id);

    	c.setFirstName(character.getFirstName());
    	c.setLastName(character.getLastName());

    	return repository.save(c);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCharacter(@PathVariable Long id) {
    	repository.delete(id);
    } 

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Character> getCharacterByLastName(@RequestParam String name) {
    	return repository.findByLastName(name);
    }
}