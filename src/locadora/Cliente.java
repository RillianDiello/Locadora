package locadora;

import java.sql.ResultSet;
import java.sql.SQLException;

import grenj.model.DestinationParty;
import grenj.util.Index;

public class Cliente extends DestinationParty {
	private String endereco;
	private String cidade;
	private String estado;
	private String fone;
	private String email;
	private String nomePai;
	private String nomeMae;
	private String docId;
	private String dataNasc;
	
	

	public Cliente(ResultSet result, Index anIndex) {
		super(result, anIndex);
		try {
			endereco = result.getString(anIndex.getIndex());
			cidade = result.getString(anIndex.getIndex());
			estado = result.getString(anIndex.getIndex());
			fone = result.getString(anIndex.getIndex());
			email = result.getString(anIndex.getIndex());
			nomePai = result.getString(anIndex.getIndex());
			nomeMae = result.getString(anIndex.getIndex());
			docId = result.getString(anIndex.getIndex());
			dataNasc = result.getString(anIndex.getIndex());
			//placa = result.getString(anIndex.getIndex());
			//ano = result.getInt(anIndex.getIndex());
			anIndex.incrementIndexByOne();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		setChanged( false );
	}
	
	public Cliente() {
		super();
		this.endereco = "";
		this.cidade = "";
		this.estado = "";
		this.fone = "";
		this.email = "";
		this.nomePai = "";
		this.nomeMae = "";
		this.docId = "";
		this.dataNasc = "";
		setChanged(false);
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dtNasc) {
		this.dataNasc = dtNasc;
	}
	
	public String insertionFieldClause()
	{
		return super.insertionFieldClause() + ", endereco, cidade, estado, fone, email, docId, dataNasc, nomePai, nomeMae";
	}
	
	public String insertionValueClause()
	{
		return super.insertionValueClause() + ", '" + getEndereco()+ " ','" +
				getCidade()+ " ','" + getEstado() + " ','" + getFone()
				+ " ','" + getEmail() + " ','" + getDocId() + " ','" + getDataNasc()
				+ " ','" + getNomePai()+ " ','" + getNomeMae()+"'";
	}
	public String updateSetClause()
	{
		return super.updateSetClause() 
				+ ", endereco = '" + this.getEndereco()
				+ "', cidade = " + this.getCidade()
				+ "', estado = " + this.getEstado()
				+ "', fone = " + this.getFone()
				+ "', email = " + this.getEmail()
				+ "', docId = " + this.getDocId()
				+ "', dataNasc = " + this.getDataNasc()
				+ "', NomePai = " + this.getNomePai()
				+ "', NomeMae = " + this.getNomeMae();
	}
	
}
