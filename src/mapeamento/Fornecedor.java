	package mapeamento;
	import java.io.Serializable;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.SequenceGenerator;


	@SuppressWarnings("serial")
	@Entity
	@SequenceGenerator(name="fornecedor_seq", sequenceName="fornecedor_seq", allocationSize=1)
	public class Fornecedor implements Serializable{

	    @Id
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fornecedor_seq")
	    @Column( updatable = false)
	    private int id_fornecedor;

	    @Column
	    private String nome_fornecedor;

	    @Column
	    private String cnpj_fornecedor;

	    @Column
	    private String telefone_fornecedor;

	    @Column
	    private String email_fornecedor;

	    @Column
	    private String endereco_fornecedor;

	    public int getId_fornecedor() {
	        return id_fornecedor;
	    }

	    public void setId_fornecedor(int id_fornecedor) {
	        this.id_fornecedor = id_fornecedor;
	    }

	    public String getNome_fornecedor() {
	        return nome_fornecedor;
	    }

	    public void setNome_fornecedor(String nome_fornecedor) {
	        this.nome_fornecedor = nome_fornecedor;
	    }

	    public String getCnpj_fornecedor() {
	        return cnpj_fornecedor;
	    }

	    public void setCnpj_fornecedor(String cnpj_fornecedor) {
	        this.cnpj_fornecedor = cnpj_fornecedor;
	    }

	    public String getTel_fornecedor() {
	        return telefone_fornecedor;
	    }

	    public void setTel_fornecedor(String tel_fornecedor) {
	        this.telefone_fornecedor = tel_fornecedor;
	    }

	    public String getEmail_fornecedor() {
	        return email_fornecedor;
	    }

	    public void setEmail_fornecedor(String email_fornecedor) {
	        this.email_fornecedor = email_fornecedor;
	    }

	    public String getEndereco_cliente() {
			return endereco_fornecedor;
		}

		public void setEndereco_fornecedor(String endereco_fornecedor) {
			this.endereco_fornecedor = endereco_fornecedor;
		}

		public String toString(){
			   return nome_fornecedor;
			}

	}
