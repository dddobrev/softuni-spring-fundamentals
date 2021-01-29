package bg.softuni.lection6;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageController {

  private final String defaultLang = "bg";
  private final List<String> allLangs = List.of("en", "bg", "de");


  @PostMapping("/save")
  public String save(@RequestParam String lang,
      HttpServletResponse response,
      HttpSession session) {

    session.setAttribute("lang", lang);

    return "redirect:/all";
  }

  @GetMapping("/all")
  public String allLangs(Model model,
      HttpSession session) {

    Object preferredLang = session.getAttribute("lang");
    if (preferredLang == null) {
      preferredLang = defaultLang;
    }

    model.addAttribute("all", allLangs);
    model.addAttribute("preferredLang", preferredLang);
    return "languages";
  }
}
