package de.flocksserver.domain

import io.reactivex.Scheduler


interface PostExecutionThread {
    val scheduler: Scheduler
}