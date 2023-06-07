package com.ziplink.core.repository

import com.ziplink.core.entity.ZipLinkEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ZipLinkRepository : JpaRepository<ZipLinkEntity, String>
