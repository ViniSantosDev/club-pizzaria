package br.com.vinisantos.dev.clubpizzaria.domain.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.vinisantos.dev.clubpizzaria.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

@Data
@JacksonXmlRootElement(localName = "cozinha")
public class CozinhaXmlWrapper {
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull
	public List<Cozinha> cozinhas;

}
