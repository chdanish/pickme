package so.pickme.controller;

import java.util.List;

import so.pickme.domain.Role;
import so.pickme.domain.User;
import so.pickme.repository.UserRepository;
import so.pickme.response.UserDto;
import so.pickme.service.UserService;
import so.pickme.util.RoleUtil;
import so.pickme.util.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired 
	private UserService service;
	
	@ModelAttribute("allRoles")
	public List<Integer> getAllRoles() {
		return RoleUtil.roles();
	}
	
	@RequestMapping
	public String getUsersPage(ModelMap model) {
		model.addAttribute("authname", SecurityContextHolder.getContext().getAuthentication().getName());
		Pageable pageRequest = new PageRequest(0, 100);
		Page<User> users = repository.findAll(pageRequest);
		model.addAttribute("users", UserMapper.map(users));
		model.addAttribute("commanduser", new UserDto());
		model.addAttribute("usertype", "new");
		return "users";
	}
	
	@RequestMapping(value="/get", produces="application/json")
	public @ResponseBody UserDto get(@RequestBody UserDto user) {
		return UserMapper.map(repository.findByUsername(user.getUsername()));
	}

	@RequestMapping(value="/create", produces="application/json", method=RequestMethod.POST)
	public String create(UserDto dto) {
		if (dto.getId() != null)  {
			User existingUser = UserMapper.map(dto);
			existingUser.setRole(new Role(dto.getRole(), existingUser));
			service.update(existingUser);
		} else {
			User newUser = UserMapper.map(dto);
			newUser.setRole(new Role(dto.getRole(), newUser));
			service.create(newUser);
		}
		return "redirect:/users";
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
		service.delete(existingUser);
		return "redirect:/users";
	}
}
