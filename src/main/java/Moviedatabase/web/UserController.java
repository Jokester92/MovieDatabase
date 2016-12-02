package Moviedatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import Moviedatabase.domain.User;
import Moviedatabase.domain.UserRepository;
import Moviedatabase.domain.SignUp;

@Controller
public class UserController {
	@Autowired
    private UserRepository repository; 
	
    @RequestMapping(value = "signup")
    public String addUser(Model model){
    	model.addAttribute("signup", new SignUp());
        return "signup";
    }	
    
    /**
     * Create new user
     * Check if user already exists & form validation
     * 
     * @param signupForm
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignUp signUp, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signUp.getPassword().equals(signUp.getPasswordCheck())) { // check password match		
	    		String pwd = signUp.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signUp.getUsername());
		    	newUser.setRole("USER");
		    	if (repository.findByUsername(signUp.getUsername()) == null) { // Check if user exists
		    		repository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/logon";    	
    }    
    
}

