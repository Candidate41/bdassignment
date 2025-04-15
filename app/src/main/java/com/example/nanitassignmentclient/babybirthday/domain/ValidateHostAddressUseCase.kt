package com.example.nanitassignmentclient.babybirthday.domain

private val ipv4Pattern = "^((25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.|$)){4}$".toPattern()
private val ipv6Pattern = "^[0-9a-fA-F:]+$".toPattern()

class IsValidHostAddressUseCase {

    operator fun invoke(host: String) : Boolean {
        return ipv4Pattern.matcher(host).matches() ||
                ipv6Pattern.matcher(host).matches()
    }
}