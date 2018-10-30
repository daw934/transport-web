package pl.transport.transportapp.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.transport.transportapp.UserAuth.repository.TokenRepository;

import java.util.UUID;

@Service
@Transactional
public class UserService {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;

    @Autowired
    private EmailSender emailSender;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
    public void saveRegisteredUser(User user){
        userRepository.save(user);

    }
    public boolean emailExist(User user){
        User check = userRepository.findByEmail(user.getEmail());
        if(check == null){
            return false;
        }else {
            return true;
        }

    }

    public void createVerificationToken(User user, String token){
        tokenRepository.save(new VerificationToken(user,token));
    }

    public void sendRegistrationEmail(User user,String appUrl) {
        String token = UUID.randomUUID().toString();
//        service.createVerificationToken(user,token);
        createVerificationToken(user,token);
        System.out.println("pierwszy");
        String recipientAddress = user.getEmail();
        System.out.println(user.getEmail());
        String subject = "Registration Confirmation";
        String confirmationUrl = appUrl+"/registrationConfirm?token=" + token;
//        String message = messageSource.getMessage("message.regSucc",null,this.locale);

        String content = "http://localhost:8080" + confirmationUrl;
//        EmailSender emailSender = (recipientAddress,subject,content);
        emailSender.setRecipientAddress(recipientAddress);
        emailSender.setContent(content);
        emailSender.setSubject(subject);
        taskExecutor.execute(emailSender);

        //        mailSender.send(email);
        System.out.println("wyslane");
    }

    public VerificationToken getVerificationToken(String token) {
           return tokenRepository.findByToken(token);
    }

}
