/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Hovercraft.java
 *
 * Created on Mar 20, 2012, 6:37:38 PM
 */
/**
 *
 * @author nbknlhw
 */

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.rtf.RtfWriter2;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.*;

public class Hovercraft extends javax.swing.JFrame implements HotkeyListener{
    
    private int PRINTSCREEN=44, DELETE=46;
    private int bpress_count=0,keypress_count=0,rtfimage_count=0,filecheck_exists=0,close;
    private String sfilepath,sfilename,temp_jpg_filename,temp_jpg_filename_rtf,browse_path;
    //private Document doc = new Document();
    private Robot screenRobot;
    BufferedImage bf;
    Image i1;
    Rectangle screensize;
    File temp_jpg;
    
    
    /** Creates new form Hovercraft */
    public Hovercraft() {
        initComponents();
        ImageIcon icon = new ImageIcon("hovercraft_icon.jpg");
        this.setIconImage(icon.getImage());
        Hovercraft.this.initJIntellitype();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startstop_button = new javax.swing.JButton();
        file_path = new javax.swing.JTextField();
        file_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        browse_button = new javax.swing.JButton();
        version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HOVERCRAFT");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        startstop_button.setFont(new java.awt.Font("Tahoma", 0, 48));
        startstop_button.setText("START");
        startstop_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startstop_buttonActionPerformed(evt);
            }
        });

        file_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_pathActionPerformed(evt);
            }
        });

        file_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_nameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 48));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOVERCRAFT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("File Path:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("File Name:");

        browse_button.setText("Browse");
        browse_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse_buttonActionPerformed(evt);
            }
        });

        version.setText("v1.3");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(163, 163, 163)
                .add(startstop_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 141, Short.MAX_VALUE)
                .add(version))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(70, 70, 70))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(file_name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(file_path, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(browse_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(file_path, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(browse_button))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 35, Short.MAX_VALUE)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(file_name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(37, 37, 37)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(startstop_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(version)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startstop_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startstop_buttonActionPerformed
        // TODO add your handling code here:
        if (file_path.getText().length()==0)
        {
            JOptionPane.showMessageDialog(startstop_button, "The File Path field is empty. \n Please fill it!", "File Path Empty", JOptionPane.ERROR_MESSAGE);
            return;
        }
        bpress_count++;
        if(bpress_count%2==1) {
            sfilepath = file_path.getText();
            sfilename=file_name.getText()+".rtf";
            //System.out.println("Path is "+sfilepath);
            //System.out.println("Name is "+sfilename);
            startstop_button.setText("STOP");
            JIntellitype.getInstance().registerHotKey(PRINTSCREEN,0, 44);
            JIntellitype.getInstance().registerHotKey(DELETE, JIntellitype.MOD_CONTROL, 46);
            File filecheck = new File(sfilepath+sfilename);
                if(filecheck.exists())
                {
                    filecheck_exists++;
                    JOptionPane.showMessageDialog(null,"A file with this name already exists! \n It will be renamed to "+filecheck_exists+"_"+sfilename);
                    filecheck.renameTo(new File(sfilepath+filecheck_exists+"_"+sfilename));                    
                }
            //System.out.println("Registered");
        }
        
        if(bpress_count%2==0) {
            Document doc = new Document();
            startstop_button.setText("START");
            JIntellitype.getInstance().unregisterHotKey(PRINTSCREEN);
            JIntellitype.getInstance().unregisterHotKey(DELETE);
            //System.out.println("UnRegistered");
            try {
                RtfWriter2 rtfw = RtfWriter2.getInstance(doc, new FileOutputStream(sfilepath+sfilename));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            doc.open();
            //System.out.println("OPENED");
            for(rtfimage_count=0;rtfimage_count<Global.Global_Int;rtfimage_count++) {
                temp_jpg_filename_rtf = sfilename+rtfimage_count+".jpg";
                
                try {
                    i1 = Image.getInstance(temp_jpg_filename_rtf);
                } catch (BadElementException ex) {
                    Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
                }
                i1.scalePercent(40);
                try {
                    doc.add(i1);
                } catch (DocumentException ex) {
                    Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
                }
                File temp_jpg_delete = new File(temp_jpg_filename_rtf);
                if(temp_jpg_delete.exists())
                    temp_jpg_delete.delete();
            }
            doc.close();
            keypress_count=0;
            
        }
}//GEN-LAST:event_startstop_buttonActionPerformed

    private void file_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_file_pathActionPerformed

    private void file_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_file_nameActionPerformed

    private void browse_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browse_buttonActionPerformed
        // TODO add your handling code here:
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        file_chooser.showDialog(file_chooser, "Select Directory");
        File directory = file_chooser.getSelectedFile();
        browse_path = directory.getAbsolutePath();
        //System.out.println(browse_path);
        if (browse_path.charAt(browse_path.length()-4)=='.')
        {
            JOptionPane.showMessageDialog(file_chooser, "You have chosen a file instead of a directory. \n Please choose a directory.", "Please choose a directory", JOptionPane.ERROR_MESSAGE);
            return;
        }
        browse_path=browse_path.concat("\\");
        file_path.setText(browse_path);
    }//GEN-LAST:event_browse_buttonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(startstop_button.getText().equals("STOP"))
        {
            close = JOptionPane.showConfirmDialog(startstop_button, "You have not clicked the STOP button. Exiting will NOT save the screenshots. \n Are you sure you want to exit?", "Are you sure you want to exit?", JOptionPane.YES_NO_OPTION);
            if (close==0)
                System.exit(0);
            if (close==1)
                return;
        }
        else
        {
            close = JOptionPane.showConfirmDialog(startstop_button, "Are you sure you want to exit?", "Are you sure you want to exit?", JOptionPane.YES_NO_OPTION);
            if (close==0)
                System.exit(0);
            if (close==1)
                return;
        }
    }//GEN-LAST:event_formWindowClosing
public void initJIntellitype()
    {
        JIntellitype.getInstance().addHotKeyListener(this);
    }
    
    public void onHotKey(int key_identifier){
        
        if(key_identifier==44)
        {
            
            //System.out.println("PRINT SCREEN pressed");
            screensize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        try {
                screenRobot = new Robot();
            } catch (AWTException ex) {
                Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
            }
            bf = screenRobot.createScreenCapture(screensize);
            temp_jpg_filename = sfilename+keypress_count+".jpg";
            //System.out.println("Temp JPG Filename = "+temp_jpg_filename);
            temp_jpg = new File(temp_jpg_filename);
            try {
                ImageIO.write(bf, "jpg", temp_jpg);
            } catch (IOException ex) {
                Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
            }
            keypress_count++;
            Global.Global_Int = keypress_count;
            
        }
        if (key_identifier==46)
        {
            //System.out.println("DELETE pressed.");
            //Logger.getLogger(Hovercraft.class.getName()).info("Delete Pressed for "+temp_jpg_filename);
            keypress_count--;
            Global.Global_Int = keypress_count;            
        }
            
               
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        FileHandler logfile_handler = new FileHandler("log.txt",true);
        logfile_handler.setFormatter(new SimpleFormatter());
        Logger.getLogger(Hovercraft.class.getName()).addHandler(logfile_handler);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Hovercraft.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            
            public void run() {
                new Hovercraft().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse_button;
    private javax.swing.JTextField file_name;
    private javax.swing.JTextField file_path;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton startstop_button;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}

class Global {
public static int Global_Int;
}