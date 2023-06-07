package com.ziplink.core.entity

import jakarta.persistence.*

@Entity
@Table(name = "zip_link")
class ZipLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="short_url")
        val shortUrl: Long?,
        @Column(name="full_url")
        val fullUrl: String
)
