package web;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class dogController {

    private Map<String, Dog> dogMap = new HashMap<String, Dog>();

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.GET)
    public Dog selectDogByName(@PathVariable String name){
        return dogMap.get(name);
    }

    @RequestMapping(value = "dogs", method = RequestMethod.POST)
    public void createDog(@RequestBody Dog dog){
        dogMap.put(dog.getName(), dog);
        System.out.printf(dog.getColor());
    }

    @RequestMapping(value = "dogs/count", method = RequestMethod.GET)
    public int selectTotalDogCount(){
        return dogMap.size();
    }

    @RequestMapping(value = "dogs/{name}", method = RequestMethod.PUT)
    public Dog updateDogType(@PathVariable String name, @RequestParam String type){
        Dog dog = dogMap.get(name);
        dog.setType(type);
        return dog;
    }

    @RequestMapping(value = "dog/{name}", method = RequestMethod.DELETE)
    public Dog deleteDog(@PathVariable String name){
        if (dogMap.containsKey(name)) {
            return dogMap.remove(name);
        }
        else{
            throw new RuntimeException();
        }
    }

}
