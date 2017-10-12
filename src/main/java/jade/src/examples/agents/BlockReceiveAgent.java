package jade.src.examples.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by reserchr on 12.10.17.
 */
public class BlockReceiveAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Hallo BlockReceiveAgent " + getAID().getName() + " meldet sich zum Dienst!!!");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(this.getAgent().getAID().getLocalName() + ": " + msg.getOntology());
                    System.out.println(this.getAgent().getAID().getLocalName() + ": " + msg.getContent());
                }
            }
        });
    }
}
