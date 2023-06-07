package com.ziplink.core.controller

import com.ziplink.core.service.ZipLinkService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ZipLinkController(val zipLinkService :ZipLinkService) {

    @GetMapping("/{shortUrl}")
    @ResponseStatus(code = HttpStatus.MOVED_PERMANENTLY)
    fun getFullUrl(@PathVariable shortUrl: String): ResponseEntity<String> {
        val fullUrl = zipLinkService.getFullUrl(shortUrl)

        if (fullUrl.isPresent) {
            return ResponseEntity
                    .status(HttpStatus.MOVED_PERMANENTLY)
                    .header(HttpHeaders.LOCATION, fullUrl.get())
                    .build()
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Not found")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun shortenUrl(@RequestParam fullUrl: String) : Long?{
        return zipLinkService.shortenUrl(fullUrl)
    }

}