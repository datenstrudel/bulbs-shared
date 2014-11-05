package net.datenstrudel.bulbs.shared.domain.model.client.identity;

import javax.validation.constraints.Size;

/**
 *
 * @author Thomas Wendzinski
 */
public class DtoBulbsContextUser{

    //~ Member(s) //////////////////////////////////////////////////////////////
    @Size(min = 5, max = 128)
    private String email;
    @Size(min = 2, max = 16)
    private String nickname;
    @Size(min = 6, max = 64)
    private String password;
    private String apiKey;
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    //~ Private Artifact(s) ////////////////////////////////////////////////////

    //~ Construction ///////////////////////////////////////////////////////////
    public DtoBulbsContextUser() {
    }
    
    public void clearDto(){
        setEmail(null);
        setNickname(null);
        setApiKey(null);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
