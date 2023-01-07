package com.hosamchat.plugins

import com.hosamchat.room.RoomController
import com.hosamchat.routes.chatSocket
import com.hosamchat.routes.getAllMessages
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}
