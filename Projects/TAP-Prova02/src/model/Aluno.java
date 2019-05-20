package model;

import java.io.FileReader;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {
	
	public static String configInstituicao;
	public static String configMediaA;
	public static String configMediaR;

	public static void lerConfig() {
		Properties properties = new Properties();
		try {
			FileReader fis = new FileReader("conf.properties");
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		configInstituicao = properties.getProperty("nome");
		configMediaA = properties.getProperty("mediaA");
		configMediaR = properties.getProperty("mediaR");
	}
	
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty disciplina = new SimpleStringProperty("");
	private StringProperty situacao = new SimpleStringProperty("");
	private DoubleProperty nota1 = new SimpleDoubleProperty(0);
	private DoubleProperty nota2 = new SimpleDoubleProperty(0);
	private DoubleProperty nota3 = new SimpleDoubleProperty(0);
	private DoubleProperty media = new SimpleDoubleProperty(0);
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty disciplinaProperty() {
		return this.disciplina;
	}
	
	public String getDisciplina() {
		return this.disciplinaProperty().get();
	}
	
	public void setDisciplina(final String disciplina) {
		this.disciplinaProperty().set(disciplina);
	}
	
	public StringProperty situacaoProperty() {
		situacao = new SimpleStringProperty(getSituacao());
		return this.situacao;
	}

	public String getSituacao() {
		lerConfig();
		String tmpSituacao = "";
		if (this.getMedia() >= Double.parseDouble(configMediaA)) {
			tmpSituacao = "Aprovado";
		} else if (this.getMedia() >= Double.parseDouble(configMediaR)) {
			tmpSituacao = "Recuperação";
		} else if (this.getMedia() < Double.parseDouble(configMediaR)) {
			tmpSituacao = "Reprovado";
		}
		return tmpSituacao;
	}
	
	public void setSituacao(final String situacao) {
		this.situacaoProperty().set(situacao);
	}
	
	public DoubleProperty nota1Property() {
		return this.nota1;
	}
	
	public double getNota1() {
		return this.nota1Property().get();
	}
	
	public void setNota1(final double nota1) {
		this.nota1Property().set(nota1);
	}
	
	public DoubleProperty nota2Property() {
		return this.nota2;
	}
	
	public double getNota2() {
		return this.nota2Property().get();
	}
	
	public void setNota2(final double nota2) {
		this.nota2Property().set(nota2);
	}
	
	public DoubleProperty nota3Property() {
		return this.nota3;
	}
	
	public double getNota3() {
		return this.nota3Property().get();
	}
	
	public void setNota3(final double nota3) {
		this.nota3Property().set(nota3);
	}
	
	public DoubleProperty mediaProperty() {
		media = new SimpleDoubleProperty(getMedia());
		return this.media;
	}
	
	public double getMedia() {
		return (this.getNota1() + this.getNota2() + this.getNota3()) / 3;
	}
	
	public void setMedia(final double media) {
		this.mediaProperty().set(media);
	}
	
}
