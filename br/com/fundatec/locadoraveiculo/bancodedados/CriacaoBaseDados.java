package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class CriacaoBaseDados {

	public static void inicializarBase() {
		cadastrarVeiculos();
		cadastrarClientes();
	}

	private static void cadastrarVeiculos() {
		DadosVeiculos cadastro = DadosVeiculos.criar();

		cadastro.adicionar(new Veiculo("ABC0001", "VW", "Gol", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0002", "Fiat", "Palio", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0003", "Chevrolet", "Onyx", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0004", "Toyota", "Etios", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0005", "Renault", "Sandero", TipoVeiculo.HATCH, 0f, 5.0, 50.0));
		cadastro.adicionar(new Veiculo("ABC0005", "Peugeot", "207", TipoVeiculo.HATCH, 0f, 5.0, 50.0));

		cadastro.adicionar(new Veiculo("ABC0006", "VW", "Virtus", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0007", "Fiat", "Siena", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0008", "Chevrolet", "Cobalt", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));
		cadastro.adicionar(new Veiculo("ABC0009", "Toyota", "Corolla", TipoVeiculo.SEDAN, 0f, 8.0, 65.0));
		cadastro.adicionar(new Veiculo("ABC0010", "Renault", "Logan", TipoVeiculo.SEDAN, 0f, 7.0, 60.0));

		cadastro.adicionar(new Veiculo("ABC0011", "Jeep", "Compass", TipoVeiculo.SUV, 0f, 11.0, 100.0));
		cadastro.adicionar(new Veiculo("ABC0012", "VW", "T-Cross", TipoVeiculo.SUV, 0f, 11.0, 95.0));
		cadastro.adicionar(new Veiculo("ABC0013", "Hyundai", "Creta", TipoVeiculo.SUV, 0f, 11.0, 95.0));
		cadastro.adicionar(new Veiculo("ABC0014", "Honda", "HRV", TipoVeiculo.SUV, 0f, 11.0, 95.0));

		cadastro.adicionar(new Veiculo("ABC0015", "Ford", "Ranger", TipoVeiculo.PICKUP, 0f, 12.5, 110.0));
		cadastro.adicionar(new Veiculo("ABC0016", "VW", "Amarok", TipoVeiculo.PICKUP, 0f, 12.0, 115.0));
	}

	private static void cadastrarClientes() {
		DadosClientes cadastroCliente = DadosClientes.criar();

		cadastroCliente.adicionar(
				new Cliente("Douglas", TipoPessoa.FISICA, TipoDocumento.CPF, Long.parseLong("12345678910"), null,
						new Endereco("Rua Salamaleico", 123, "Casa", "São João", "Porto Alegre", "RS", 12345678)));

		cadastroCliente.adicionar(new Cliente("Lucas", TipoPessoa.JURIDICA, TipoDocumento.CNPJ,
				Long.parseLong("12345678000112"), "Lucas's Enterprise",
				new Endereco("Rua Carlos Gomes", 321, "Prédio", "Auxiliadora", "Porto Alegre", "RS", 87654321)));
	}
}