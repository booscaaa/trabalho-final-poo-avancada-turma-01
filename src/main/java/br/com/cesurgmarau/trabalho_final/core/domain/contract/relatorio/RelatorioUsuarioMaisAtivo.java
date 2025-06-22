package br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.infra.reports.RelatorioMediaPorProdutoString;
import br.com.cesurgmarau.trabalho_final.infra.reports.RelatorioUsuarioMaisAtivoString;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RelatorioUsuarioMaisAtivoString.class, name = "RelatorioUsuarioMaisAtivoString"),
})
public interface RelatorioUsuarioMaisAtivo {
    public String relatorioUsuarioMaisAtivo(List<Usuario> usuarioList);
}
