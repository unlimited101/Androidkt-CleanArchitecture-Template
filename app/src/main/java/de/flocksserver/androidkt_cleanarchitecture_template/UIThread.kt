package de.flocksserver.androidkt_cleanarchitecture_template

import de.flocksserver.data.PerApplication
import de.flocksserver.domain.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by marcel on 24.07.17.
 */
@PerApplication
class UIThread @Inject constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}