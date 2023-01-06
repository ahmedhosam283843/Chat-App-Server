package com.hosamchat.data

import com.hosamchat.data.model.Message

interface MessageDataSource {
    suspend fun insertMessage(message: Message)

    suspend fun getAllMessages(): List<Message>
}