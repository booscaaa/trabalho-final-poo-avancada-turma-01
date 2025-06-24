package br.com.cesurgmarau.trabalho_final.infra.repository.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosProduto.RelatoriosProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RelatoriosProdutoRepositoryImpl implements RelatoriosProdutoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<MediaSentimentoProdutoOutput> mediaDeSentimentoPorProduto() {

        var query = """
                
                SELECT
                
                    p.nome AS produto,
                    CASE ROUND(AVG(
                        CASE sentimento
                            WHEN 'muito positivo' THEN 5
                            WHEN 'positivo' THEN 4
                            WHEN 'neutro' THEN 3
                            WHEN 'negativo' THEN 2
                            WHEN 'muito negativo' THEN 1
                            ELSE NULL
                        END
                    ), 0)
                    
                        WHEN 5 THEN 'muito positivo'
                        WHEN 4 THEN 'positivo'
                        WHEN 3 THEN 'neutro'
                        WHEN 2 THEN 'negativo'
                        WHEN 1 THEN 'muito negativo'
                        ELSE 'indefinido'
                    END AS sentimento_medio
                    
                FROM comentarios c
                INNER JOIN produtos p ON p.id = c.produto_id
                GROUP BY p.id;
                
                """;


        return entityManager.createNativeQuery(query, "SentimentoMedioPorProdutoMapping")
                .getResultList();
    }
}
