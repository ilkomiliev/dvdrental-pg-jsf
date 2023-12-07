package dvdrental.pg.jsf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("testapp.credentials")
public class FixUserCredentials {

    private List<UserCredentials> userCredentials;

    public List<UserCredentials> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(List<UserCredentials> userCredentials) {
        this.userCredentials = userCredentials;
    }
}
