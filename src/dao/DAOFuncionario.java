/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernateUtil.HibernateUtil;
import java.util.List;
import mapeamento.Funcionario;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ale
 */
public class DAOFuncionario {
    private Session sessao;

    public List<Funcionario> getNomeFuncionario(String nome_func) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.getTransaction();

        // AQUI VAI ME RETORNAR UM OBJETO DA CLASSE FUNCIONARIO
        List<Funcionario> func = (List<Funcionario>) sessao.createCriteria(Funcionario.class)
                .add(Restrictions.eq("nome_func", nome_func))
                .list();
                return func;
    }
}
