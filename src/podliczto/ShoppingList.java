
package podliczto;

import static java.awt.SystemColor.text;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Konrad
 */
public class ShoppingList {
    
    String shoppingList;
    
    public ShoppingList(){
    }
    
    public void saveShoppingList(JTextArea shoppingList) throws FileNotFoundException, IOException{
    try( 
            
    FileWriter out = new FileWriter( "shoppingList.txt" )  ){
    shoppingList.write(out);
    }
    catch(FileNotFoundException e){
        System.out.println("nie ma takiego pliku");
    }
    
    }

    public void loadShoppingList(JTextArea shoppingList) throws FileNotFoundException, IOException{
    FileReader reader = new FileReader("shoppingList.txt");
            shoppingList.read(reader,"filename.txt"); 
    }
    
    public void sendEmail() throws AddressException, MessagingException{
      String host = "smtp.gmail.com";
        String Password = "Majsterek1423";
        String from = "dzieniu@gmail.com";
        String toAddress = "dzieniu@gmail.com";
        String filename = "shoppingList.txt";
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("Lista zakupów");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText("");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(filename);

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
    }

    
}
