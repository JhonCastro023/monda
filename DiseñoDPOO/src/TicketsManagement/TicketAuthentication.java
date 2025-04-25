import java.util.ArrayList;
import java.util.List;

public class TicketAuthentication {

    private TicketManager ticketManager;
  
    public TicketAuthentication(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
    }

    public boolean validate(String ticketTypeName) {
        try {
            TicketType type = TicketType.valueOf(ticketTypeName);
            return type != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean registerTicket(TicketManager ticketManagement) {
        if (ticketManagement == null) {
            return false;
        }
        this.ticketManager = ticketManagement;
        return true;
    }
