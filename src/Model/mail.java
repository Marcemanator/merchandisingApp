/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * La clase `mail` proporciona métodos para enviar correos electrónicos, tanto con
 * mensajes simples como con adjuntos.
 * 
 * @author mmarc
 */
public class mail {

    String asunto;
    String mensaje;
    String destinatario;
    String ruta;

    /**
     * Constructor para un correo electrónico sin adjuntos.
     *
     * @param asunto Asunto del correo electrónico.
     * @param mensaje Cuerpo del correo electrónico.
     * @param destinatario Dirección de correo electrónico del destinatario.
     * @param ruta Ruta del archivo adjunto (opcional).
     */
    public mail(String asunto, String mensaje, String destinatario, String ruta) {
        this.asunto = asunto;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }

    /**
     * Constructor para un correo electrónico sin adjuntos.
     *
     * @param asunto Asunto del correo electrónico.
     * @param mensaje Cuerpo del correo electrónico.
     * @param destinatario Dirección de correo electrónico del destinatario.
     */
    public mail(String asunto, String mensaje, String destinatario) {
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    /**
     * Obtiene el asunto del correo electrónico.
     *
     * @return Asunto del correo electrónico.
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Establece el asunto del correo electrónico.
     *
     * @param asunto Asunto del correo electrónico.
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Obtiene el cuerpo del correo electrónico.
     *
     * @return Cuerpo del correo electrónico.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el cuerpo del correo electrónico.
     *
     * @param mensaje Cuerpo del correo electrónico.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene la dirección de correo electrónico del destinatario.
     *
     * @return Dirección de correo electrónico del destinatario.
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Establece la dirección de correo electrónico del destinatario.
     *
     * @param destinatario Dirección de correo electrónico del destinatario.
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtiene la ruta del archivo adjunto.
     *
     * @return Ruta del archivo adjunto.
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Establece la ruta del archivo adjunto.
     *
     * @param ruta Ruta del archivo adjunto.
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Envía un correo electrónico sin adjuntos.
     *
     * @return `true` si el correo se envía correctamente, `false` de lo contrario.
     */
    public Boolean mail() {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.marceweb.es");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("marce@marceweb.es", "Marcemanator2011"));
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setFrom("marce@marceweb.es");
            email.setSubject(this.asunto);
            email.setMsg(this.mensaje);
            email.addTo(this.destinatario);
            email.send();
            return true;
        } catch (EmailException ex) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Envía un correo electrónico con adjunto.
     *
     * @return `true` si el correo se envía correctamente, `false` de lo contrario.
     */
    public Boolean MailAdjunto() {
        try {
            EmailAttachment Adjunto = new EmailAttachment();
            Adjunto.setPath(this.ruta);
            Adjunto.setDisposition(EmailAttachment.ATTACHMENT);
            Adjunto.setDescription("control de cambios");

            MultiPartEmail mail = new MultiPartEmail();
            mail.setAuthenticator(new DefaultAuthenticator("marce@marceweb.es", "Marcemanator2011"));
            mail.setHostName("smtp.serviciodecorreo.es");
            mail.setSmtpPort(465);
            mail.setSSLOnConnect(true);
            mail.setCharset("UTF-8");
            mail.addTo(this.destinatario);
            mail.setFrom("marce@marceweb.es", "Control de cambios");
            mail.setSubject(this.asunto);
            mail.setMsg(this.mensaje);
            mail.attach(Adjunto);
            mail.send();
            return true;
        } catch (EmailException ex) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
