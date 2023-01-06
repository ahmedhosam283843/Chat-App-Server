package com.hosamchat.data

import com.hosamchat.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    private val db: CoroutineDatabase
) : MessageDataSource {
    private val messages = db.getCollection<Message>()

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }

    override suspend fun getAllMessages(): List<Message> {
        return messages.find().descendingSort(Message::timestamp).toList()
    }
}