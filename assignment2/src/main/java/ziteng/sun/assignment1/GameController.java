package ziteng.sun.assignment1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@RestController
@RequestMapping("/game")
public class GameController {
	
	@GetMapping
	public ArrayList<Game> getAll() throws FileNotFoundException{
		ArrayList<Game> list = readJSON();
		return list;
	}
	
	/**
	 * display information by game id
	 * @param id
	 * @return TvSeriesDto by id
	 * @throws FileNotFoundException 
	 */

	@GetMapping("/{id}")
	public Game getOne(@PathVariable int id) throws ResourceNotFoundException, FileNotFoundException {
		ArrayList<Game> list = readJSON();
		
		if(list.get(id) != null) {
			return list.get(id);
		} else {
			throw new ResourceNotFoundException();
		}
	}
	
	private ArrayList<Game> readJSON() throws FileNotFoundException {
		
		
		String path = "C:\\ZSun\\Eclipse WorkSpace\\assignment2\\src\\main\\resources\\Games.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        ArrayList<Game> al = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Game>>(){}.getType());
		return al;		
	}
	
}
