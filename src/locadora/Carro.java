package locadora;

import grenj.model.Resource;
import grenj.util.Index;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro extends Resource {
	private String placa;
	private int ano;
	
	
	public Carro(ResultSet result, Index anIndex) {
		super(result, anIndex);
		try {
			placa = result.getString(anIndex.getIndex());
			ano = result.getInt(anIndex.getIndex());
			anIndex.incrementIndexByOne();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		setChanged( false );
	}
	
	public Carro() {
		super();
		this.placa = "";
		this.ano = 0;
		setChanged(false);
	}

	public Class getMeasureUnityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getResourceInstanceClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getResourceRentalClass() {
		// TODO Auto-generated method stub
		return LocacaoCarro();
	}

	public Class[] typeClasses() {
		// TODO Auto-generated method stub
		return new Class[]{Categoria.class, Fabricante.class, Marca.class,
				Modelo.class};
	}

	protected String[] typeFieldsInitialize() {
		// TODO Auto-generated method stub
		return new String[] {"categoria", "fabricante", "marca",
		"modelo"};
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String insertionFieldClause()
	{
		return super.insertionFieldClause() + ", placa, ano";
	}
	
	public String insertionValueClause()
	{
		return super.insertionValueClause() + ", '" + getPlaca()+ " '," +
				getAno();
	}
	public String updateSetClause()
	{
		return super.updateSetClause() + ", placa = '" + this.getPlaca()+
				"', ano = " + this.getAno();
	}

}
