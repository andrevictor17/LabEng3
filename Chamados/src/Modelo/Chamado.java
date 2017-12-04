package Modelo;


import java.util.ArrayList;

public class Chamado implements Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String nome;
	private String tipo;
	private String Descricao;
	private String status;
	private String Atendente;
	
	public Chamado(String nome, String tipo,String descricao,String status,String atendente) {
		setNome(nome);
		setTipo(tipo);
		setDescricao(descricao);
		setStatus(status);
		setAtendente(atendente);
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
		this.notifyObservers();
	}



	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
		this.notifyObservers();
	}
	
	
	public String getDescricao() {
		return Descricao;
	}

	
	public void setDescricao(String descrição) {
		Descricao = descrição;
		this.notifyObservers();
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
		this.notifyObservers();
	}


	public String getAtendente() {
		return Atendente;
	}



	public void setAtendente(String atendente) {
		Atendente = atendente;
		this.notifyObservers();
	}

	public Chamado clone(){
		return new Chamado(getNome(),getTipo(), getDescricao(), getStatus(), getAtendente());
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		 for (Observer ob : observers) {
	            System.out.println("Notificando observers!");
	              ob.update(this.nome);
	              ob.update(this.Atendente);
	              ob.update(this.Descricao);
	              ob.update(this.status);
	              ob.update(this.tipo);
	            }


	
	}

}
