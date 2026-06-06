package com.ticket.ticket.application.event;

import java.util.Optional;
import java.util.UUID;

import org.checkerframework.checker.units.qual.t;
import org.springframework.stereotype.Service;

import com.ticket.ticket.application.event.dto.TicketResponse;
import com.ticket.ticket.domain.event.Ticket;
import com.ticket.ticket.domain.event.TicketId;
import com.ticket.ticket.domain.event.TicketRepository;
import com.ticket.ticket.domain.exceptions.DomainException;
import com.ticket.ticket.infrastructure.persistense.TicketEntity;

@Service
public class PayTicketUseCase {
  private final TicketRepository ticketRepository;

  public PayTicketUseCase(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public TicketResponse execute(UUID id) {
    Optional<Ticket> possibleTicket = ticketRepository.findBy(new TicketId(id));
    if (possibleTicket.isEmpty())
      throw new DomainException("Its not possible to pay a inexistent ticket");
    Ticket ticket = possibleTicket.get();
    ticket.pay();
    ticketRepository.save(ticket);
    return TicketResponse.from(ticket);

  }
}
