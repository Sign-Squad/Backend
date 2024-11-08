package pe.upc.singlingo_backend.payments.domain.model.queries;

import jakarta.validation.constraints.NotBlank;

public record GetAllTransactionByUserIDQuery(
        @NotBlank long userID) {

}
