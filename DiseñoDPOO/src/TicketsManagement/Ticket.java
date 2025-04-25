package TicketsManagement;

import java.util.List;

public abstract class Ticket {
    protected int id;
    protected TicketType type;
    protected boolean isValid;
    protected List<String> access;
    protected String date;
    protected int price;
    protected boolean fastPass;

    public Ticket(int id, TicketType type, List<String> access, String date, int price, boolean fastPass) {
        this.id = id;
        this.type = type;
        this.isValid = true;
        this.access = access;
        this.date = date;
        this.price = price;
        this.fastPass = fastPass;
    }

    public TicketType getType() {
        return type;
    }

    public void invalidate() {
        this.isValid = false;
    }

    public int getId() {
        return id;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getAccess() {
        return access;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public boolean hasFastPass() {
        return fastPass;
    }
}
