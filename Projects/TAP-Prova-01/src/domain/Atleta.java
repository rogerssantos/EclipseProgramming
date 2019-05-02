package domain;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Atleta extends Task<Void> {
	
	private int qt;
	private long tempo;
	private ProgressBar barra;
	

	public Atleta(int qt, long tempo, ProgressBar barra) {
		this.qt = qt;
		this.tempo = tempo;
		this.barra = barra;
		this.barra.setProgress(0);
		
	}
	
	public void inicia() {
		double incremento = 1.0/qt;
		for (int i = 0; i < qt; i++) {
			try {
				Thread.sleep(tempo);
				barra.setProgress(barra.getProgress()+incremento);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public ProgressBar getBarra() {
		return barra;
	}

	public void setBarra(ProgressBar barra) {
		this.barra = barra;
	}

	public int getQuantidade() {
		return qt;
	}

	public void setQuantidade(int quantidade) {
		this.qt = quantidade;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	protected Void call() throws Exception {
		double incremento = 1.0/qt;
		for (int i = 0; i < qt; i++) {
			try {
				Thread.sleep(tempo);
				Platform.runLater(() -> {
					barra.setProgress(barra.getProgress()+incremento);					
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	return null;
	}

}
