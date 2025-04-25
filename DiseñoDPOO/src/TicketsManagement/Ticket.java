package TicketsManagement;

public abstract class Ticket {
	
	    private String id;
	    private static TicketType tipo;
	    private String fechaReserva;
	    private String clienteId;
	    private String estado;
	    private static double precioPagado;
	    private String fastPassFecha;
	    private String fastPassAtraccion;

	    public Ticket(String id, TicketType tipo, String clienteId) {
	        this.id = id;
	        Ticket.tipo = tipo;
	        this.fechaReserva = java.time.LocalDateTime.now().toString();
	        this.clienteId = clienteId;
	        this.estado = "activo";
	        Ticket.precioPagado = tipo.getPrecio();
	    }
	    public String getId() {
	        return id;
	    }

	    public static TicketType getTipo() {
	        return tipo;
	    }

	    public String getFechaReserva() {
	        return fechaReserva;
	    }

	    public String getClienteId() {
	        return clienteId;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public double getPrecioPagado() {
	        return precioPagado;
	    }

	    public String getFastPassFecha() {
	        return fastPassFecha;
	    }

	    public String getFastPassAtraccion() {
	        return fastPassAtraccion;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    public void setPrecioPagado(double precioPagado) {
	        Ticket.precioPagado = precioPagado;
	    }

	    public void setFastPassFecha(String fastPassFecha) {
	        this.fastPassFecha = fastPassFecha;
	    }

	    public void setFastPassAtraccion(String fastPassAtraccion) {
	        this.fastPassAtraccion = fastPassAtraccion;
	    }

	    public String toCSV() {
	        return String.join(",",
	            id,
	            tipo.getNombreTipo(),
	            String.valueOf(tipo.getPrecio()),
	            fechaReserva,
	            clienteId,
	            estado,
	            String.valueOf(precioPagado),
	            fastPassFecha != null ? fastPassFecha : "",
	            fastPassAtraccion != null ? fastPassAtraccion : ""
	        );
	    }
	    public static Ticket fromCSV(String line) {
	        String[] parts = line.split(",", -1);
	        TicketType tipo = new TicketType(line, precioPagado, 0);
	        Ticket ticket = new Ticket(parts[0], tipo, parts[4]);
	        ticket.fechaReserva = parts[3];
	        ticket.estado = parts[5];
	        Ticket.precioPagado = Double.parseDouble(parts[6]);
	        ticket.fastPassFecha = parts[7].isEmpty() ? null : parts[7];
	        ticket.fastPassAtraccion = parts[8].isEmpty() ? null : parts[8];
	        return ticket;
	    }
	}

