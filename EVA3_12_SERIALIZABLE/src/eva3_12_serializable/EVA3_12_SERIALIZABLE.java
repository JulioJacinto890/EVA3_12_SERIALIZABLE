/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_12_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class EVA3_12_SERIALIZABLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona perso1 = new Persona("Julian", "Jacinto", 18);
  try {
     Persona resu = leerObjetos(); 
        System.out.println(resu.getNombre());
        System.out.println(resu.getApellido());
        System.out.println(resu.getEdad());
     } catch (IOException ex){
      Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);    
     } catch(ClassNotFoundException ex){
        Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);  
     }
        
    }
    
   public static void guardarObjetos(Persona perso) throws FileNotFoundException, IOException{
     FileOutputStream abrirArch = new FileOutputStream("C:\\archivos pm\\personas.per");
      ObjectOutputStream output = new ObjectOutputStream(abrirArch);
      
      output.writeObject(perso);
      output.close();
   } 
    
    
   public static Persona leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException {
    Persona perso = null;
    
    FileInputStream abrirArch = new FileInputStream("C:\\archivos pm\\personas.per");
    ObjectInputStream input = new ObjectInputStream(abrirArch);
    
    //Casting
    //De objeto a Persona
    perso = (Persona)input.readObject();
    
    return perso;
   }  
    
    
    
    
    
    
}

//Solo permite guardar objetos en formato binario

class Persona implements Serializable{
  private String nombre;
  private String apellido;
  private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
     this.nombre = "gustabo";
     this.apellido = "garcia";
     this.edad = 35;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}

