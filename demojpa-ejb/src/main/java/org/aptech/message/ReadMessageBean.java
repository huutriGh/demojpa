package org.aptech.message;

import org.aptech.entites.Employee;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "ReadMessageEJB"
        ,
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/MyQueue"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        }


)

public class ReadMessageBean implements MessageListener {
    public ReadMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
         Employee employee =   message.getBody(Employee.class);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
