package main;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {


	static class Curso {
    private String nome;
    private Professor professor;
    private List<Turma> turmas;

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.turmas = new ArrayList<>();
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    // Métodos getters e setters
}

	static class Turma {
    private int id;
    private Sala sala;
    private List<Aluno> alunos;
    private DayOfWeek diaDaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    public Turma(int id, Sala sala, DayOfWeek diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
        this.id = id;
        this.sala = sala;
        this.alunos = new ArrayList<>();
        this.diaDaSemana = diaDaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    // Métodos getters e setters
}

	static class Sala {
    private int numero;
    private int capacidade;
    private boolean disponivel;

    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.disponivel = true;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Métodos getters e setters
}

	static class Professor {
    private String nome;
    private List<Turma> turmas;

    public Professor(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    // Métodos getters e setters
}

	static class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    // Métodos getters e setters
}

	public static class SistemaCursos {
    private List<Curso> cursos;
    private List<Professor> professores;
    private List<Sala> salas;
    private List<Turma> turmas;
    private List<Aluno> alunos;

    public SistemaCursos() {
        this.cursos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void cadastrarCurso(String nome, Professor professor) {
        Curso curso = new Curso(nome, professor);
        cursos.add(curso);
    }

    public void cadastrarProfessor(String nome) {
        Professor professor = new Professor(nome);
        professores.add(professor);
    }

    public void cadastrarSala(int numero, int capacidade) {
        Sala sala = new Sala(numero, capacidade);
        salas.add(sala);
    }

    public void cadastrarTurma(int id, Curso curso, Sala sala, DayOfWeek diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
        Turma turma = new Turma(id, sala, diaDaSemana, horarioInicio, horarioFim);
        turmas.add(turma);
        curso.getTurmas().add(turma);
        sala.setDisponivel(false);
    }

    public void cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
    }

    // Outros métodos de consulta e manipulação dos dados

    public static void main(String[] args) {
        SistemaCursos sistema = new SistemaCursos();

        // Cadastrar professores
        sistema.cadastrarProfessor("João");
        sistema.cadastrarProfessor("Maria");

        // Cadastrar salas
        sistema.cadastrarSala(1, 30);
        sistema.cadastrarSala(2, 25);

        // Cadastrar cursos
        Professor professorJoao = sistema.getProfessores().get(0);
        Professor professorMaria = sistema.getProfessores().get(1);

        sistema.cadastrarCurso("Curso de Eletricidade básica", professorJoao);
        sistema.cadastrarCurso("Curso de mecânica de automóveis", professorJoao);
        sistema.cadastrarCurso("Curso de cabelereiro/estética", professorMaria);

        // Cadastrar turmas
        Curso cursoEletricidade = sistema.getCursos().get(0);
        Curso cursoMecanica = sistema.getCursos().get(1);
        Curso cursoCabelereiro = sistema.getCursos().get(2);

        Sala sala1 = sistema.getSalas().get(0);
        Sala sala2 = sistema.getSalas().get(1);

        sistema.cadastrarTurma(1, cursoEletricidade, sala1, DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(23, 0));
        sistema.cadastrarTurma(2, cursoMecanica, sala2, DayOfWeek.TUESDAY, LocalTime.of(19, 0), LocalTime.of(23, 0));
        sistema.cadastrarTurma(3, cursoCabelereiro, sala1, DayOfWeek.WEDNESDAY, LocalTime.of(19, 0), LocalTime.of(23, 0));

        // Cadastrar alunos
        sistema.cadastrarAluno("Joana");
        sistema.cadastrarAluno("Pedro");
        sistema.cadastrarAluno("Ana");
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    } 
}
	
}
