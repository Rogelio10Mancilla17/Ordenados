package metodos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficar extends JFrame {

    JRadioButtonMenuItem combo = new JRadioButtonMenuItem();
    JRadioButton metodosExternos;
    JRadioButton metodosInternos;
    JButton boton = new JButton("Aceptar");

    public Graficar(String titulo) {
        setTitle(titulo);
        setVisible(true);
        setSize(300, 150);
        setLayout(new BorderLayout());
        add(SelectorOrdenador(), BorderLayout.WEST);
        boton.addActionListener(new logicaBTN());
        add(boton, BorderLayout.CENTER);
        setResizable(false);
        setLocation(700, 400);
    }

    public JPanel SelectorOrdenador() {
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, WIDTH));
        ButtonGroup combo = new ButtonGroup();

        metodosExternos = new JRadioButton("Metodos Externos");
        metodosInternos = new JRadioButton("Metodos Internos");
        boton = new JButton("Aceptar");

        combo.add(metodosExternos);
        combo.add(metodosInternos);
        combo.add(boton);

        pan.add(metodosExternos);
        pan.add(metodosInternos);
        pan.add(boton);

        return pan;
    }

    public void Graficar(String nombreMetodo, double movimiento, double pasada, double iteracion) {

        int mov = (int) movimiento;
        int pas = (int) pasada;
        int ite = (int) iteracion;

        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(mov, nombreMetodo, "Movimientos");
        datos.addValue(pas, nombreMetodo, "Pasadas");
        datos.addValue(ite, nombreMetodo, "Iteraciones");

        JFreeChart chart = ChartFactory.createBarChart3D(nombreMetodo, "Metodos", "Porcentaje", datos, PlotOrientation.VERTICAL, true, true, true);

        ChartFrame frame = new ChartFrame("Metodos de Ordenamiento", chart);
        frame.pack();
        frame.setVisible(true);

    }

    public void GraficarInternos(int[] v, metodos obj) {

        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(obj.burbujaMovimiento(v), "Burbuja", "Movimientos");
        datos.addValue(obj.burbujaPasada(v), "Burbuja", "Pasadas");
        datos.addValue(obj.burbujaIteracion(v), "Burbuja", "Iteraciones");

        datos.addValue(obj.ordenacionShakerMovimiento(v), "OrdenacionShaker", "Movimientos");
        datos.addValue(obj.ordenacionShakerPasada(v), "OrdenacionShaker", "Pasadas");
        datos.addValue(obj.ordenacionShakerIteracion(v), "OrdenacionShaker", "Iteraciones");

        datos.addValue(obj.shellSortMovimiento(v), "ShellSort", "Movimientos");
        datos.addValue(obj.shellSortPasada(v), "ShellSort", "Pasadas");
        datos.addValue(obj.shellSortIteracion(v), "ShellSort", "Iteraciones");

        datos.addValue(obj.ordenarInsercionMovimiento(v), "OrdenarInsercion", "Movimientos");
        datos.addValue(obj.ordenarInsercionPasada(v), "OrdenarInsercion", "Pasadas");
        datos.addValue(obj.ordenarInsercionIteracion(v), "OrdenarInsercion", "Iteraciones");

        datos.addValue(obj.quicksortMovimiento(v, 0, 0), "Quicksort", "Movimientos");
        datos.addValue(obj.quicksortPasada(v, 0, 0), "Quicksort", "Pasadas");
        datos.addValue(obj.quicksortIteracion(v, 0, 0), "Quicksort", "Iteraciones");

        datos.addValue(obj.radixSortMovimiento(v), "RadixSort", "Movimientos");
        datos.addValue(obj.radixSortPasada(v), "RadixSort", "Pasadas");
        datos.addValue(obj.radixSortIteracion(v), "RadixSort", "Iteraciones");

        JFreeChart chart = ChartFactory.createBarChart3D("", "Metodos", "Porcentaje", datos, PlotOrientation.VERTICAL, true, true, true);

        ChartFrame frame = new ChartFrame("Metodos de Ordenamiento", chart);
        frame.pack();
        frame.setVisible(true);

    }

    public void GraficarExternos(int[] v, metodosExternos obj2) {
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(obj2.sortMov(v), "Sort", "Movimientos");
        datos.addValue(obj2.sortPasadas(v), "Sort", "Pasadas");
        datos.addValue(obj2.sortITe(v), "Sort", "Iteraciones");
        
        datos.addValue(obj2.naturalMov(v, 0, 0), "Natural", "Movimientos");
        datos.addValue(obj2.naturalPasadas(v,0,0), "Natural", "Pasadas");
        datos.addValue(obj2.naturalIteracion(v, 0, 0), "Natural", "Iteraciones");
        
        JFreeChart chart = ChartFactory.createBarChart3D("", "Metodos", "Porcentaje", datos, PlotOrientation.VERTICAL, true, true, true);

        ChartFrame frame = new ChartFrame("Metodos de Ordenamiento", chart);
        frame.pack();
        frame.setVisible(true);
 
    }

    class logicaBTN implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            metodos obj = new metodos();
            metodosExternos obj2 = new metodosExternos();

            if (metodosInternos.isSelected() == true) {

                int v[] = obj.LLenar();
                GraficarInternos(v, obj);

            }
            if (metodosExternos.isSelected() == true) {

                int v[] = obj2.LLenar();
                GraficarExternos(v, obj2);
            }

        }

    }

    public static void main(String args[]) {
        new Graficar("VENTANA PRINCIPAL").setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
