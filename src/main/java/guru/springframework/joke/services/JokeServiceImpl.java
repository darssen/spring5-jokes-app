package guru.springframework.joke.services;

import guru.springframework.joke.model.Joke;

import java.util.Random;
import guru.springframework.joke.repositories.ChuckNorrisQuotesRepository;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;

import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/25/17.
 */
@Service
public class JokeServiceImpl implements JokeService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;
	private final ChuckNorrisQuotesRepository chuckNorrisQuotesRepository;

	public JokeServiceImpl(ChuckNorrisQuotesRepository chuckNorrisQuotesRepository) {
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
		this.chuckNorrisQuotesRepository = chuckNorrisQuotesRepository;
	}
	
	

	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}



	@Override
	public String getJokeFromRepo() {
		

		Random rand = new Random();

		int  n = rand.nextInt(122) + 0;
		Optional<Joke> joke =chuckNorrisQuotesRepository.findById((long) n);
		if (joke.isPresent()){
			return joke.get().getJoke();
		}else
			return "Sorry, no joke available";
	}
}
