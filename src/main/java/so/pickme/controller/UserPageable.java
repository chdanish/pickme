package so.pickme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import so.pickme.domain.User;
import so.pickme.repository.UserRepository;
import so.pickme.service.UserPageService;
import so.pickme.util.UserMapper;

@Controller
@RequestMapping
@Order(2)
public class UserPageable {
	
	
	
	@Autowired
	private UserPageService userPageService;
	
	@Autowired
	private UserRepository repository;

	/**
	 * <p>
	 * Populates the model with the domain objects. Used in all examples that
	 * use a DOM source.
	 * 
	 * @return a list of persons for display.
	 */
	@ModelAttribute("users")
	public List<User> populateTable() {
		int count =0;
		for ( @SuppressWarnings("unused") User user : repository.findAll()) {
			count = count+1;
		    }	
		
		return userPageService.findLimited(count);
	}

	@RequestMapping("/userpageable")
	public String goToIndex(HttpServletRequest request) {
		return "/userpageable";
	}
	
	@RequestMapping(value="/edit")
	public String edit(Long id, ModelMap model) {
		Pageable pageRequest = new PageRequest(0, 100);
		Page<User> users = repository.findAll(pageRequest);
		model.addAttribute("users", UserMapper.map(users));
		model.addAttribute("commanduser", UserMapper.map(repository.findOne(id)));
		model.addAttribute("usertype", "update");
		return "users";
	}
	
	@RequestMapping(value="/delete")
	public String delete(Long id) {
		User existingUser = new User();
		existingUser.setId(id);
		repository.delete(existingUser);
		return "redirect:/users";
	}

}
