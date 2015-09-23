package locadora;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

import grenj.model.DestinationParty;
import grenj.model.SingleResTransaction;
import grenj.model.Payment;
import grenj.model.Resource;
import grenj.model.ResourceRental;
import grenj.model.ResourceReservation;
import grenj.model.SourceParty;
import grenj.model.TransactionExecutor;
import grenj.model.TransactionItem;
import grenj.model.TransactionQuantificationStrategy;
import grenj.util.Index;

public class LocacaoCarro extends ResourceRental {
	private String horaInicial;
	private String horaFinal;
	private float kmRetirada;
	private float valorDiaria;
	private String servicoesAdicionais;

	@Override
	public Class<? extends ResourceReservation> getReservationClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public LocacaoCarro(ResultSet result, Index anIndex) {
		super(result, anIndex);
		try {
			horaInicial = result.getString(anIndex.getIndex());;
			horaFinal = result.getString(anIndex.getIndex());;
			kmRetirada = result.getInt(anIndex.getIndex());	
			valorDiaria = result.getInt(anIndex.getIndex());
			servicoesAdicionais = result.getString(anIndex.getIndex());
			anIndex.incrementIndexByOne();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		setChanged( false );
	}
	
	public LocacaoCarro() {
		super();
		this.horaInicial = "";
		this.horaFinal = "";
		this.kmRetirada = 0;
		this.valorDiaria = 0;
		this.servicoesAdicionais = "";
		setChanged(false);
	}



	public TransactionQuantificationStrategy
		getTransactionQuantificationStrategyInstance() {
		return new SingleResTransaction();
	}


	@Override
	public boolean hasAssociatedSale() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasFineRate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasReservation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<? extends DestinationParty> getDestinationPartyClass() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public Class<? extends TransactionExecutor> getExecutorClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Payment> getPaymentClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Resource> getResourceClass() {
		// TODO Auto-generated method stub
		return Carro.class;
	}

	@Override
	public Class<? extends SourceParty> getSourcePartyClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends TransactionItem> getTransactionItemClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasExecutor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPayment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSourceParty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String transactionPluralName() {
		// TODO Auto-generated method stub
		return "Locação de carro";
	}

	
	public float getKmRetirada() {
		return kmRetirada;
	}

	public void setKmRetirada(float kmRetirada) {
		this.kmRetirada = kmRetirada;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getServicoesAdicionais() {
		return servicoesAdicionais;
	}

	public void setServicoesAdicionais(String servicoesAdicionais) {
		this.servicoesAdicionais = servicoesAdicionais;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
}
