import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import AttractionsAndShowsManagement.AtraccionCultural;
import AttractionsAndShowsManagement.AtraccionMecanica;
import AttractionsAndShowsManagement.AttractionManager;
import AttractionsAndShowsManagement.ShowManager;
import AttractionsAndShowsManagement.Temporada;
import UserAndRoleManagement.AuthenticationService;
import UserAndRoleManagement.Client;
import UserAndRoleManagement.RoleManagement;
import UserAndRoleManagement.User;
import UserAndRoleManagement.UserProfileManagement;

	    public static void main(String[] args) {
	        AttractionManager manager = new AttractionManager();

	        AtraccionMecanica montanaRusa = new AtraccionMecanica(
	            0, "Montaña Rusa Extrema", "Zona A", 
	            30, "ALTA", 2, 1.40, 2.10, 
	            40.0, 120.0, AtraccionMecanica.NivelRiesgo.ALTO,
	            List.of("Problemas cardíacos", "Embarazo")
	        );

	        AtraccionMecanica ruedaFortuna = new AtraccionMecanica(
	            0, "Rueda de la Fortuna", "Zona Central", 
	            60, "MEDIA", 1, 1.20, 2.20, 
	            30.0, 150.0, AtraccionMecanica.NivelRiesgo.MEDIO,
	            List.of("Vértigo severo")
	        );

	        AtraccionCultural teatroMagico = new AtraccionCultural(
	            0, "Teatro Mágico", "Zona Cultural",
	            150, "ALTA", 5, "Mayores de 5 años", 
	            "Interior - Sin restricciones", 
	            "Accesible para sillas de ruedas",
	            "Fantasía", 45
	        );

	        AtraccionCultural casaTerror = new AtraccionCultural(
	            0, "Casa del Terror", "Zona Oeste",
	            20, "MEDIA", 3, "Mayores de 12 años", 
	            "Interior - Sin restricciones", 
	            "No recomendado para personas con afecciones cardíacas",
	            "Terror", 15
	        );

	        manager.agregarAtraccion(montanaRusa);
	        manager.agregarAtraccion(ruedaFortuna);
	        manager.agregarAtraccion(teatroMagico);
	        manager.agregarAtraccion(casaTerror);


	        System.out.println(manager.generarReporteAtracciones());


	        System.out.println("\nDescripción de atracciones:");
	        manager.listarTodas().forEach(a -> 
	            System.out.println("- " + a.obtenerDescripcion()));


	        manager.desactivarAtraccion(1);
	        System.out.println("\nMontaña Rusa está ahora: " + 
	            (montanaRusa.isActiva() ? "Activa" : "Inactiva"));


	        System.out.println("\nAtracciones en Zona Cultural:");
	        manager.buscarPorUbicacion("Zona Cultural")
	            .forEach(a -> System.out.println("- " + a.getNombre()));
	        ShowManager showManager = new ShowManager();

	        
            Temporada verano2023 = showManager.crearTemporada(
                "Verano 2023", 
                LocalDate.of(2023, Month.JUNE, 1),
                LocalDate.of(2023, Month.AUGUST, 31),
                "Espectáculos especiales de verano"
            );

            Temporada halloween2023 = showManager.crearTemporada(
                "Halloween 2023",
                LocalDate.of(2023, Month.OCTOBER, 15),
                LocalDate.of(2023, Month.NOVEMBER, 5),
                "Espectáculos de terror y misterio"
            );

            showManager.programarEspectaculo(
                "Festival Acuático",
                "Espectáculo con acróbatas y efectos de agua",
                LocalDateTime.of(2023, Month.JULY, 15, 20, 0),
                Duration.ofHours(1),
                "Lago Central",
                500,
                verano2023
            );

            showManager.programarEspectaculo(
                "Noche de Terror",
                "Espectáculo de terror con actores en vivo",
                LocalDateTime.of(2023, Month.OCTOBER, 31, 21, 0),
                Duration.ofMinutes(90),
                "Teatro Principal",
                300,
                halloween2023
            );
            
            UserProfileManagement userProfileManagement = new UserProfileManagement();
            AuthenticationService authService = new AuthenticationService();
            RoleManagement roleManagement = new RoleManagement();

            System.out.println("=== Registro de Usuario ===");
            boolean registrado = authService.registerUser(userProfileManagement, "juan123", "Juan Pérez", "juan@mail.com", "1234", Client.CLIENT);
            System.out.println("Registro exitoso: " + registrado);

            System.out.println("\n=== Validación de Login ===");
            boolean login = authService.validate("juan123", "1234");
            System.out.println("Login exitoso: " + login);
            System.out.println("\n=== Perfil de Usuario ===");
            User user = userProfileManagement.getUserProfile("juan123");
            System.out.println("Nombre: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Rol: " + user.getRol());
            System.out.println("\n=== Asignar nuevo rol ===");
            roleManagement.assignUserRole(user, "Admin");
            System.out.println("Nuevo rol: " + user.getRol());

            System.out.println("\n=== Actualizar perfil ===");
            userProfileManagement.updateUserProfile("juan123", "Juan Actualizado", "juan_actualizado@mail.com");
            System.out.println("Nombre actualizado: " + user.getName());
            System.out.println("Email actualizado: " + user.getEmail());

            System.out.println("\n=== Acciones del Cliente ===");
            if (user instanceof Client client) {
                client.buyTicket("Ticket-001");
                client.playAttraction();
                System.out.println("Tickets comprados: " + client.getTickets());
            }


	        
	}
