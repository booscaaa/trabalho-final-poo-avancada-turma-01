package br.com.cesurgmarau.trabalho_final.repository;

import br.com.cesurgmarau.trabalho_final.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByProdutoId(Long produtoId);

    List<Comentario> findByUsuarioId(Long usuarioId);

    List<Comentario> findBySentimentoIgnoreCase(String sentimento);

    // Contagem total de comentários agrupados por sentimento
    @Query("SELECT c.sentimento AS sentimento, COUNT(c) AS total FROM Comentario c GROUP BY c.sentimento")
    List<Object[]> contarComentariosPorSentimento();

    // Média do valor do sentimento por produto
    @Query("SELECT c.produto.id, c.produto.nome, AVG(CAST(" +
            "CASE c.sentimento " +
            "WHEN 'Muito positivo' THEN 5 " +
            "WHEN 'Positivo' THEN 4 " +
            "WHEN 'Neutro' THEN 3 " +
            "WHEN 'Negativo' THEN 2 " +
            "WHEN 'Muito negativo' THEN 1 " +
            "ELSE 3 END AS double)) AS media " +
            "FROM Comentario c GROUP BY c.produto.id, c.produto.nome")
    List<Object[]> mediaSentimentoPorProduto();

    // Ranking de usuários com mais comentários
    @Query("SELECT c.usuario.id, c.usuario.nome, COUNT(c) AS total " +
            "FROM Comentario c GROUP BY c.usuario.id, c.usuario.nome ORDER BY total DESC")
    List<Object[]> rankingUsuariosMaisAtivos();
}
