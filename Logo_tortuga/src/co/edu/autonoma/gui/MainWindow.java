/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.autonoma.gui;

import co.edu.autonoma.Exceptions.InvalidInstructionException;
import co.edu.autonoma.Exceptions.NegativeValueException;
import co.edu.autonoma.elements.Canvas;
import co.edu.autonoma.elements.Drawable;
import co.edu.autonoma.elements.TurtleCommandReader;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP-15EC107LA
 */
public class MainWindow extends javax.swing.JFrame implements Drawable{
    private Canvas canvas;
    private TurtleCommandReader reader;
    public static final int listLenght= 275;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        setResizable(false);
        initComponents();
        cleanJlist();
    }
    
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
        canvas.setDrawable(this);
        reader= new TurtleCommandReader(canvas);
    }
    

    @Override
    public void paint(Graphics g){
        super.paint(g);
        canvas.draw(g);
        g.setColor(Color.black);
        g.drawLine(0, 390, getWidth()-listLenght, 390);
        g.drawLine(getWidth()-listLenght, 0, getWidth()-listLenght, 390);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccept = new javax.swing.JButton();
        txtCommandText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlistComands = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        txtCommandText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCommandTextActionPerformed(evt);
            }
        });

        JlistComands.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JlistComands.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JlistComandsInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(JlistComands);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(txtCommandText, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAccept)
                .addGap(200, 200, 200)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCommandText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAccept))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCommandTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCommandTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCommandTextActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        //repeat 4 [fd 4; fd 45]
        String data = this.txtCommandText.getText().toLowerCase();
        String[] array= data.split(" ");
        String block= "";
        if(array.length > 2){
            block= data.substring(data.indexOf("[") +1, data.indexOf("]"));
        }
        try{
           reader.read(array, block); 
        }catch(NegativeValueException e){
            JOptionPane.showMessageDialog(this, "Ingrese un valor positivo");
        }catch(InvalidInstructionException j){
            JOptionPane.showMessageDialog(this, "Instrucción inválida");
        }
        addData();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void JlistComandsInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JlistComandsInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JlistComandsInputMethodTextChanged
    
    public DefaultListModel cleanJlist(){
        DefaultListModel model= new DefaultListModel();
        JlistComands.setModel(model);
        return model;
    }
    
    public DefaultListModel addData(){
        DefaultListModel model= (DefaultListModel) JlistComands.getModel();
        model.addElement(txtCommandText.getText());
        return model;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainWindow window = new MainWindow();
        Canvas canvas = new Canvas(window.getWidth() - listLenght, window.getHeight());
        
        
        window.setCanvas(canvas);
//        garden.setWidth(window.getWidth());
//        garden.setHeight(window.getHeight());
        
        window.setTitle("Logo UAM");
        window.setVisible(true);
    }

    @Override
    public void redraw() {
        repaint();
    }

    @Override
    public void redraw(int x, int y, int width, int height) {
        repaint(x, y, width, height);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JlistComands;
    private javax.swing.JButton btnAccept;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCommandText;
    // End of variables declaration//GEN-END:variables
}
