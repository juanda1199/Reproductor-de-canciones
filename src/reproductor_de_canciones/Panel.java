
package reproductor_de_canciones;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Panel extends javax.swing.JFrame {

    ReproductorDiscos acc = new ReproductorDiscos();
    Date fecha;
    
    public Panel() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Images/icon.jpg")).getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonReproducir = new javax.swing.JButton();
        jButtonDetener = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jSliderSound = new javax.swing.JSlider();
        jButtonBusqueda = new javax.swing.JButton();
        jLabelSound = new javax.swing.JLabel();
        jPanelMostrar = new javax.swing.JPanel();
        jLabelDuracion = new javax.swing.JLabel();
        jLabelNomb = new javax.swing.JLabel();
        jScrollPanelList = new javax.swing.JScrollPane();
        jListCancion = new javax.swing.JList<>();
        jButtonAgregar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTituloD = new javax.swing.JLabel();
        jPanelDuracion = new javax.swing.JPanel();
        jLabelDuracionT = new javax.swing.JLabel();
        jPanelEdicion = new javax.swing.JPanel();
        jLabelEdicion = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuOpcion = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor de Canciones");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonReproducir.setBackground(new java.awt.Color(204, 204, 204));
        jButtonReproducir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButtonReproducir.setForeground(new java.awt.Color(0, 0, 102));
        jButtonReproducir.setText("Play");
        jButtonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReproducirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReproducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 90, 50));

        jButtonDetener.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDetener.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButtonDetener.setForeground(new java.awt.Color(0, 0, 102));
        jButtonDetener.setText("◘");
        jButtonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetenerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 90, 50));

        jButtonAnterior.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAnterior.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButtonAnterior.setForeground(new java.awt.Color(0, 0, 102));
        jButtonAnterior.setText("<<");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 90, 60));

        jButtonSiguiente.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSiguiente.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButtonSiguiente.setForeground(new java.awt.Color(0, 0, 102));
        jButtonSiguiente.setText(">>");
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 90, 60));

        jSliderSound.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderSound.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 3, true));
        jSliderSound.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSoundStateChanged(evt);
            }
        });
        getContentPane().add(jSliderSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 30, 270));

        jButtonBusqueda.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBusqueda.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButtonBusqueda.setForeground(new java.awt.Color(0, 0, 102));
        jButtonBusqueda.setText("+");
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 90, 40));

        jLabelSound.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSound.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabelSound.setForeground(new java.awt.Color(255, 255, 0));
        jLabelSound.setText("50%");
        getContentPane().add(jLabelSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 50, 20));

        jPanelMostrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 0), 2, true));
        jPanelMostrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDuracion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabelDuracion.setForeground(new java.awt.Color(0, 153, 153));
        jLabelDuracion.setText("Duracion: 00:00:00");
        jPanelMostrar.add(jLabelDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));

        jLabelNomb.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabelNomb.setForeground(new java.awt.Color(0, 153, 153));
        jLabelNomb.setText("Abriendo:");
        jPanelMostrar.add(jLabelNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 460, 30));

        getContentPane().add(jPanelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 470, 40));

        jListCancion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 3, true));
        jListCancion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jScrollPanelList.setViewportView(jListCancion);

        getContentPane().add(jScrollPanelList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 420, 250));

        jButtonAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonAgregar.setText("Add");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 90, 30));

        jButtonRemover.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonRemover.setText("Remove");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, 30));

        jPanelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));
        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelTituloD.setText("Abriendo :");
        jPanelTitulo.add(jLabelTituloD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 30));

        getContentPane().add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 30));

        jPanelDuracion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));
        jPanelDuracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDuracionT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelDuracionT.setText("Duracion Total : ");
        jPanelDuracion.add(jLabelDuracionT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));

        getContentPane().add(jPanelDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 220, 40));

        jPanelEdicion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 2, true));
        jPanelEdicion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEdicion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabelEdicion.setText("Fecha Edicion : ");
        jPanelEdicion.add(jLabelEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 200, 20));

        getContentPane().add(jPanelEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 210, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cd.jpg"))); // NOI18N
        jLabelFondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 3, true));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 430));

        jMenuOpcion.setText("Opciones");

        jMenuItemAbrir.setText("Abrir ");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuOpcion.add(jMenuItemAbrir);

        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuOpcion.add(jMenuItemGuardar);

        jMenuItem2.setText("Ayuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuOpcion.add(jMenuItem2);

        jMenuItemInfo.setText("Informacion");
        jMenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInfoActionPerformed(evt);
            }
        });
        jMenuOpcion.add(jMenuItemInfo);

        jMenuBar.add(jMenuOpcion);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReproducirActionPerformed
        switch (jButtonReproducir.getText()){
            case "Play" : 
                acc.reproducir(); 
                jButtonReproducir.setText("Pause"); 
                break;
            case "Pause" : 
                acc.pausar(); 
                jButtonReproducir.setText("Play"); 
                break;
        }
    }//GEN-LAST:event_jButtonReproducirActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        acc.mizplayer.obtenerCancion();
        jLabelNomb.setText("Abriendo: "+acc.mizplayer.file.getName()); 
        jLabelDuracion.setText("Duracion: "+acc.mizplayer.hor+" : "+acc.mizplayer.min+" : "+acc.mizplayer.seg);
        jListCancion.setModel(acc.mizplayer.files);
        jLabelTituloD.setText("Abriendo: Default List");
        jLabelDuracionT.setText("Duracion Total: "+acc.mizplayer.hort+" : "+acc.mizplayer.mint+" : "+acc.mizplayer.segt);
        jButtonReproducir.setText("Pause"); 
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        if (acc.mizplayer.archives != null){
            acc.anterior();
            jLabelNomb.setText("Abriendo: "+acc.mizplayer.file.getName()); 
            jLabelDuracion.setText("Duracion: "+acc.mizplayer.hor+" : "+acc.mizplayer.min+" : "+acc.mizplayer.seg);
            jButtonReproducir.setText("Pause"); 
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        if (acc.mizplayer.archives != null){
            acc.siguiente();
            jLabelNomb.setText("Abriendo: "+acc.mizplayer.file.getName()); 
            jLabelDuracion.setText("Duracion: "+acc.mizplayer.hor+" : "+acc.mizplayer.min+" : "+acc.mizplayer.seg);
            jButtonReproducir.setText("Pause");
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetenerActionPerformed
        acc.detener();
        jButtonReproducir.setText("Play");
    }//GEN-LAST:event_jButtonDetenerActionPerformed

    double sound;
    private void jSliderSoundStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSoundStateChanged
        sound = (double)jSliderSound.getValue()/100;
        try { 
            acc.mizplayer.control.setGain(sound); 
        } catch (BasicPlayerException ex) { 
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        jLabelSound.setText(jSliderSound.getValue()+"%"); 
    }//GEN-LAST:event_jSliderSoundStateChanged

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        if (acc.mizplayer.archives != null){
            acc.guardarDisc();
            acc.mizplayer.setTituloDisc(JOptionPane.showInputDialog(null, "Titulo de la lista"));
            fecha = new Date();
            SimpleDateFormat datos = new SimpleDateFormat("dd/MM/YYYY");
            acc.mizplayer.setFechaEdicion(datos.format(fecha));
        } else {
            JOptionPane.showMessageDialog(null,"Primero crea una lista de reproduccion con el boton `+`");
        }
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        if (acc.mizplayer.archives != null){
            acc.cargarDisc();
            jListCancion.setModel(acc.mizplayer.files);
            jLabelNomb.setText("Abriendo: "+acc.mizplayer.file.getName()); 
            jLabelDuracion.setText("Duracion: "+acc.mizplayer.hor+" : "+acc.mizplayer.min+" : "+acc.mizplayer.seg);
            jButtonReproducir.setText("Pause");
            jLabelTituloD.setText("Abriendo : "+acc.mizplayer.getTituloDisc());
            jLabelEdicion.setText("Fecha edicion: "+acc.mizplayer.getFechaEdicion());
            jLabelDuracionT.setText("Duracion Total: "+acc.mizplayer.hort+" : "+acc.mizplayer.mint+" : "+acc.mizplayer.segt);
        } else {
            JOptionPane.showMessageDialog(null,"Primero crea una lista de reproduccion con el boton `+`");
        }    
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void jMenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInfoActionPerformed
        JOptionPane.showMessageDialog(null,"Este reproductor de canciones fue hecho por los estudiantes de Unillanos : \n   *Mario Alexander Morales Hernandez\n   *David Espinosa");
    }//GEN-LAST:event_jMenuItemInfoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        if (acc.mizplayer.archives != null){
            acc.agregar();
            jLabelDuracionT.setText("Duracion Total: "+acc.mizplayer.hort+" : "+acc.mizplayer.mint+" : "+acc.mizplayer.segt);
        }else
            JOptionPane.showMessageDialog(null,"Primero crea una lista de reproduccion con el boton `+`");
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (acc.mizplayer.archives != null){
            int remove = jListCancion.getSelectedIndex();
            acc.mizplayer.archives.remove(remove);
            acc.mizplayer.files.removeElementAt(remove);
            jListCancion.setSelectedIndex(0);
            acc.mizplayer.obtenerDuracionTotal();
            jLabelDuracionT.setText("Duracion Total : "+acc.mizplayer.hort+" : "+acc.mizplayer.mint+" : "+acc.mizplayer.segt);
        }else
            JOptionPane.showMessageDialog(null,"Primero crea una lista de reproduccion con el boton `+`");
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null,"    Bienvenido al reproductor de canciones mix15\n-Empieza creando una lista con el boton ´+´ y con los demas botones(play,◘,<<,>>) controlaras sus contenido\n-Con los botones 'add' y 'remove' añadiras y removeras canciones a la lista\n-Podras guardar y abrir una lista de reproduccion");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonDetener;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonReproducir;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelDuracionT;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNomb;
    private javax.swing.JLabel jLabelSound;
    private javax.swing.JLabel jLabelTituloD;
    private javax.swing.JList<String> jListCancion;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemInfo;
    private javax.swing.JMenu jMenuOpcion;
    private javax.swing.JPanel jPanelDuracion;
    private javax.swing.JPanel jPanelEdicion;
    private javax.swing.JPanel jPanelMostrar;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPanelList;
    private javax.swing.JSlider jSliderSound;
    // End of variables declaration//GEN-END:variables
}
