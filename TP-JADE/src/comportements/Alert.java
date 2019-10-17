package comportements;

import agents.AlertAgent;
import agents.TravellerAgent;
import data.Journey;
import data.JourneysList;
import gui.AlertGui;
import gui.TravellerGui;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.proto.ContractNetInitiator;

import java.io.IOException;
import java.util.*;


/**
 * Journey Buyer Behaviour by contract net
 *
 * @author revised by Emmanuel ADAM
 * @version 191017
 */
@SuppressWarnings("serial")
public class Alert extends ContractNetInitiator {

    private String from;
    private String to;
    /**
     * agent gui
     */
    private AlertGui window;

    /**
     * acheteur lie a ce comportement
     */
    private AlertAgent monAgent;

    /**
     * initialisation
     *
     * @param agent       agent initiator
     * @param msg         initial message to send
     * @param _from       origine city
     * @param _to         destination city
     */
    public Alert(Agent agent, ACLMessage msg, final String _from, final String _to) {
        super(agent, msg);
        from = _from;
        to = _to;
        monAgent = (AlertAgent) agent;
        window = monAgent.getWindow();
        // définition du prococole
        msg.setProtocol(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
        // Réponse plus tard dans 1 sec
        msg.setReplyByDate(new Date(System.currentTimeMillis() + 1000));
        // relancer le comportement pour fixer la date de remise au plus tard, les destinataires, ...
        this.reset(msg);
    }


    /**
     * methode lancee a la reception de chaque refus
     *
     * @param refuse refus recu
     */
    @Override
    protected void handleRefuse(ACLMessage refuse) {
        window.println("Agent " + refuse.getSender().getLocalName() + " refuse");
    }

    /**
     * methode lancee a la reception d'un message d'erreur (impossibilite de poursuivre la vente)
     *
     * @param failure erreur recue
     */
    @Override
    protected void handleFailure(ACLMessage failure) {
        if (failure.getSender().equals(myAgent.getAMS())) {
            // ERREUR : le destinataire n'existe pas
            window.println("Le destinataire n'existe pas...");
        } else
            window.println("Agent " + failure.getSender().getLocalName() + " a echoue");
    }

    /**
     * methode lancee si toutes les reponses sont arrivees ou si le temps est ecoule<br>
     * accepte la meilleure offre, calcul basé sur la notoriété la plus haute et le prix le plus bas à part égale ici<br>
     * n'accepte pas l'offre si d�passe le prix max fix� par l'acheteur
     *
     * @param responses   reponses recues
     * @param acceptances vecteur des messages a transmettre en retour aux reponses recues
     * @see ContractNetInitiator#handleAllResponses(Vector, Vector)
     */
    @SuppressWarnings({"rawtypes"})
    @Override
    protected void handleAllResponses(Vector responses, Vector acceptances){

    }


    /**
     * methode lancee a la reception d'un message d'information (vente confirmee)
     *
     * @param inform message recu
     */
    @Override
    protected void handleInform(ACLMessage inform) {
        window.println("Agent " + inform.getSender().getLocalName() + " : " + inform.getContent());
    }
}
