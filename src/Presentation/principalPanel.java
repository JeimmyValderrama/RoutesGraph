package Presentation;

import Logic.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class principalPanel extends JFrame implements ActionListener {

    private JPanel panelPrincipal;
    private JLabel image,point1,point2,results;
    private JButton show;
    private JComboBox startPoints,finalPoints;

    private JTextArea results2;

    Control control = new Control();

    String[] points = {"Añoranzas", "Hotel Bella Tierra", "Cementerio", "Restaurante Boyaca Real", "Hotel los Vagones", "Hospedaje Santa Elena",
            "San Benito", "Denticenter", "Restaurante Corazon de Melon","Tiendas D1", "Parque Ecologico","I.E Jorge Clemente Palacios"
            ,"Casa Motta", "Sabajon Don Joaquin","Productos San Nicolas","El Tenampa Club","Hotel La Marquesa de Pinares"};
    public principalPanel(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setTitle("Ruta mas corta");
        setResizable(false);

        panelPrincipal = new JPanel();
        image = new JLabel();
        point1 = new JLabel("Punto de Referencia Inicial");
        point2 = new JLabel("Punto de Referencia Final");
        results = new JLabel("*********Resultados*********");
        results2 = new JTextArea();
        show = new JButton("Ver ruta");
        startPoints = new JComboBox<>(points);
        finalPoints = new JComboBox<>(points);

    }



    public void principal(){

        Font letter1 = new Font("Yu Gothic Light",1,17);

        //Configuracion Paneles

        //Panel Principal
        panelPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panelPrincipal.setBackground(Color.white);
        panelPrincipal.setLayout(null);

        //Configuracion imagen
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResource("/Image/Mapa2.png"));
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            image.setBounds(7, 7, 650,550);
            image.setIcon(imageIcon);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        point1.setBounds(690, 50, 250, 50);
        point1.setFont(letter1);

        startPoints.setBounds(690, 100, 250, 30);
        startPoints.setBackground(new Color(255, 250, 250));

        point2.setBounds(690, 150, 250, 50);
        point2.setFont(letter1);

        finalPoints.setBounds(690, 200, 250, 30);
        finalPoints.setBackground(new Color(255, 250, 250));

        results.setBounds(690, 250, 250, 50);
        results.setFont(letter1);

        // Habilitar el ajuste automático del tamaño del JTextArea
        results2.setLineWrap(true);
        results2.setWrapStyleWord(true);

        results2.setBounds(690, 300, 250, 100);


        show.setBounds(750, 450, 150, 50);
        show.setBackground(new Color(255, 250, 250));
        show.setFont(letter1);
        show.addActionListener(this);


        panelPrincipal.add(point1);
        panelPrincipal.add(point2);
        panelPrincipal.add(results);
        panelPrincipal.add(results2);
        panelPrincipal.add(startPoints);
        panelPrincipal.add(finalPoints);
        panelPrincipal.add(show);
        panelPrincipal.add(image);

        add(panelPrincipal);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show) {
            results2.setText(control.searchRoute(startPoints.getSelectedIndex(),finalPoints.getSelectedIndex()));
        }

    }
}
