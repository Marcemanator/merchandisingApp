/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * La clase `comprueba` proporciona métodos para verificar y alertar sobre campos de texto vacíos.
 * Está diseñada para ser utilizada en la validación de formularios u otras interfaces de usuario.
 *
 * @author mmarc
 */
public class comprueba {
      
    /**
     * Verifica si un campo de texto está vacío.
     *
     * @param campo Campo de texto a verificar.
     * @return `true` si el campo está vacío, `false` de lo contrario.
     */
    static boolean vacio(JTextField campo) {
        return "".equals(campo.getText().trim());
    }

    /**
     * Muestra una alerta en caso de que un campo de texto esté vacío.
     *
     * @param padre Componente padre de la ventana de alerta.
     * @param campo Campo de texto que está vacío.
     */
    static void alertaVacio(Component padre, JTextField campo) {
        JOptionPane.showMessageDialog(padre, "El campo " + campo.getName() + " no puede quedar vacío", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
        campo.setBackground(Color.red);
    }
}

