package Interfaces;

import Main.Generator;
import Main.Plant;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 *
 * @author USER
 */
public class Interface extends javax.swing.JFrame {

    Plant[] plants;

    /**
     * Creates new form Interface
     */
    public Interface(Plant[] plants) {
        initComponents();
        setLocationRelativeTo(null);
        this.plants = plants;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addPlantBtn = new javax.swing.JButton();
        run = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        uploadData = new javax.swing.JButton();
        downloadData = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Car Assembler Plant simulator");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        addPlantBtn.setText("Add Plant");
        addPlantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlantBtnActionPerformed(evt);
            }
        });

        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        jButton3.setText("Download Results");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        uploadData.setText("Upload Data");
        uploadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadDataActionPerformed(evt);
            }
        });

        downloadData.setText("Download Data");
        downloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPlantBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uploadData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloadData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(addPlantBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(downloadData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        if (this.plants.length > 0) {
            for (int i = 0; i < this.plants.length; i++) {
                this.plants[i].start();
            }
            JOptionPane.showMessageDialog(null, "Simulation started succesfully.");
        } else {
            JOptionPane.showMessageDialog(null, "You must add at least one plant to run the simulation.");
        }
    }//GEN-LAST:event_runActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String[] header = {"plant", "wage expenses", "material expenses", "days to shipment", "cars assembled", "assemblers", "producers", "income"};

        try {
            FileWriter fileWriter = new FileWriter("datos.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < header.length; i++) {
                bufferedWriter.write(header[i]);

                if (i != header.length - 1) {
                    bufferedWriter.write(",");
                }
            }
            // Escribir encabezados
            bufferedWriter.newLine();
            
            for (int i = 0; i < this.plants.length; i++) {
                System.out.println(this.plants[i].name);
                String[] row1 = {this.plants[i].name, this.plants[i].counter.wage_expenses + "", this.plants[i].counter.material_expenses + "", this.plants[i].counter.days_to_shipment + "", this.plants[i].counter.cars_assembled + "", this.plants[i].counter.numberof_assemblers + "", this.plants[i].counter.numberof_producers + "", this.plants[i].counter.income + ""};
                for (int n = 0; n < row1.length; n++) {
                    bufferedWriter.write(row1[n]);

                    if (i != row1.length - 1) {
                        bufferedWriter.write(",");
                    }
                }

                bufferedWriter.newLine();
            }
            bufferedWriter.close();

            System.out.println("Archivo CSV escrito exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al escribir archivo CSV: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addPlantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlantBtnActionPerformed
        this.setVisible(false);
        new addPlant(this.plants).setVisible(true);
    }//GEN-LAST:event_addPlantBtnActionPerformed

    private void uploadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadDataActionPerformed
        String aux = "";
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            File open = file.getSelectedFile();

            if (open != null) {
                FileReader files = new FileReader(open);
                BufferedReader read = new BufferedReader(files);
                while ((aux = read.readLine()) != null) {
                    String[] data = aux.split(",");
                    Generator generator = new Generator(Integer.parseInt(data[0]));
                    Plant plant = new Plant(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Integer.parseInt(data[9]), generator);

                    Plant[] newArray = new Plant[this.plants.length + 1];

                    for (int i = 0; i < this.plants.length; i++) {
                        newArray[i] = this.plants[i];
                    }

                    newArray[newArray.length - 1] = plant;
                    this.plants = newArray;

                }
                read.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo o el archivo no tiene el formato correspondiente, por lo que se iniciara la aplicación sin informacion previa.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_uploadDataActionPerformed

    private void downloadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadDataActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(file);
            File selectedFile = file.getSelectedFile();

            if (selectedFile != null) {
                String message = "";
                for (int i = 0; i < this.plants.length; i++) {
                    message += this.plants[i].name + "," + this.plants[i].generatedValues.getGeneratorNumber() + "," + this.plants[i].chasisPartsRequired + "," + this.plants[i].enginePartsRequired + "," + this.plants[i].bodyWorkPartsRequired + "," + this.plants[i].accesoriesPartsRequired + "," + this.plants[i].wheelsPartsRequired + "," + this.plants[i].standardCarPrice + "," + this.plants[i].accesoriesCarPrice + "," + this.plants[i].standardCarsBeforeAccesories + "," + "\n";
                }

                FileWriter save;
                save = new FileWriter(selectedFile);
                save.write(message);
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_downloadDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlantBtn;
    private javax.swing.JButton downloadData;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton run;
    private javax.swing.JButton uploadData;
    // End of variables declaration//GEN-END:variables
}
