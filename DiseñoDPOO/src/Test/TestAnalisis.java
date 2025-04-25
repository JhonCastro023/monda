package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestsAnalisis {

    private TicketManager ticketManager;
    private User employee;
    private User client;

    @BeforeEach
    public void setup() {
        ticketManager = new TicketManager();
        employee = new User("emp123", "Empleado Uno", "emp@parque.com", "password123", "Empleado");
        client = new User("cli456", "Cliente Uno", "cli@parque.com", "password456", "Cliente");
    }

    @Test
    public void testCreacionDeTiquetes() {
        Ticket ticket = ticketManager.createTicket("Familiar", client);
        assertNotNull(ticket);
        assertEquals("Familiar", Ticket.getTipo().getNombreTipo());
    }

    @Test
    public void testVentaDeTiquetes() {
        boolean exito = ticketManager.simularCompra("Diamante", client);
        assertTrue(exito);
        List<Ticket> tickets = ticketManager.getTicketsDeUsuario(client.getUsername());
        assertFalse(tickets.isEmpty());
    }

    @Test
    public void testVerificacionDeUso() {
        Ticket ticket = ticketManager.createTicket("Oro", client);
        assertTrue(ticketManager.validarUso(ticket.getId()));
        assertFalse(ticketManager.validarUso(ticket.getId())); // Segunda vez no debe permitir
    }

    @Test
    public void testRestriccionesDeAcceso() {
        Ticket ticket = ticketManager.createTicket("Familiar", client);
        assertTrue(ticketManager.validarAcceso(ticket, "Atracción Familiar"));
        assertFalse(ticketManager.validarAcceso(ticket, "Atracción Diamante"));
    }

    @Test
    public void testDescuentosParaEmpleados() {
        Ticket ticket = ticketManager.comprarConDescuentoEmpleado("Oro", employee);
        assertNotNull(ticket);
        assertTrue(ticket.getPrecioPagado() < Ticket.getTipo().getPrecio());
    }

    @Test
    public void testGestionDeFastPass() {
        Ticket ticket = ticketManager.createFastPassTicket(client, "Montaña Rusa", "2025-07-01 14:00");
        assertNotNull(ticket);
        assertEquals("Montaña Rusa", ticket.getFastPassAtraccion());
        assertEquals("2025-07-01 14:00", ticket.getFastPassFecha());
    }
    
}
