package UserAndRoleManagement;


import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    public static final String CLIENT = "Client";
    private List<String> tickets;

    public Client(String username, String name, String email, String password) {
        super(username, name, email, password, CLIENT);
        this.tickets = new ArrayList<>();
    }

    public void buyTicket(String ticket) {
        tickets.add(ticket);
    }

    public void playAttraction() {
        System.out.println(getName() + " está jugando en una atracción.");
    }

    public List<String> getTickets() {
        return tickets;
    }
}

