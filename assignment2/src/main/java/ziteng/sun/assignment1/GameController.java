package ziteng.sun.assignment1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



@RestController
@RequestMapping("/game")
public class GameController {
	
	@GetMapping
	public ArrayList<Game> getAll() throws IOException{
		ArrayList<Game> list = readJSON();
		return list;
	}
	
	/**
	 * display information by game id
	 * @param id
	 * @return TvSeriesDto by id
	 * @throws IOException 
	 */

	@GetMapping("/{id}")
	public Game getOne(@PathVariable int id) throws ResourceNotFoundException, IOException {
		ArrayList<Game> list = readJSON();
		
		if(list.get(id) != null) {
			return list.get(id);
		} else {
			throw new ResourceNotFoundException();
		}
	}
	
	private ArrayList<Game> readJSON() throws IOException {
		URL url = new URL("https://api.myjson.com/bins/6a91g");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.connect();

	    BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        Gson gson = new Gson();
        ArrayList<Game> al = gson.fromJson(json, new TypeToken<ArrayList<Game>>(){}.getType());
		return al;		
	}
	
}
