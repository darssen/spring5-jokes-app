package guru.springframework.joke.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.joke.model.Joke;



public interface ChuckNorrisQuotesRepository extends CrudRepository<Joke, Long>  {
	
}
