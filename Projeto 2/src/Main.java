package dio_project2;

import java.time.LocalDate;

import dio_project2.dominio.Bootcamp;
import dio_project2.dominio.Curso;
import dio_project2.dominio.Dev;
import dio_project2.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso java");
		curso1.setDescricao("descricao curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso js");
		curso2.setDescricao("descricao curso js");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descricao mentoria java");
		mentoria.setData(LocalDate.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devCamila = new Dev();
		devCamila.setNome("Camila");
		devCamila.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Camila" + devCamila.getConteudosInscritos());
		devCamila.progredir();
		devCamila.progredir();
		System.out.println("Conteudos Inscritos Camila" + devCamila.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Camila" + devCamila.getConteudosConcluidos());
		System.out.println("XP:" + devCamila.calcularTotalXP());
		
		System.out.println();
		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos João" + devJoao.getConteudosInscritos());
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		System.out.println("Conteudos Inscritos João" + devJoao.getConteudosInscritos());
		System.out.println("Conteudos Concluidos João" + devJoao.getConteudosConcluidos());
		System.out.println("XP:" + devJoao.calcularTotalXP());

//		System.out.println(curso1);
//		System.out.println(curso2);
//		System.out.println(mentoria);
	}
}
