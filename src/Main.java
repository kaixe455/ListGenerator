import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import model.Shape;
import utils.CsvUtils;
import utils.JavaUtils;

public class Main {
	
	private static JLabel statusLabel; 
	private static JProgressBar progressBar;
    private static JFrame frame;
    private static JButton btnSubmit;
    private static String[] fileNames = {"itemaccessory","itemarmor", "itemcash", "itemetc", "itemweapon","itemetc_socket"
    		,"accessoryevent", "cashevent", "etcevent", "itemmileage"  };
    
    
    public static void main(String[] args) {
		frame = new JFrame("List Generator Dekaron");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSubmit = new JButton("Generar lista");
        btnSubmit.setBounds(120, 80, 150, 23); 
        btnSubmit.setEnabled(true);
		progressBar = new JProgressBar(0, 1000);
		progressBar.setBounds(90, 40, 200, 30);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		statusLabel = new JLabel();
		statusLabel.setBounds(90, 5, 200, 30);
		statusLabel.setVisible(true);
	    frame.getContentPane().add(progressBar);
	    frame.getContentPane().add(statusLabel);
        btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
					progressBar.setVisible(true);
					statusLabel.setVisible(true);
					btnSubmit.setEnabled(false);
					statusLabel.setText("Comenzando a generar la lista de archivos");
					startThread();
				
			}
        });
        frame.getContentPane().add(btnSubmit);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);	
	}
    
    private static void startThread()  {
		SwingWorker<Object, Object> sw1 = new SwingWorker<Object, Object>()
        { 
            @Override
            protected String doInBackground() throws Exception  
            { 
            	
            	File file = new File("readfiles");
            	List<String> filePathsFinal = new ArrayList<String>();
            	statusLabel.setText("Buscando directorios");
            	String[] directories = file.list(new FilenameFilter() {
            	  public boolean accept(File current, String name) {
            	    return new File(current, name).isDirectory();
            	  }
            	});
            	progressBar.setValue(333);
            	statusLabel.setText("Buscando ficheros");
            	if(directories.length > 0) {
            		for (String directory : directories) {
            			statusLabel.setText("Buscando en: " + directory);
            			File folder = new File("readfiles/" + directory);
            			filePathsFinal.addAll(JavaUtils.getFilesFromFolder(folder));
            		}
            	}
            	progressBar.setValue(666);
            	statusLabel.setText("Generando list.csv");
            	CsvUtils.listToCsv(filePathsFinal);
            	progressBar.setValue(1000);
            	statusLabel.setText("Generado correctamente");
            	return "finish";
            } 
 
        }; 
          
        // executes the swingworker on worker thread 
        sw1.execute();  
    } 

}
