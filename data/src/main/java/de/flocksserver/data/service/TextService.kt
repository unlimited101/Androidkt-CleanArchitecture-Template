package de.flocksserver.data.service

import java.security.SecureRandom
import java.util.*
import javax.inject.Inject

/**
 * Created by marcel on 8/30/17.
 */
class TextService @Inject constructor(){

    private val LENGTH = 21
    private val UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val LOWER = UPPER.toLowerCase(Locale.ROOT)
    private val DIGITS = "0123456789"
    private val alphanum = UPPER + LOWER + DIGITS
    private var random: Random = SecureRandom()
    private var symbols: CharArray = alphanum.toCharArray()
    private var buf: CharArray = CharArray(LENGTH)


    fun generateText(): String{
        for (idx in 0 until buf.size){
            buf[idx] = symbols[random.nextInt(symbols.size)]
        }
        return String(buf)
    }





}