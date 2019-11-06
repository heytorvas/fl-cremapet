package br.unitins.model;

public enum Estados {

    ACRE("Acre", "AC"),
    ALAGOAS("Alagoas", "AL"),
    AMAPA("Amap�", "AP"),
    AMAZONAS("Amazonas", "AM"),
    BAHIA("Bahia", "BA"),
    CEARA("Cear�", "CE"),
    DISTRITOFEDERAL("Distrito Federal", "DF"),
    ESPIRITOSANTO("Esp�rito Santo", "ES"),
    GOIAS("Goi�s", "GO"),
    MARANHAO("Maranh�o", "MA"),
    MATOGROSSO("Mato Grosso", "MT"),
    MATOGROSSODOSUL("Mato Grosso do Sul", "MS"),
    MINASGERAIS("Minas Gerais", "MG"),
    PARA("Par�", "PA"),
    PARAIBA("Para�ba", "PB"),
    PARANA("Paran�", "PR"),
    PERNAMBUCO("Pernambuco", "PE"),
    PIAUI("Piau�", "PI"),
    RIODEJANEIRO("Rio de Janeiro", "RJ"),
    RIOGRANDEDONORTE("Rio Grande do Norte", "RN"),
    RIOGRANDEDOSUL("Rio Grande do Sul", "RS"),
    RONDONIA("Rond�nia", "RO"),
    RORAIMA("Roraima", "RR"),
    SANTACATARINA("Santa Catarina", "SC"),
    SAOPAULO("S�o Paulo", "SP"),
    SERGIPE("Sergipe", "SE"),
    TOCANTINS("Tocantins", "TO");
	
    private String nome;
    private String sigla;
    
    private Estados(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;       
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
