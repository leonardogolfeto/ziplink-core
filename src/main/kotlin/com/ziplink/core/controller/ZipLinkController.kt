package com.ziplink.core.controller

import com.ziplink.core.service.ZipLinkService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class ZipLinkController(val zipLinkService :ZipLinkService) {

    @GetMapping("/{shortUrl}")
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
    fun shortenUrl(@RequestParam fullUrl: String) : Long?   {
        return zipLinkService.shortenUrl(fullUrl)
    }

}