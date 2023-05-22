package az.rock.lib;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class GPasswordEncryptor implements AbstractPasswordEncryptor {
    @Override
    public String encrypt(String rawPassword) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.encryptPassword(rawPassword);
    }

    @Override
    public String encrypt(String rawPassword, String salt) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.encryptPassword(rawPassword);
    }

    @Override
    public Boolean matches(String rawPassword, String encodedPassword) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.checkPassword(rawPassword, encodedPassword);
    }

}
