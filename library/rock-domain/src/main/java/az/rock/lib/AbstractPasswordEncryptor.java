package az.rock.lib;

public interface AbstractPasswordEncryptor {
    String encrypt(String rawPassword);

    String encrypt(String rawPassword,String salt);
    Boolean matches(String rawPassword, String encodedPassword);
}
