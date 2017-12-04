package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ChamadoDAO {
	
	/**
	 * @param p
	 * @return boolean
	 * @throws IOException 
	 */
	public void addChamado(Chamado p ) throws IOException {
		File objectData = new File("database/chamados/"+ p.getNome() +".txt");
		if(!objectData.createNewFile()){
			//If the file already exists, it is created a new file with a number in the end of the file nome
			String Nome = p.getNome();
			int i = 0;
			p.setNome(Nome + String.valueOf(i));
			objectData = new File("database/chamados/"+ p.getNome() +".txt");
			while(!objectData.createNewFile()){
				i = i + 1;
				p.setNome(Nome + String.valueOf(i));
				objectData = new File("database/chamados/"+ p.getNome() +".txt");
			}
		}
		FileWriter fw = new FileWriter(objectData.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(p.getNome() + System.lineSeparator());
		bw.write(p.getTipo() + System.lineSeparator());
		bw.write(p.getDescricao() + System.lineSeparator());
		bw.write(p.getStatus() + System.lineSeparator());
		bw.write(p.getAtendente() + System.lineSeparator());
		bw.close();
	}

	/**
	 * @param p
	 * @return boolean
	 */
	public boolean removeChamado(Chamado p) {
		File objectData = new File("database/chamados/"+ p.getNome() +".txt");
		if(!objectData.delete()){
			return false;
		}
		return true;
	}

	
	/**
	 * @param pold  
	 * @param pnew
	 * @return boolean
	 * @throws IOException 
	 */
	public boolean updateChamado(Chamado pold , Chamado pnew){
		File objectData = new File("database/chamados/"+ pold.getNome() +".txt");
		if(!objectData.exists()){
			return false;
		}
		try{
			objectData.delete();
			addChamado(pnew);
			return true;
		}
		catch(IOException e){
			e.printStackTrace();
			try {
				addChamado(pold);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * @param p  
	 * @return array
	 */
	public ArrayList<Chamado> PesquisaChamado(Chamado p ) {
		File objectData = new File("database/chamados/");
		File[] allObjects = objectData.listFiles();
		ArrayList<Chamado> result = new ArrayList<Chamado>();
		for (int i = 0; i < allObjects.length; i++) {
			if(allObjects[i].getName().contains(p.getNome())){
				result.add(LerChamado(allObjects[i].getName()));
			}
		}
		return result;
	}
	
	public Chamado LerChamado(String ArquivoNome){
		String nome;
		String tipo;
		String Descricao;
		String status;
		String Atendente;
		BufferedReader br;
		
		try{
			FileReader objectData = new FileReader("database/chamados/"+ ArquivoNome);
			br = new BufferedReader(objectData);
			nome = br.readLine();
			tipo = br.readLine();
			Descricao = br.readLine();
			status= br.readLine();
			Atendente = br.readLine();
			
			br.close();
		}
		catch(FileNotFoundException e1){
			return new Chamado("","","","","");
		}
		catch(IOException e2){
			return new Chamado("","","","","");
		}
		return new Chamado(nome, tipo,Descricao,status,Atendente);
	}

	
}
