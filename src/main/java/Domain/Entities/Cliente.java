package Domain.Entities;

import Domain.ValueObjects.CpfVO;
import Domain.ValueObjects.EmailVO;
import Domain.ValueObjects.NomeVO;

public class Cliente  {
    private CpfVO cpf;
    private NomeVO nome;
    private EmailVO email;

    public CpfVO getCpf() {
        return cpf;
    }

    public NomeVO getNome() {
        return nome;
    }

    public EmailVO getEmail() {
        return email;
    }
}