package de.flocksserver.domain.repository

import de.flocksserver.domain.model.ContentModel
import de.flocksserver.domain.model.ItemModel
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by marcel on 27.07.17.
 */
interface MyRepository {
    fun getContent(): Single<ContentModel>
    fun addItem(): Completable
    fun deleteItem(itemModel: ItemModel): Completable
}