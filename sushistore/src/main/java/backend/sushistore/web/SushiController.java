package backend.sushistore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import backend.sushistore.domain.CategoryRepository;
import backend.sushistore.domain.Sushi;
import backend.sushistore.domain.SushiRepository;
import jakarta.validation.Valid;

@Controller
public class SushiController {
	@Autowired
	private SushiRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping(value="/sushilist")
	public String showSushis(Model model) {
		model.addAttribute("sushis", repository.findAll());
		return "sushilist";
	}
	
	@GetMapping(value="/add")
	public String addSushi(Model model) {
		model.addAttribute("sushi", new Sushi());
		model.addAttribute("categories", crepository.findAll()); //
		return "addsushi";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Sushi sushi) { 
		repository.save(sushi);
		return "redirect:sushilist";
	} 
	
	/*	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("sushi") Sushi sushi, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories" ,crepository.findAll());
			return "addsushi";
		}
		repository.save(sushi);
		return "redirect:/sushilist";
	} */
}
