package io.isfaculty.controller

import io.isfaculty.model.AccountEntity
import io.isfaculty.model.UserRole
import io.isfaculty.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("")
class MainController @Autowired constructor(private val accountService: AccountService) {

    @RequestMapping("/")
    fun index(mode: Model): String {
        return "index"
    }

    @GetMapping("/login")
    fun loginPage(): String {
        return "login"
    }

    @GetMapping("/about")
    fun aboutPage(): String {
        return "about"
    }

    @GetMapping("/signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun signUpPage(): AccountEntity {

        val accountEntity = AccountEntity();
        accountEntity.username = "admin"
        accountEntity.password = "pass"
        accountEntity.userRole = UserRole.ROLE_ADMIN

        return accountService.create(accountEntity)
    }
}