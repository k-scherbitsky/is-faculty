package io.isfaculty.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MainController {

    @RequestMapping("/")
    fun index(mode: Model): String {
        return "index"
    }
}