package demo.domain.enums;

public enum TipoSexo {
	MACHO(1, "Macho"),
	FÊMEA(2, "Fêmea");

	private int codigo;
	private String descricao;

	private TipoSexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoSexo toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TipoSexo tipoSexo : TipoSexo.values()) {
			if (codigo.equals(tipoSexo.getCodigo())) {
				return tipoSexo;
			}
		}
		throw new IllegalArgumentException("Código inválido: "+ codigo);
	}
}
