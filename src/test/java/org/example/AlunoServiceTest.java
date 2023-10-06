package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {
    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    private Aluno aluno;

    @BeforeEach
    public void config() {
        aluno = new Aluno(1, "Lucas", 22, "11122233345", "112233");
    }

    @Test
    public void NaoDeveInserirAlunoComMatriculaJahExistente(){
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("11122233345");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));

    }

    @Test
    public void NaoDeveInserirAlunoComCPFJahExistente(){
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("112233");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));
    }

    @Test void NaoDeveInserirAlunoComIdadeMenosA18Anos(){
        Aluno alunoMenor18 = new Aluno(2, "Alfredo", 15, "12345678912", "0123");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunoMenor18));
    }
}