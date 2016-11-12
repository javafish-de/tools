package de.javafish.mail;

import java.io.*;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {

    private final Session session;
    private Folder folder;
    
    private Mailer(Session session) {
        this.session = session;
    }

    public static Mailer getStratoSession(final String user, final String pass) {
        
        System.out.println("*** " + user + " *** " + pass + " ***");
        final Properties props = new Properties();

        // Zum Empfangen
        props.setProperty("mail.pop3.host", "pop3.strato.de");
        props.setProperty("mail.pop3.user", user);
        props.setProperty("mail.pop3.password", pass);
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.auth", "true");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Zum Senden
        props.setProperty("mail.smtp.host", "smtp.strato.de");
        props.setProperty("mail.smtp.user", user);
        props.setProperty("mail.smtp.password", pass);
        props.setProperty("mail.smtp.auth", "true");
        
//        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");
        
        String port = "465"; // 25 / 465 / 587
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.socketFactory.port", port);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.ssl.trust", "*");
        props.setProperty("mail.debug", "true");

        props.list(System.out);
        System.out.println("");
        
//        return new Mailer(Session.getInstance(props));
        return new Mailer(Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
//                String user = props.getProperty("mail.pop3.user");
//                String pass = props.getProperty("mail.pop3.password");
                System.out.println("*** " + user + " *** " + pass + " ***");
                return new PasswordAuthentication(user, pass);
            }
        }));
    }

    public static Mailer getSiebhirnSession(String user, String pass) {
        
        final Properties props = new Properties();

        // Zum Empfangen
        props.setProperty("mail.pop3.host", "127.0.0.1");
        props.setProperty("mail.pop3.user", user);
        props.setProperty("mail.pop3.password", pass);
        props.setProperty("mail.pop3.port", "110");
        props.setProperty("mail.pop3.auth", "true");
//        props.setProperty("mail.pop3.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");

        // Zum Senden
        props.setProperty("mail.smtp.host", "127.0.0.1");
        props.setProperty("mail.smtp.user", user);
        props.setProperty("mail.user", user);
        props.setProperty("mail.smtp.password", pass);
        props.setProperty("mail.smtp.auth", "true");
        
//        props.setProperty("mail.smtp.starttls.enable", "false");
        
        props.setProperty("mail.smtp.port", "25"); // 25 alternativ 587
        props.setProperty("mail.smtp.socketFactory.port", "25");
//        props.setProperty("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");

        return new Mailer(Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        props.getProperty("mail.pop3.user"),
                        props.getProperty("mail.pop3.password"));
            }

        }));
    }

    public Folder openPop3InboxReadOnly() throws MessagingException {
        return openPop3Inbox(Folder.READ_ONLY);
    }
    
    public Folder openPop3InboxReadWrite() throws MessagingException {
        return openPop3Inbox(Folder.READ_WRITE);
    }
    
    public Folder openPop3Inbox(int mode) throws MessagingException {
        
        Store store = session.getStore("pop3");
        store.connect();

        folder = store.getFolder("INBOX");
        folder.open(mode);

        return folder;
    }

    public void closeInbox() throws MessagingException {
        if (folder != null) {
            folder.close(false);
            folder.getStore().close();
        }
    }

    public StringBuilder getAllTextPlainMessages()
            throws MessagingException, IOException {
        
        StringBuilder sb = new StringBuilder();
        
        for (Message m : folder.getMessages()) {
            sb.append("\nNachricht");
            sb.append("\nVon: ").append(Arrays.toString(m.getFrom()));
            sb.append("\nBetreff: ").append(m.getSubject());
            sb.append("\nGesendet am: ").append(m.getSentDate());
            sb.append("\nContent-Type: ").append(new ContentType(m.getContentType()));

            if (m.isMimeType("text/plain")) {
                sb.append("\n").append(m.getContent());
            }
        }
        return sb;
    }

//    public static void printAllMultipartMessages(Folder folder)
//            throws MessagingException, IOException {
//        for (Message m : folder.getMessages()) {
//            if (m.isMimeType("text/plain")) {
//                System.out.println("Nachricht ist text/plain");
//            } else if (m.isMimeType("multipart/*")) {
//                System.out.println("Verarbeite multipart/* Nachricht");
//                Multipart mp = (Multipart) m.getContent();
//
//                // Der erste Part ist immer die Hauptnachricht
//                if (mp.getCount() > 1) {
//                    Part part = mp.getBodyPart(0);
//                    System.out.println(part.getContent());
//                }
//
//                // Laufe über alle Teile (Anhänge)
//                for (int j = 1; j < mp.getCount(); j++) {
//                    Part part = mp.getBodyPart(j);
//                    String disp = part.getDisposition();
//                    if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
//                        MimeBodyPart mimePart = (MimeBodyPart) part;
//
//                        // Gib MIME-Typ jedes Anhangs aus; im Fall von XML die Nachricht
//                        System.out.println("MIME-Typ ist " + mimePart.getContentType());
//                        if (mimePart.isMimeType("text/xml")) {
//                            System.out.println(mimePart.getContent());
//                        }
//                    }
//                }
//                System.out.println("Verarbeitung abgeschlossen");
//            }
//        }
//    }

    public void postMail(String from, String name, String recipient, String subject, String message)
            throws MessagingException {
        
        Message msg = new MimeMessage(session);

        InternetAddress addressTo = new InternetAddress(recipient);
        try {
            msg.setFrom(new InternetAddress(from, name));
        } catch (UnsupportedEncodingException ex) {}
        msg.setRecipient(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        
        Transport.send(msg);
    }

    public void postMultipartTextAndHtmlMail(String recipient,
            String subject, String txtMsg, String htmlMsg)
            throws MessagingException {

        MimeMultipart content = new MimeMultipart("alternative");

        MimeBodyPart text = new MimeBodyPart();
        text.setContent(txtMsg, "text/text");
        content.addBodyPart(text);

        MimeBodyPart html = new MimeBodyPart();
        html.setContent(htmlMsg, "text/html");
        content.addBodyPart(html);

        Message msg = new MimeMessage(session);

        InternetAddress addressTo = new InternetAddress(recipient);
        
        msg.setRecipient(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        msg.setContent(content);
        
        Transport.send(msg);
    }

    public void postAttachement(String recipient, String subject,
            String message, String filename)
            throws MessagingException {
        
        MimeMultipart content = new MimeMultipart("mixed");

        MimeBodyPart text = new MimeBodyPart();
        text.setText(message);
        content.addBodyPart(text);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(
                new DataHandler(new FileDataSource(filename)));
        messageBodyPart.setFileName(new File(filename).getName());
        content.addBodyPart(messageBodyPart);

        Message msg = new MimeMessage(session);

        InternetAddress addressTo = new InternetAddress(recipient);
        
        msg.setRecipient(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        msg.setContent(content);

        Transport.send(msg);
    }
}