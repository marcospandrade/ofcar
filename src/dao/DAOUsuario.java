package dao;

import hibernateUtil.HibernateUtil;
import mapeamento.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DAOUsuario {

    private Session sessao;

    public Usuario getUsuarioLoginSenha(String username, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.getTransaction();

        // AQUI VAI ME RETORNAR UM OBJETO DA CLASSE USUÁRIO
        return (Usuario) sessao.createCriteria(Usuario.class)
                // AQUI DIGO QUE DEVE TER O LOGIN IGUAL AO PASSADO POR PARAMETRO 
                .add(Restrictions.eq("username", username))
                // AQUI DIGO QUE DEVE TER O SENHA IGUAL AO PASSADO POR PARAMETRO
                .add(Restrictions.eq("senha", senha))
                // AQUI SETO PARA ME RETORNAR APENAS 1 RESULTADO
                // AFINAL LOGIN E SENHA É UNICO NO SISTEMA
                .uniqueResult();
    }

}
