package bg.softuni.cors

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController {

  companion object {
    private val LOGGER = LoggerFactory.getLogger(HelloRestController::class.java)
  }

  @CrossOrigin(origins = ["*"])
  @GetMapping("/hello-rest")
  fun getHello(@CookieValue(required = false) name: String?) : HelloMessage {
    LOGGER.info("Serving HELLO REST!")
    return HelloMessage("Hello, world!", "Softuni!")
  }

}
