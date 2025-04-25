import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    private List<Ticket> tickets = new ArrayList<>();
    private int nextId = 1;

    public Ticket generateTicket(TicketType type) {
        int id = nextId++;
        String date = java.time.LocalDate.now().toString();
        int price = calcularPrecioPorTipo(type);
        boolean fastPass = (type == TicketType.Diamond || type == TicketType.Season);
        Ticket ticket = new StandardTicket(id, type, access, date, price, fastPass);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void cancelTicket(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id && t.isValid()) {
                t.invalidate();
                break;
            }
        }
    }
    
    private int calcularPrecioPorTipo(TicketType type) {
        return switch (type) {
            case Basic -> 30;
            case Family -> 50;
            case Gold -> 80;
            case Diamond -> 120;
            case Season -> 150;
        };
    }
}
