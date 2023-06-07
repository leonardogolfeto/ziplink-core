package com.ziplink.core.service

import com.ziplink.core.entity.ZipLinkEntity
import com.ziplink.core.repository.ZipLinkRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ZipLinkService(val zipLinkRepository: ZipLinkRepository) {
    fun getFullUrl(shortUrl: String): Optional<String> {
        return zipLinkRepository
                .findById(shortUrl)
                .map{ it.fullUrl }
    }

    fun shortenUrl(fullUrl: String): Long? {
        val newZipLink = zipLinkRepository.save(ZipLinkEntity(null, fullUrl))
        return newZipLink.shortUrl
    }

}
