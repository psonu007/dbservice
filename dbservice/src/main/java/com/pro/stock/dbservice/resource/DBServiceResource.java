package com.pro.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.stock.dbservice.model.Quote;
import com.pro.stock.dbservice.repository.QuotesRepository;
import com.pro.stock.dbservice.vo.Quotes;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
 
	@Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getQuotesByUserName(username);

	}

	private List<String> getQuotesByUserName(final String username) {
		return quotesRepository.findByUserName(username).stream().map(Quote::getQuote).collect(Collectors.toList());
	}

	@PostMapping("/add")
	public List<String> add(@RequestBody Quotes quotes)

	{
		quotes.getQuotes().forEach(quote -> {

			Quote quotes1 = new Quote();
			quotes1.setQuote(quote);
			quotes1.setUserName(quotes.getUserName());

			quotesRepository.save(quotes1);
		}

		);
		return getQuotesByUserName(quotes.getUserName());

	}

}
