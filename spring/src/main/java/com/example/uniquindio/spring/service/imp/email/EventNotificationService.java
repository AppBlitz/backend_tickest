package com.example.uniquindio.spring.service.imp.email;
import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.model.documents.Event;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.repository.EventRepository;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.imp.event.EventService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventNotificationService {

    // Inject the EventRepository to fetch event data
    @Autowired
    private EventRepository eventRepository;

    // Inject the EmailService to send emails
    @Autowired
    private EmailService emailService;

    // Inject the EventService to handle event-related operations
    @Autowired
    private EventService eventService;

    // Inject the UserRepository to fetch user data
    @Autowired
    private UserRepository userRepository;

    // This method will be executed every day at 8:00 AM
    @Scheduled(cron = "0 0 8 * * ?")
    public void sendEventReminderEmails() {
        LocalDate today = LocalDate.now();
        LocalDate twoDaysLater = today.plusDays(2); // Calculate the date two days from today

        // Fetch all events that are scheduled for two days later
        List<Event> upcomingEvents = eventService.getAllEventsByDate(twoDaysLater);

        // Loop through the list of upcoming events
        for (Event event : upcomingEvents) {
            // Get the list of user IDs participating in the event
            @NonNull List<String> users = event.getUserList();

            // Send an email notification to each user
            for (String idUser : users) {
                User user = userRepository.findById(idUser).get(); // Fetch the user by their ID
                try {
                    // Send an email using the EmailService
                    emailService.sendEmail(
                            new EmailDTO(
                                    user.getEmail(), // User's email address
                                    getReminderMessage(event), // Message body of the email
                                    "Recordatorio: Tu evento está cerca" // Email subject
                            )
                    );
                } catch (Exception e) {
                    e.printStackTrace(); // Handle any exceptions that occur during the email sending process
                }
            }
        }
    }

    // Helper method to generate the reminder email content
    private String getReminderMessage(Event event) {
        return "Hola,\n\n" +
                "Te recordamos que el evento \"" + event.getNameEvent() + "\" está a solo 2 días de distancia.\n" +
                "Fecha del evento: " + event.getEventDate() + "\n\n" +
                "No olvides asistir.\n\n" +
                "Saludos,\nEl equipo de Unieventos";
    }
}
