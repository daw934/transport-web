package pl.transport.transportapp.UserAuth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailSender implements Runnable {


    private String recipientAddress;
    private String subject;
    private String content;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageSource messageSource;

    public EmailSender() {
    }


    public EmailSender(String recipientAddress,String subject,String content) {
        this.recipientAddress = recipientAddress;
        this.content = content;
        this.subject = subject;
    }

    @Override
    public void run() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
        System.out.println("mail was sent");
    }

    }

