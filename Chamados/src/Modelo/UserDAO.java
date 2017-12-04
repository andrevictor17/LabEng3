package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class UserDAO {

	public UserDAO() {
	}

	/**
	 * @param u
	 * @throws IOException 
	 */
	public void addUser(User u ) throws UsuarioJaExiste, IOException{
		File objectData = new File("database/users/"+ u.getNome() +".txt");
		if(objectData.exists()){
			UsuarioJaExiste e = new UsuarioJaExiste(u.getNome());
			throw e;
		}
		FileWriter fw = new FileWriter(objectData.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(u.getNome() + System.lineSeparator());
		bw.write(u.getSenha() + System.lineSeparator());
		bw.write(String.valueOf(u.getTipo().getValue()));
		bw.close();
	}

	/**
	 * @param u
	 */
	public boolean removeUser(User u ) {
		File objectData = new File("database/users/"+ u.getNome() +".txt");
		if(!objectData.delete()){
			return false;
		}
		return true;
	}

	/**
	 * @param old  
	 * @param new
	 */
	public boolean updateUser(User old , User u  ) {
		File objectData = new File("database/users/"+ old.getNome() +".txt");
		if(!objectData.exists()){
			return false;
		}
		try{
			objectData.delete();
			objectData = new File("database/users/"+ u.getNome() +".txt");
			objectData.createNewFile();
			return true;
		}
		catch(IOException e){
			e.printStackTrace();
			objectData = new File("database/users/"+ old.getNome() +".txt");
			try {
				objectData.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * @param u  
	 * @return
	 */
	public ArrayList<User> searchUser(User u ) {
		File objectData = new File("database/users/");
		File[] allObjects = objectData.listFiles();
		ArrayList<User> result = new ArrayList<User>();
		for (int i = 0; i < allObjects.length; i++) {
			if(allObjects[i].getName().contains(u.getNome())){
				result.add(readUser(allObjects[i].getName()));
			}
		}
		return result;
	}
	
	public User readUser(String fileNome){
		String Nome = null, senha = null;
		int TipoInt = 0;
		UserClass Tipo = null;
		BufferedReader br;
		try{
			FileReader objectData = new FileReader("database/users/"+ fileNome);
			br = new BufferedReader(objectData);
			Nome = br.readLine();
			senha = br.readLine();
			try {
				TipoInt = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				TipoInt = 0;
			}
			br.close();
		}
		catch(FileNotFoundException e1){
			e1.printStackTrace();
			return null;
		}
		catch(IOException e2){
			e2.printStackTrace();
			return null;
		}
		UserClass[] allTipos = UserClass.values();
		for (int i = 0; i < allTipos.length; i++) {
			if(allTipos[i].getValue()==TipoInt)Tipo = allTipos[i];
		}
		return new User(Nome, senha, Tipo);
	}
}