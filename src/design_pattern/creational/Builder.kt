package design_pattern.creational

fun main() {
    val mail = Mail("hello@gmail.com")
        .apply {
            message = "Something"
            title = "Apply"
            cc = listOf("sina@gmail.com", "parsa@gmail.com")
        }
    mail.bcc = listOf("ABC")

    val mailBuilder = MailBuilder("hello@gmail.com")
        .title("Apply")
        .message("Something")
        .cc(listOf("sina@gmail.com", "parsa@gmail.com"))
        .bcc(listOf("ABC"))
        .build()

    println("Mail -> $mail")
    println("MailBuilder -> $mailBuilder")
}

data class Mail(
    val to: String,
    var title: String = "",
    var message: String = "",
    var cc: List<String> = listOf(),
    var bcc: List<String> = listOf(),
    var attachments: List<java.io.File> = listOf()
)

class MailBuilder(private val to: String) {

    private var mail: Mail = Mail(to = to)

    fun title(title: String): MailBuilder {
        mail.title = title
        return this
    }

    fun message(message: String): MailBuilder {
        mail.message = message
        return this
    }

    fun cc(cc: List<String>): MailBuilder {
        mail.cc = cc
        return this
    }

    fun bcc(bcc: List<String>): MailBuilder {
        mail.bcc = bcc
        return this
    }

    fun attachments(attachments: List<java.io.File>): MailBuilder {
        mail.attachments = attachments
        return this
    }

    fun build(): Mail {
        return mail
    }
}