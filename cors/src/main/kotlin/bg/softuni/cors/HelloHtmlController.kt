package bg.softuni.cors

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloHtmlController {
  @GetMapping("/hello-html")
  fun getHello() : String {
    return "index"
  }
}
