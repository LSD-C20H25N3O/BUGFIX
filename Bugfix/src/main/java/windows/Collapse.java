package windows;

import javax.swing.ImageIcon;

public class Collapse extends javax.swing.JFrame {

    public Collapse() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUGFIX: Collapse");
        setLocation(new java.awt.Point(450, 0));
        setResizable(false);

        jLabel1.setIcon(new ImageIcon("img/collapse.png"));
        jLabel1.setMaximumSize(new java.awt.Dimension(360, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(360, 300));
        jLabel1.setName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
    }

    public static void run() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Collapse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new Collapse().setVisible(true);
    }

    private javax.swing.JLabel jLabel1;

}
