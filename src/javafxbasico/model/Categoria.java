package javafxbasico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	private Integer id;

	private String nome;

	@Override
	public String toString() {
		return getNome();
	}

}
