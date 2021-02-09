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
    private var counter = 0;
  }

  //@CrossOrigin(origins = ["*"])
  @GetMapping("/hello-rest")
  fun getHello() : HelloMessage {
    LOGGER.info("Serving HELLO REST, No. {}!", counter++)
    return HelloMessage(message = "Hello, world!", from = "Softuni!")
  }

}
