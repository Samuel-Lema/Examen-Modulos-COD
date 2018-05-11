package com.empaquetamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.empaquetamiento.Button"
)
@ActionRegistration(
        iconBase = "icono.png",
        displayName = "#CTL_Button"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0)
    ,
  @ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_Button=Compilar")
public final class Button implements ActionListener {
    
     /**
     * @param outdir EL directorio donde guardamos el archivo
     * @param outfile Nombre del archivo que vamos a crear
     * @param srcdir Directorio del proyecto
     * @param srcfiles Archivo .jar
     * @param appclass Clase principal de la aplicacion
     * @param nametitle Nombre del archivo
     */
    
    @Override public void actionPerformed(ActionEvent e) {
        
        String outdir = JOptionPane.showInputDialog("Directorio de salida");
        String outfile = JOptionPane.showInputDialog("Nombre del archivo");
        String srcdir = JOptionPane.showInputDialog("Directorio de la app");
        String srcfiles = JOptionPane.showInputDialog("Archivo .jar");
        String mainclass = JOptionPane.showInputDialog("Clase Principal");
        String titulo = JOptionPane.showInputDialog("Nombre de la app");

        // Meto el comando en un String
        
        String cmd = "javapackager -deploy -native deb "
                    + " -outdir " + outdir + " -outfile " + outfile
                    + " -srcdir " + srcdir + " -srcfiles " + srcfiles
                    + " -appclass " + mainclass + " -name " + titulo
                    + " -title " + titulo;
        
        try {
            System.out.println(cmd); // En esta linea debugeo el comando
            
            Process process = Runtime.getRuntime().exec(cmd); 
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            JOptionPane.showInputDialog("Comando ejecutado");
            
        } catch (IOException ex) {
            System.out.println (ex);
        }
        
    }
}
