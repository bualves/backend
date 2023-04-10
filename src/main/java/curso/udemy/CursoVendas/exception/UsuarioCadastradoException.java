package curso.udemy.CursoVendas.exception;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String login)
    {
        super("Usuario já cadastrado para o User: " + login);
    }

}
