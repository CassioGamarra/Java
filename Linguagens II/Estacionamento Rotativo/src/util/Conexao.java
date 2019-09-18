package util;

/**
 * Singleton com as conexões do banco
 * @author cassio
 */
public class Conexao {
    private static Conexao instance;
    private String url;
    private String user;
    private String password;
    
    private Conexao(){}
    
    public static Conexao getInstance(){
        if(instance == null){
            instance = new Conexao();
        }
        return instance;
    }
    
    public void gerar(){
        setUrl("jdbc:mysql://localhost:3306/GARAGEM?useTimezone=true&serverTimezone=UTC");
        setUser("root");
        setPassword("root");
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {        
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
