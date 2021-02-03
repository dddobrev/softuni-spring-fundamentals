package bg.softuni.cors

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

  @GetMapping("/hello")
  fun getHello() : HelloMessage {
    return HelloMessage("Hello, world!", "Softuni!")
  }

}
