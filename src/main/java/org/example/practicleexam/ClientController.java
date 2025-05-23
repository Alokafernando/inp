package org.example.practicleexam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    @FXML
    private Button btnSend;

    @FXML
    private TextField inputField;

    @FXML
    private TextArea messageContent;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String command="";
    Socket socket;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(() -> {
            try {
                socket = new Socket("localhost",4000);
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!command.equals("finished")) {
                    command = dataInputStream.readUTF();
                    messageContent.appendText(command + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }


    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        dataOutputStream= new DataOutputStream( socket.getOutputStream());

        String message = inputField.getText();
        String sentMessage = "";
        if (message.equals("TIME")){
            sentMessage = LocalTime.now().toString();
        } else if (message.equals("DATE")) {
            sentMessage = LocalDate.now().toString();
        }else if (message.equals("UPTIME")) {

        } else if (message.equals("BYE")) {
            socket.close();
        }else{
            sentMessage = "invalid command";
        }
        System.out.println("message" + sentMessage);

        dataOutputStream.writeUTF( "Client :" + sentMessage);
        dataOutputStream.flush();
        inputField.setText("");

    }

}
