package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.service.UserLoginServiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

  @ModelAttribute("userModel")
  public UserLoginServiceModel userModel() {
    return new UserLoginServiceModel();
  }

  @GetMapping("/users/login")
  public String showLogin() {
    return "auth-login";
  }
}
