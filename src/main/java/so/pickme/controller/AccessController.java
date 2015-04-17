package so.pickme.controller;

import so.pickme.domain.Role;
import so.pickme.domain.User;
import so.pickme.repository.UserRepository;
import so.pickme.response.UserDto;
import so.pickme.service.PassEncoder;
import so.pickme.service.UserPageService;
import so.pickme.util.RoleUtil;
import so.pickme.util.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
@Order(1)
public class AccessController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PassEncoder pe;
	@Autowired
	private UserPageService userPageService;

	/**
	 * <p>
	 * Populates the model with the domain objects. Used in all examples that
	 * use a DOM source.
	 * 
	 * @return a list of persons for display.
	
	@ModelAttribute("users")
	public List<User> populateTable() {
		return userPageService.findLimited(5);
	}

	@RequestMapping("/userpageable")
	public String goToIndex(HttpServletRequest request) {
		return "/userpageable";
	} */

	
	
	@RequestMapping("/login")
	public String login() {
		String str=(String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		System.out.println(str);
		return "access/login";
	}

	@RequestMapping("/denied")
	public String denied(ModelMap model) {
		model.addAttribute("error", "access.denied");
		return "error";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "access/login";
	}


	@RequestMapping("/login/failure")
	public String loginFailure(ModelMap model) {
		model.addAttribute("status", "login.failure");
		return "access/login";
	}

	@RequestMapping("/logout/success")
	public String logoutSuccess(ModelMap model) {
		model.addAttribute("status", "logout.success");
		return "access/login";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "access/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String createAccount(UserDto dto, ModelMap model) {
		if (userRepository.findByUsername(dto.getUsername()) != null) {
			model.addAttribute("status", "signup.invalid.username.duplicate");
			return "access/signup";
		}
		
		if (dto.getPassword().equals(dto.getRepassword()) == false) {
			model.addAttribute("status", "signup.invalid.password.notmatching");
			return "access/signup";
		}
		if(!(dto.getEmail().equals(dto.getReemail()))){

			System.out.println(dto.getEmail());
			System.out.println(dto.getReemail());
			model.addAttribute("status", "signup.invalid.Email.notmatching");
			return "access/signup";
		}
		
		User user = UserMapper.map(dto);
		System.out.println(user.getPassword());
		System.out.println("Setting PWD for new user about to save");
		
		//String hashedPassword = pe.passDecoder().encode(user.getPassword());
		String hashedPassword = PassEncoder.passDecoder().encode(user.getPassword());
	
        user.setPassword(hashedPassword);
		System.out.println("AND PWD is :"+hashedPassword);
		
		if(dto.getRole()==3){
			user.setRole(new Role(RoleUtil.ROLE_VEHICLE_USER, user));
		}
		else if(dto.getRole()==4){
			user.setRole(new Role(RoleUtil.ROLE_NON_VEHICLE_USER, user));
			
		}else if(dto.getRole()==5){
			user.setRole(new Role(RoleUtil.ROLE_TAXI_OWNER_USER, user));
			
		}else if(dto.getRole()==6){
			user.setRole(new Role(RoleUtil.ROLE_TRANSPORT_SERVICES_USER, user));
		}
		//user.setRole(new Role(RoleUtil.ROLE_USER, user));
		user = userRepository.save(user);
		return "redirect:/";
	}
}