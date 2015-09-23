package locadora;

import grenj.model.QualifiableObject;
import grenj.util.Status;
import grenj.util.TransactionStatus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis());
		// Cadastra um objeto do tipo Categoria
		Categoria cat1 = new Categoria();
		cat1.setIdCode(rd.nextInt(1000) + 1);
		cat1.setDescription("Popular");
		cat1.setPrecoDiaria((float) 7.52);
		cat1.setPrecoSemanal((float) 42.00);
		cat1.setPrecoMensal((float) 142.00);
		if (cat1.save() == 1) {
			System.out.println("Categoria: " + cat1.getDescription() +
				" cadastrada com successo!");
		} else {
			System.out.println("Problema no cadastro da categoria!");
		}
		// Cadastra um objeto do tipo Fabricante
		Fabricante fabr1 = new Fabricante();
		fabr1.setIdCode(rd.nextInt(1000) + 1);
		fabr1.setDescription("Indústria Automobilística do Brasil");
		if (fabr1.save() == 1) {
			System.out.println("Fabricante: " + fabr1.getDescription()
					+ " cadastrado com successo!");
		} else {
			System.out.println("Problema no cadastro do fabricante!");
		}
		// Cadastra um objeto do tipo Marca
		Marca marca1 = new Marca();
		marca1.setIdCode(rd.nextInt(1000) + 1);
		marca1.setDescription("Chevrolet");
		if (marca1.save() == 1) {
			System.out.println("Marca: " + marca1.getDescription() + " cadastrada com successo!");
		} else {
			System.out.println("Problema no cadastro da marca!");
		}
		
		// Cadastra um objeto do tipo Modelo
		Modelo mol1 = new Modelo();
		mol1.setIdCode(rd.nextInt(1000) + 1);
		mol1.setDescription("Vectra");
		if (mol1.save() == 1) {
			System.out.println("Modelo: " + mol1.getDescription() + 
					" cadastrado com successo!");
		} else {
			System.out.println("Problema no cadastro do modelo!");
		}
		// Cadastra um objeto do tipo Carro
		Carro car1 = new Carro();
		car1.setIdCode(rd.nextInt(1000)+1);
		car1.setDescription("Vectra LTZ 2.0");
		List<QualifiableObject> types = new ArrayList<QualifiableObject>();
		types.add(cat1);
		types.add(fabr1);
		types.add(marca1);
		types.add(mol1);
		car1.setTypes(types);
		car1.setPlaca("HJI 2000");
		car1.setAno(2012);
		car1.setStatus(Status.Unavailable);
		if (car1.save() == 1) {
			System.out.println("Carro: " + car1.getDescription() + 
					" cadastrado com successo!");
		} else {
			System.out.println("Problema no cadastro do carro!");
		}
		// Cadastra um objeto do tipo Cliente
		Cliente cli = new Cliente();
		cli.setIdCode(rd.nextInt(1000)+1);
		cli.setDescription("Luiz Antônio da Silva");
		cli.setEndereco("Rua Anhanguera, numero 1848");
		cli.setCidade("Campo Grande");
		cli.setEstado("Mato Grosso do Sul");
		cli.setFone("9946-2784");
		cli.setEmail("luis_antonio@email.com");
		cli.setDocId("1774814");
		cli.setDataNasc("01/12/1993");
		cli.setNomePai("João Pedro da Silva");
		cli.setNomeMae("Maria Fernanda da Silva");
		
		if (cli.save() == 1) {
			System.out.println("Cliente: " + cli.getDescription() + " Email: " 
					+ cli.getEmail() +
					" cadastrado com successo!");
		} else {
			System.out.println("Problema no cadastro do cliente!");
		} 
		
		// Cadastra um objeto do tipo LocacaoCarro
		LocacaoCarro loc = new LocacaoCarro();
		loc.setResource(car1);
		loc.setDestinationParty(cli);
		loc.setNumber(rd.nextInt(1000)+1);
		loc.setObservation("Locacao de carro nº: " + loc.getNumber() + 
				" feita sem desconto");
		
		//Date dtbegin = java.sql.Date.valueOf("2012-03-19");
		//loc.setBeginDate(dtbegin);
		
		loc.setBeginDate(java.sql.Date.valueOf("2012-03-19"));
		loc.setFinishingDate(java.sql.Date.valueOf("2012-03-24"));
		loc.setKmRetirada(16063);
		loc.setServicoesAdicionais("Ar-condiciona, Cambio Automatico, Vidro Eletrico");
		loc.setValorDiaria((float) 7.80);
		loc.setHoraInicial("11:22:36");
		loc.setHoraFinal("11:00:00");
		loc.setStatus(TransactionStatus.option1);
		loc.setTotalDiscount(00);
		if (loc.save() == 1) {
			System.out.println("Locacao de carro nº: " + loc.getNumber() + 
					" cadastrada com sucesso!");
		} else {
			System.out.println("Problema na locacao do carro!");
		}
	}

}
