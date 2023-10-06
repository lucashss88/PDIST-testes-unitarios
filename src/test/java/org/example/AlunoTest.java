package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void config() {
        aluno = new Aluno(1, "Lucas", 22, "11122233345", "112233");
    }

    @Test
    public void NaoDeveAlterarMatriculaSemTer11Digitos(){
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("1112223"));
    }

    @Test
    public void NaoDeveAlterarMatriculaSeConterCaracterEspecial(){
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("111222333!@"));
    }


}