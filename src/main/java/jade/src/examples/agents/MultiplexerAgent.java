package jade.src.examples.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by reserchr on 12.10.17.
 */
public class MultiplexerAgent extends Agent{

    @Override
    protected void setup() {
        System.out.println("Hallo Multiplexer " + getAID().getLocalName() + " meldet sich zum Dienst!!!");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    msg.setContent(msg.getContent());
                    msg.clearAllReceiver();
                    msg.setSender(myAgent.getAID());
                    msg.addReceiver(new AID("Receiver1", AID.ISLOCALNAME));
                    msg.addReceiver(new AID("Receiver2", AID.ISLOCALNAME));
                    myAgent.send(msg);
                }
            }
        });
    }
}
