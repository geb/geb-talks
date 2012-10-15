package util

import grails.plugin.remotecontrol.RemoteControl
import com.icegreen.greenmail.util.GreenMailUtil

class Emails {

    RemoteControl remote = new RemoteControl(useStringRepresentationIfResultWasUnserializable: true)

    void clean() {
        remote.exec { ctx.greenMail.deleteAllMessages() }
    }

    int getCount() {
        remote.exec { ctx.greenMail.receivedMessages.length }
    }

    String getBody(i = -1) {
        remote.exec(createMessageGetter(i), { GreenMailUtil.getBody(it) })
    }
    
    private createMessageGetter(i = -1) {
        return {
            def emailMessages = ctx.greenMail.receivedMessages
            def index = (i == -1 || i == null ? emailMessages.length - 1 : i)
            if (index == -1) {
                throw new IllegalStateException("There are no email messages")
            }
            emailMessages[index]
        }
    }
    
}