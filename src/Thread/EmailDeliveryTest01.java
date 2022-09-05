package Thread;

import Thread.service.DeliveryEmailService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        Members member = new Members();
        Thread jiraya = new Thread(new DeliveryEmailService(member), "Jiraya");
        Thread kakashi = new Thread(new DeliveryEmailService(member), "Kakashi");
        Thread zabusa = new Thread(new DeliveryEmailService(member), "Zabusa");
        jiraya.start();
        kakashi.start();
        zabusa.start();
        while (true) {
            String entre_com_seu_email = JOptionPane.showInputDialog("Entre com seu email");
            if(entre_com_seu_email == null || entre_com_seu_email.isEmpty()) {
                member.close();
                break;
            }
            member.addMemberToEmail(entre_com_seu_email);
        }
    }
}
