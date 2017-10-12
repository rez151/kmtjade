package jade.src.examples.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by reserchr on 12.10.17.
 */
public class TimerAgent extends Agent{

    @Override
    protected void setup() {
        System.out.println("Hallo Timer " + getAID().getLocalName() + " meldet sich zum Dienst!!!");

        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Multiplexer", AID.ISLOCALNAME));
                msg.setLanguage("German");
                msg.setOntology("Klopf Klopf");
                msg.setContent("Essen ist daaaa!!");
                send(msg);
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("UUUUUnd tschüss!!");
    }


}
