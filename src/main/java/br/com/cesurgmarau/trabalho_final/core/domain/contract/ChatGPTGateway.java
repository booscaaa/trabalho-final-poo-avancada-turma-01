package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import java.io.IOException;

public interface ChatGPTGateway {
    public String identificarSentimento (String comentario) throws IOException;
}
