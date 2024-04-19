package rest9.pkg1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndianMoviesController {
	@Autowired
	IndianMoviesRepo imr;
	
	@PostMapping("/movies/loadData/{fname}")
	public String loadData1(@PathVariable String fname) throws IOException{
		File f1=new File(fname);
		Scanner sc1=new Scanner(f1);
		sc1.nextLine();
		while(sc1.hasNext()) {
			String[] arr1=sc1.nextLine().split(",");
			imr.save(new IndianMoviesEntity(arr1[1], Integer.parseInt(arr1[2]), arr1[7]));
		}
		return "Inserted Successfully";
	}
	
	@GetMapping("/movies/1970s/hindi/{year}")
	public List<IndianMoviesEntity> find1970sMovies(@PathVariable int year){
		return imr.findMoviesByYear(year);
	}
}
