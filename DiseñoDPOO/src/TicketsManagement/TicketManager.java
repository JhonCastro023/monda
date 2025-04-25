package TicketsManagement;

import java.util.*;

import UserAndRoleManagement.User;

import java.io.*;

public class TicketManager {
    private Map<String, Ticket> tickets = new HashMap<>();
    private Map<String, List<Ticket>> ticketsPorUsuario = new HashMap<>();
    private int ticketCounter = 1;

    public Ticket createTicket(String tipo, User usuario) {
        TicketType tipoTiquete = new TicketType(tipo, ticketCounter, ticketCounter);
        Ticket ticket = new Ticket("T" + (ticketCounter++), tipoTiquete, usuario.getUsername());
        tickets.put(ticket.getId(), ticket);
        ticketsPorUsuario.computeIfAbsent(usuario.getUsername(), k -> new ArrayList<>()).add(ticket);
        return ticket;
    }

    public boolean simularCompra(String tipo, User usuario) {
        Ticket t = createTicket(tipo, usuario);
        return t != null;
    }

    public boolean validarUso(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null && ticket.getEstado().equals("activo")) {
            ticket.setEstado("usado");
            return true;
        }
        return false;
    }

    public boolean validarAcceso(Ticket ticket, String atraccion) {
        String nivel = (String) ticket.getTipo().getNombreTipo();
        if (nivel.equals("Diamante")) return true;
        if (nivel.equals("Oro") && !atraccion.contains("Diamante")) return true;
        if (nivel.equals("Familiar") && atraccion.contains("Familiar")) return true;
        return false;
    }

    public Ticket comprarConDescuentoEmpleado(String tipo, User empleado) {
        TicketType tipoTiquete = new TicketType(tipo, ticketCounter, ticketCounter);
        double descuento = 0.3; // 30%
        double precioFinal = tipoTiquete.getPrecio() * (1 - descuento);
        Ticket ticket = new Ticket("T" + (ticketCounter++), tipoTiquete, empleado.getUsername());
        ticket.setPrecioPagado(precioFinal);
        tickets.put(ticket.getId(), ticket);
        ticketsPorUsuario.computeIfAbsent(empleado.getUsername(), k -> new ArrayList<>()).add(ticket);
        return ticket;
    }

    public Ticket createFastPassTicket(User usuario, String atraccion, String fecha) {
        Ticket ticket = createTicket("FastPass", usuario);
        ticket.setFastPassAtraccion(atraccion);
        ticket.setFastPassFecha(fecha);
        return ticket;
    }

    public void guardarTickets(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Ticket t : tickets.values()) {
                writer.println(t.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarTickets(String archivo) {
        tickets.clear();
        ticketsPorUsuario.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Ticket t = Ticket.fromCSV(line);
                tickets.put(t.getId(), t);
                ticketsPorUsuario.computeIfAbsent(t.getClienteId(), k -> new ArrayList<>()).add(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getTicketsDeUsuario(String username) {
        return ticketsPorUsuario.getOrDefault(username, new ArrayList<>());
    }
}
