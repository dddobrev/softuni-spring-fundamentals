package bg.softuni.cors

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CorsApplication

fun main(args: Array<String>) {
	runApplication<CorsApplication>(*args)
}
