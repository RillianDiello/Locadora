package locadora;

import java.sql.ResultSet;
import java.sql.SQLException;

import grenj.model.SimpleType;
import grenj.util.Index;

public class Categoria extends SimpleType {
	private float precoDiaria;
	private float precoSemanal;
	private float precoMensal;
	public Categoria() {
		super();
		this.precoDiaria = 0;
		this.precoSemanal = 0;
		this.precoMensal = 0;
		setChanged(false);
	}
	
	public Categoria(ResultSet result, Index anIndex) {
		super(result, anIndex);
		try {
			precoDiaria = result.getInt(anIndex.getIndex());;
			precoSemanal = result.getInt(anIndex.getIndex());;
			precoMensal = result.getInt(anIndex.getIndex());			
			anIndex.incrementIndexByOne();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		setChanged( false );
	}
	public float getPrecoDiaria() {
		return precoDiaria;
	}
	public void setPrecoDiaria(float precoDiaria) {
		this.precoDiaria = precoDiaria;
	}
	public float getPrecoSemanal() {
		return precoSemanal;
	}
	public void setPrecoSemanal(float precoSemanal) {
		this.precoSemanal = precoSemanal;
	}
	public float getPrecoMensal() {
		return precoMensal;
	}
	public void setPrecoMensal(float precoMensal) {
		this.precoMensal = precoMensal;
	}
	
	public String insertionFieldClause()
	{
		return super.insertionFieldClause() + ", precoDiaria, precoSemanal, precoMensal";
	}
	
	public String insertionValueClause()
	{
		return super.insertionValueClause() + ", " + getPrecoDiaria()+ " ," +
				getPrecoSemanal()+ " ," + getPrecoMensal();
	}

	public String updateSetClause()
	{
		return super.updateSetClause() + ", precoDiaria = " + this.getPrecoDiaria()+
				", PrecoSemanal = " + this.getPrecoSemanal() +
				", PrecoSemanal = " + this.getPrecoMensal();
	}
	
}
